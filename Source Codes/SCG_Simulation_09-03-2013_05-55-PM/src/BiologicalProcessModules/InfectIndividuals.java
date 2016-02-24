/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BiologicalProcessModules;

import SimulationOutputDisplayViaSwingWorker.LogWhileRunning;
import SuckerCheatGrudger_Simulation.Individual;
import SuckerCheatGrudger_Simulation.*;
import java.util.ArrayList;

/**
 *
 * @author Sukrit
 */
public class InfectIndividuals {
    
     public ArrayList infect(SimulationParameters sP, ArrayList<Individual> iN ) {

       
       Integer i;
       Integer initialIndividualsSize;
       initialIndividualsSize = iN.size();
       
       ArrayList<Individual> individualsToBeCopiedHere = new ArrayList<Individual>();
       
       
       
       for(i=iN.size()-1;i>=0;i--){
           
           if(SimulationProbabilityStore.infectionProbabilityObject.returnBooleanWithProbability()==true){
               
               
               if(!iN.get(i).isInfectedOrNot()){ // Only infect if not already infected.
                iN.get(i).setInfectedOrNot(true);
                LogWhileRunning.logIndividualParameters(iN.get(i),"Got Infected");
                SimulationStatistics.noOfInfectedIndividuals++;
               }
               individualsToBeCopiedHere.add(iN.get(i)); //  Infect an Individual and COPY HERE
           }else{ // Not Infected Individuals
               individualsToBeCopiedHere.add(iN.get(i)); //  Do not Infect Individual and Copy HERE
           }
       }
       iN.clear(); // Clears the Original Individual IT FREES MEMORY
       return individualsToBeCopiedHere;
   }
}
