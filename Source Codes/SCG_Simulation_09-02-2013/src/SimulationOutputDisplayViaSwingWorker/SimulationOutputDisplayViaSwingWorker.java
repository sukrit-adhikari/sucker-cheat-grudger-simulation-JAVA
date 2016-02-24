package SimulationOutputDisplayViaSwingWorker;

//Import all Packages I Created //
import BiologicalProcessModules.*;
import SuckerCheatGrudger_Simulation.*;
import mathematicalFunctions.*;
//..............................//


import java.util.List;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;


import java.awt.Event;
import java.util.ArrayList;
import java.util.Random;

public class SimulationOutputDisplayViaSwingWorker extends SwingWorker<Integer, Object[]> {

    SuckerCheatGrudger_Simulation mainFrame;
    ArrayList<Individual> individuals = new ArrayList<Individual>();
    SimulationParameters sP;

    public SimulationOutputDisplayViaSwingWorker(SuckerCheatGrudger_Simulation JFrame, SimulationParameters sPP) {
        this.mainFrame = JFrame;
        this.sP = sPP;
        createIndividuals(sP);
    }

    @Override
    protected Integer doInBackground() throws Exception {
        publish(new Object[]{0, (SimulationStatistics.noOfMales + SimulationStatistics.noOfFemales), SimulationStatistics.noOfBirths, SimulationStatistics.noOfDeaths_Natural, SimulationStatistics.noOfDeaths_Ageing, SimulationStatistics.noOfDeaths_Infection, SimulationStatistics.noOfSuckers, SimulationStatistics.noOfCheats, SimulationStatistics.noOfGrudgers, SimulationStatistics.noOfInfectedIndividuals, SimulationStatistics.noOf_SS_Genes, SimulationStatistics.noOf_CC_Genes, SimulationStatistics.noOf_GG_Genes, SimulationStatistics.noOf_SC_Genes, SimulationStatistics.noOf_SG_Genes, SimulationStatistics.noOf_CG_Genes, SimulationStatistics.noOfMales, SimulationStatistics.noOfFemales});
        
        for (Integer globalTime = 1; globalTime <= sP.getTotalIterations(); globalTime++) {
            java.util.Collections.shuffle(individuals);
            if (SimulationStatistics.noOfMales > 0 && SimulationStatistics.noOfFemales > 0) {

                SimulationStatistics.noOfBirths = 0;              // Reset no. of Births for this particular Iteration
                SimulationStatistics.noOfDeaths_Natural = 0;      // Reset ...........................................
                SimulationStatistics.noOfDeaths_Infection = 0;    // Reset ...........................................
                SimulationStatistics.noOfDeaths_Ageing = 0;       // Reset ..........................................

                
                //System.out.println("Before Copulate...");
                if (sP.getCopulationProbability() != 0) {
                    copulate(sP, SimulationStatistics.globalTime);
                }
                //System.out.println("After Copulate...");
                if (sP.getDeathFromNaturalCauseProbability() != 0) {
                    killAnIndividualNaturalDeath(sP);
                }
                
                //System.out.println("Before AgeIndividuals...");
                ageIndividuals(sP);
                //System.out.println("After AgeIndividuals...");    
                
                //System.out.println("Before Infect...");
                infect(sP);
                //System.out.println("After Infect...");
                
                //System.out.println("Before askHelp");
                if(globalTime!=1){
                    askHelp(sP);
                }
                //System.out.println("After AskHelp...");

            } else {
                if (SimulationStatistics.noOfFemales == 0 && SimulationStatistics.noOfMales == 0) {
                    mainFrame.lbl_notifyWhySimulationHasEnded.setText("Simulation has ended as the entire population has gone extinct.");
                } else if (SimulationStatistics.noOfFemales == 0) {
                    mainFrame.lbl_notifyWhySimulationHasEnded.setText("Simulation has ended as there are no Females left in the population.");
                } else if (SimulationStatistics.noOfMales == 0) {
                    mainFrame.lbl_notifyWhySimulationHasEnded.setText("Simulation has ended as there are no Males left in the population.");
                }
                mainFrame.jProgressBar_SimulationStatus.setValue(100);
                mainFrame.jProgressBar_SimulationStatus.setString("100%");
                break;
            }
            publish(new Object[]{globalTime, (SimulationStatistics.noOfMales + SimulationStatistics.noOfFemales), SimulationStatistics.noOfBirths, SimulationStatistics.noOfDeaths_Natural, SimulationStatistics.noOfDeaths_Ageing, SimulationStatistics.noOfDeaths_Infection, SimulationStatistics.noOfSuckers, SimulationStatistics.noOfCheats, SimulationStatistics.noOfGrudgers, SimulationStatistics.noOfInfectedIndividuals, SimulationStatistics.noOf_SS_Genes, SimulationStatistics.noOf_CC_Genes, SimulationStatistics.noOf_GG_Genes, SimulationStatistics.noOf_SC_Genes, SimulationStatistics.noOf_SG_Genes, SimulationStatistics.noOf_CG_Genes, SimulationStatistics.noOfMales, SimulationStatistics.noOfFemales});
            SimulationStatistics.globalTime++;
        }
        
        mainFrame.check_enableLiveLogging.setEnabled(true);
        mainFrame.btn_startSimulation.setEnabled(true);
        return 0;
    }

    private void createIndividuals(SimulationParameters sP) {

        SimulationStatistics.resetSimulationStatistics();
        individuals.clear();


        Integer s = sP.getNoOfSuckers();
        Integer c = sP.getNoOfCheats();
        Integer g = sP.getNoOfGrudgers();

        SimulationStatistics.noOfSuckers = s;
        SimulationStatistics.noOfCheats = c;
        SimulationStatistics.noOfGrudgers = g;

        Integer i;
        Float maleFemaleProbability = new Float(sP.getMaleFemaleProbability());
        String maleOrFemale;
        Probability p = new Probability(maleFemaleProbability);
        Random randomNo = new Random();
        String individualID;

        for (i = 1; i <= s; i++) { // Create suckers with pure SS genes
            if (p.returnBooleanWithProbability() == true) {  // Selecting male or female with 50%/50% probability
                maleOrFemale = "m";
                SimulationStatistics.noOfMales++;
            } else {
                maleOrFemale = "f";
                SimulationStatistics.noOfFemales++;
            }
            individualID = String.valueOf(System.currentTimeMillis()) + String.valueOf(randomNo.nextInt(10000)) + "s";

            Individual newIndividual = new Individual(individualID, 0, maleOrFemale, "s", false, sP.getStartingHealth(), "ss", "s", 0);
            SimulationStatistics.noOf_SS_Genes++;
            SimulationStatistics.noOf_S_DominantGenes++;
            individuals.add(newIndividual);
        }
        for (i = 1; i <= c; i++) { // Create cheats with pure CC genes
            if (p.returnBooleanWithProbability() == true) {  // Selecting male or female with 50%/50% probability
                maleOrFemale = "m";
                SimulationStatistics.noOfMales++;
            } else {
                maleOrFemale = "f";
                SimulationStatistics.noOfFemales++;
            }
            individualID = String.valueOf(System.currentTimeMillis()) + String.valueOf(randomNo.nextInt(10000)) + "c";

            Individual newIndividual = new Individual(individualID, 0, maleOrFemale, "c", false, sP.getStartingHealth(), "cc", "c", 0);
            SimulationStatistics.noOf_CC_Genes++;
            SimulationStatistics.noOf_C_DominantGenes++;
            individuals.add(newIndividual);
        }
        for (i = 1; i <= g; i++) { // Create grudgers with pure GG genes
            if (p.returnBooleanWithProbability() == true) {  // Selecting male or female with 50%/50% probability
                maleOrFemale = "m";
                SimulationStatistics.noOfMales++;
            } else {
                maleOrFemale = "f";
                SimulationStatistics.noOfFemales++;
            }
            individualID = String.valueOf(System.currentTimeMillis()) + String.valueOf(randomNo.nextInt(10000)) + "g";

            Individual newIndividual = new Individual(individualID, 0, maleOrFemale, "g", false, sP.getStartingHealth(), "gg", "g", 0);
            SimulationStatistics.noOf_GG_Genes++;
            SimulationStatistics.noOf_G_DominantGenes++;
            individuals.add(newIndividual);

        }
        // All Individuals have now been created. Now pass these individuals to SuddenNaturalDeath and SEE WHO gets killed and who survives
    }

    private void ageIndividuals(SimulationParameters sP){
        DeathAgeing dA = new DeathAgeing();
        individuals = dA.AgeIndividuals(sP, individuals);
    }
    
    
    private void killAnIndividualNaturalDeath(SimulationParameters sP) {
        if (individuals.size() == 0 || individuals.isEmpty()) {
            mainFrame.lbl_notifyWhySimulationHasEnded.setText("Simulation has ended as the entire population has gone extinct.");
            return;
        }

        SuddenNaturalDeath sN = new SuddenNaturalDeath();
        individuals = sN.SuddenNaturalDeath(sP, individuals);
    }

    private void copulate(SimulationParameters sP, Integer time) {
        if (individuals.size() == 0 || individuals.isEmpty()) {
            mainFrame.lbl_notifyWhySimulationHasEnded.setText("Simulation has ended as the entire population has gone extinct.");
            return;
        }

        ArrayList<Integer> whoGotChanceToCopulate = new ArrayList<Integer>();
        Integer i;
        Individual male = null;                 // GARBAGE Initialiation as it be be SURELY changed
        Integer maleIndexInIndividuals = -1;      // GARBAGE Initialiation as it be be SURELY changed
        Individual female = null;               // GARBAGE Initialiation as it be be SURELY changed
        Integer femaleIndexInIndividuals = -1;    // GARBAGE Initialiation as it be be SURELY changed
        boolean gotMale = false;
        boolean gotFemale = false;
        Integer initialPopulationSize = individuals.size();
        

        while (whoGotChanceToCopulate.size() != (initialPopulationSize)) { // RUN LOOP Until every one gets chance to Copulate with RANDOM EACH OTHER 
            //System.out.println(whoGotChanceToCopulate.size());
            for (i = 0; i <= (initialPopulationSize - 1); i++) { // FIND male and female WHO have not Copulated 
                if (!whoGotChanceToCopulate.contains(i)) {
                    if (individuals.get(i).getMaleOrFemale() == "m" && gotMale == false) {
                        whoGotChanceToCopulate.add(i);
                        maleIndexInIndividuals = i;
                        male = individuals.get(i);
                        gotMale = true;
                    }
                    if (individuals.get(i).getMaleOrFemale() == "f" && gotFemale == false && individuals.get(i).getTotalBirthsGiven() < sP.getMaximumReproductionCapabilityOfFemale()) {
                        whoGotChanceToCopulate.add(i);
                        femaleIndexInIndividuals = i;
                        female = individuals.get(i);
                        gotFemale = true;
                    }
                }

                if (gotFemale && gotMale) {
                    break;
                }
            }// At this point all the population has been checked to find male and female "ADULTS" . Newborns are added at the end of individuals list. So they are not considered for copulation.
            
            
            if (!gotFemale || !gotMale) { // No female OR No male Found in the entire ADULT population

                return;// Abort COPULATION Process....
            }
            gotFemale = false; // For NEXT LOOP
            gotMale = false; // For NEXT LOOP    
            
            if (SimulationProbabilityStore.copulationProbabilityObject.returnBooleanWithProbability()) {
                

                Individual newBornIndividual = Copulation.copulateTwoIndividual(male, female, sP, time);
                //System.out.println("\n***********************************************************************\n");
                //System.out.println("Following Individual is BORN ...!!!");
                // Utilities.displayIndividualParameters(newBornIndividual);
                // System.out.println("\n***********************************************************************\n");
                //System.out.println(maleIndexInIndividuals+" && "+femaleIndexInIndividuals);
                individuals.add(newBornIndividual);
                individuals.get(maleIndexInIndividuals).setTotalBirthsGiven(individuals.get(maleIndexInIndividuals).getTotalBirthsGiven() + 1);
                individuals.get(femaleIndexInIndividuals).setTotalBirthsGiven(individuals.get(femaleIndexInIndividuals).getTotalBirthsGiven() + 1);
            }

        }
    }

    private void infect(SimulationParameters sP){
        if (individuals.size() == 0 || individuals.isEmpty()) {
            mainFrame.lbl_notifyWhySimulationHasEnded.setText("Simulation has ended as the entire population has gone extinct.");
            return;
        }
        InfectIndividuals iI = new InfectIndividuals();
        individuals = iI.infect(sP, individuals);
    }
    
    private void askHelp(SimulationParameters sP){
        HelpInfection hI = new HelpInfection();
        individuals = hI.help(sP, individuals);
        
    }
    
    @Override
    protected void process(List<Object[]> chunks) {
            Integer progressOfSimulation = (SimulationStatistics.globalTime * 100) / (sP.getTotalIterations());
        try {
            
            Integer suckersPercentage = (SimulationStatistics.noOfSuckers * 100) / (SimulationStatistics.noOfMales + SimulationStatistics.noOfFemales);
            Integer cheatsPercentage = (SimulationStatistics.noOfCheats * 100) / (SimulationStatistics.noOfMales + SimulationStatistics.noOfFemales);
            Integer grudgersPercentage = (SimulationStatistics.noOfGrudgers * 100) / (SimulationStatistics.noOfMales + SimulationStatistics.noOfFemales);

            mainFrame.jProgressBar_SimulationStatus.setValue(progressOfSimulation);
            mainFrame.jProgressBar_SimulationStatus.setString(Integer.toString(progressOfSimulation) + "%");

            mainFrame.jProgressBar_SuckersPercentage.setValue(suckersPercentage);
            mainFrame.jProgressBar_CheatsPercentage.setValue(cheatsPercentage);
            mainFrame.jProgressBar_GrudgersPercentage.setValue(grudgersPercentage);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if(mainFrame.check_enableLiveLogging.isSelected()){
            Integer noOfLogsDisplay=0;
            while(  (!LogWhileRunning.log.isEmpty() && noOfLogsDisplay<=40) ||((!LogWhileRunning.log.isEmpty() && progressOfSimulation>=99))  ){ // Until its Empty
             mainFrame.txtArea_log.append(LogWhileRunning.log.get(0)+"\n");
             LogWhileRunning.log.remove(0);
             noOfLogsDisplay++;
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) mainFrame.simulationStatisticsTable.getModel();
        for (Integer freshData = 0; freshData <= chunks.size() - 1; freshData++) {

            model.addRow(chunks.get(freshData));

        }
    }
    
    
}