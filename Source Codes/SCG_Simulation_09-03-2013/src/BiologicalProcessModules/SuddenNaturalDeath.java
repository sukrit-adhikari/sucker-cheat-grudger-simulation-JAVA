package BiologicalProcessModules;
import SimulationOutputDisplayViaSwingWorker.LogWhileRunning;
import SuckerCheatGrudger_Simulation.*;
import mathematicalFunctions.*;
import java.util.ArrayList;


public class SuddenNaturalDeath{
       
    
    
   public ArrayList SuddenNaturalDeath(SimulationParameters sP, ArrayList<Individual> iN ) {

       
       Integer i;
       Integer initialIndividualsSize;
       initialIndividualsSize = iN.size();
       Integer finalWithNullSize;
       ArrayList<Individual> individualsToBeCopiedHere = new ArrayList<Individual>();
       
       for(i=iN.size()-1;i>=0;i--){
           
           if(SimulationProbabilityStore.deathFromNaturalCauseProbabilityObject.returnBooleanWithProbability()==true){ // Killed Individuals NOT cOPIED 
               LogWhileRunning.logIndividualParameters(iN.get(i),"Death:: Natural Sudden");
               SimulationStatisticsUpdate.updateSimulationStatistics(iN.get(i), false, "natural"); // False indicates DEATH
               //iN.get(i).setKillThis(true);
           }else{ // Surviving Individuals
               individualsToBeCopiedHere.add(iN.get(i));
           }
       }

       iN.clear();                          // Clears the Original Individual IT FREES MEMORY
       
       return individualsToBeCopiedHere;
       
   }
}