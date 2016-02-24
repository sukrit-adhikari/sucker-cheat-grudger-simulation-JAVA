package BiologicalProcessModules;
import SimulationOutputDisplayViaSwingWorker.LogWhileRunning;
import SuckerCheatGrudger_Simulation.*;
import mathematicalFunctions.*;
import java.util.ArrayList;


public class DeathAgeing{
       
    
    
   public ArrayList AgeIndividuals(SimulationParameters sP,ArrayList<Individual> iN ) {

       
       Integer i;
       Integer initialIndividualsSize;
       initialIndividualsSize = iN.size();
       
       ArrayList<Individual> individualsToBeCopiedHere = new ArrayList<Individual>();
       
       
       
       for(i=iN.size()-1;i>=0;i--){
           
           if( (SimulationStatistics.globalTime - iN.get(i).getTimeOfCreation()) >=  sP.getLifeExpectancy()){ // Killed Individuals NOT cOPIED 
               
               LogWhileRunning.logIndividualParameters(iN.get(i),"Death:: Life Expectancy Complete");
               
               
               SimulationStatisticsUpdate.updateSimulationStatistics(iN.get(i), false, "ageing"); // False indicates DEATH
               
           }else{ // Surviving Individuals
               individualsToBeCopiedHere.add(iN.get(i));
           }
       }

       iN.clear();                          // Clears the Original Individual IT FREES MEMORY
       
       return individualsToBeCopiedHere;
   }
}