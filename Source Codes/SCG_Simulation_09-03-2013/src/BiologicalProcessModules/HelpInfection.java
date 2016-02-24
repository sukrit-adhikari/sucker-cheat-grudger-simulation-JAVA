/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BiologicalProcessModules;

import SimulationOutputDisplayViaSwingWorker.LogWhileRunning;
import SuckerCheatGrudger_Simulation.Individual;
import SuckerCheatGrudger_Simulation.SimulationParameters;
import SuckerCheatGrudger_Simulation.SimulationProbabilityStore;
import SuckerCheatGrudger_Simulation.SimulationStatistics;
import SuckerCheatGrudger_Simulation.SimulationStatisticsUpdate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sukrit
 */
public class HelpInfection {

    public ArrayList help(SimulationParameters sP, ArrayList<Individual> iN) {


        Integer i;
        Integer initialIndividualsSize;
        initialIndividualsSize = iN.size();
        ArrayList<Individual> individualsToBeCopiedHere = new ArrayList<Individual>();

        Random randomIndividual = new Random();
        Integer askHelpFrom;
        Float newHealth;
        Float newHealthOfHelper;
        
        

        if(iN.size()==1){ 
            iN.get(0).setHealth(iN.get(0).getHealth()-sP.getHealthDecreasePerTime());
            if(iN.get(0).getHealth()<=0){ // Kill the remaining one individual as he will not get help from himself.
                iN.clear();
            }
            
            
            return iN;
        }
        
        
        
        for (i = initialIndividualsSize-1; i >= 0; i--) {
            
            
            
            if(initialIndividualsSize==2){ //  Afai sanga HELP MAGNA MILDAINA
                    
                        if(i==0){
                            askHelpFrom=1;
                        }else{
                            askHelpFrom=0;
                        }
                        
                    
              }else{
               boolean doAgain=false;
                    do{
                        doAgain=false;
                        askHelpFrom = randomIndividual.nextInt(initialIndividualsSize - 1);
                        if(iN.get(i).getSuckerOrCheatOrGrudger()=="g" && iN.get(i).getGrudgeList().contains(iN.get(askHelpFrom).getIndividualID()) ){
                                doAgain=true;
                                
                        }
                    }while(i==askHelpFrom || doAgain );//Cannot ask help from oneself
              }

            if (iN.get(i).isInfectedOrNot()) { // Find Infected or Not
                
                LogWhileRunning.logEvents("> "+iN.get(i).getSuckerOrCheatOrGrudger().toUpperCase()+" asked help from "+iN.get(askHelpFrom).getSuckerOrCheatOrGrudger().toUpperCase());
                
                if (iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() == "s") { // SUCKER DIRECTLY HELPS
                    LogWhileRunning.logEvents("  >> "+"S helped "+iN.get(i).getSuckerOrCheatOrGrudger().toUpperCase());
                    newHealth = iN.get(i).getHealth() + sP.getHealthIncreasePerHelp();
                    if (newHealth > sP.getStartingHealth()) {
                        newHealth = sP.getStartingHealth();
                    }
                    newHealthOfHelper = iN.get(askHelpFrom).getHealth()-sP.getHealthDecreasePerHelpGiven();
                    iN.get(askHelpFrom).setHealth(newHealthOfHelper);
                    iN.get(i).setHealth(newHealth);
                    //System.out.println(iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() + " HELPED " + iN.get(i).getSuckerOrCheatOrGrudger());
                } else if (iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() == "c") {
                    LogWhileRunning.logEvents("  >> "+"C did not help "+iN.get(i).getSuckerOrCheatOrGrudger().toUpperCase());
                    
                    // Do nothing as no HELP Recieved from cheat
                    //System.out.println(iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() + " DID NOT HELP " + iN.get(i).getSuckerOrCheatOrGrudger());

                    newHealth = iN.get(i).getHealth() - sP.getHealthDecreasePerTime();
                    iN.get(i).setHealth(newHealth);

                    if (iN.get(i).getSuckerOrCheatOrGrudger() == "g") { // Grudger Does not Receive Help so update Grudge List
                        iN.get(i).getGrudgeList().add(iN.get(askHelpFrom).getIndividualID());
                        LogWhileRunning.logEvents("    >>> "+"Grudge against CHEAT "+iN.get(askHelpFrom).getIndividualID()+" remembered by "+iN.get(i).getIndividualID());
                    }
                } else if (iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() == "g") {
                    if (!iN.get(askHelpFrom).getGrudgeList().contains(iN.get(i).getIndividualID())) { // If askHelpFrom individual does not have grudge asgainst 'i' i.e who is asking help
                        
                        LogWhileRunning.logEvents("  >> "+"G helped "+iN.get(i).getSuckerOrCheatOrGrudger().toUpperCase());
                        
                        newHealth = iN.get(i).getHealth() + sP.getHealthIncreasePerHelp();
                        if (newHealth > sP.getStartingHealth()) {
                            newHealth = sP.getStartingHealth();
                        }
                        //System.out.println(iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() + " HELPED " + iN.get(i).getSuckerOrCheatOrGrudger());
                    newHealthOfHelper = iN.get(askHelpFrom).getHealth()-sP.getHealthDecreasePerHelpGiven();
                    iN.get(askHelpFrom).setHealth(newHealthOfHelper);

                        
                        
                        iN.get(i).setHealth(newHealth);
                    } else {
                        LogWhileRunning.logEvents("  >> "+"G did not help "+iN.get(i).getSuckerOrCheatOrGrudger().toUpperCase());
                        newHealth = iN.get(i).getHealth() - sP.getHealthDecreasePerTime();
                        iN.get(i).setHealth(newHealth);
                        //System.out.println(iN.get(askHelpFrom).getSuckerOrCheatOrGrudger() + " DID NOT HELP " + iN.get(i).getSuckerOrCheatOrGrudger());
                    }
                }
                    
                
                
            } else { // NON INFECTED INDIVIDUALS do not ask HELP
            ;    
            }
        }

        for(i=0;i<=initialIndividualsSize-1;i++){
            if (iN.get(i).getHealth() <= 0) {// NO HEALTH so KILL
                    LogWhileRunning.logIndividualParameters(iN.get(i), "Death:: Infection (Health<=0) ");
                    SimulationStatisticsUpdate.updateSimulationStatistics(iN.get(i), false, "infection");
                    //System.out.println(iN.get(i).getSuckerOrCheatOrGrudger()+" died of infection...");
                } else {
                    individualsToBeCopiedHere.add(iN.get(i));
                }
        }
        
        iN.clear();                          // Clears the Original Individual IT FREES MEMORY

        return individualsToBeCopiedHere;
    }
    
    
}
