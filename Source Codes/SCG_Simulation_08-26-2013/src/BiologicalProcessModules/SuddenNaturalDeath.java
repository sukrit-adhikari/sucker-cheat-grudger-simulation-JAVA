package BiologicalProcessModules;
import SuckerCheatGrudger_Simulation.*;
import mathematicalFunctions.*;
import java.util.ArrayList;
import java.util.Random;

public class SuddenNaturalDeath{
       
    
    
   public ArrayList SuddenNaturalDeath(SimulationParameters sP, ArrayList<Individual> iN ) {

       Probability p = new Probability(sP.getDeathFromNaturalCauseProbability());
       Integer i;
       Integer initialIndividualsSize;
       initialIndividualsSize = iN.size();
       
       ArrayList<Individual> individualsToBeCopiedHere = new ArrayList<Individual>();
       
       
       
       for(i=iN.size()-1;i>=0;i--){
           
           if(p.returnBooleanWithProbability()==true){
               
               
              // System.out.println("\n***********************************************************************\n");
              // System.out.println("An individual with following Parameters will now be killed ::");
               
               //Utilities.displayIndividualParameters(iN.get(i));
               
               SimulationStatisticsUpdate.updateSimulationStatistics(iN.get(i), false, "natural"); // False indicates DEATH
               //System.out.println("Killed!!!");
               //System.out.println("\n***********************************************************************\n");
               
           }else{ // Surviving Individuals
               individualsToBeCopiedHere.add(iN.get(i));
           }
       }

       
       
       return individualsToBeCopiedHere;
   }
}