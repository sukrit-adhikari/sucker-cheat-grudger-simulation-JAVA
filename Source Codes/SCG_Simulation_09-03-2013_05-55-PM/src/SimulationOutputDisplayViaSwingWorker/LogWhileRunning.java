/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SimulationOutputDisplayViaSwingWorker;
import java.util.ArrayList;
import SuckerCheatGrudger_Simulation.*;
/**
 *
 * @author Sukrit
 */
public class LogWhileRunning {
    
    public static ArrayList<String> log = new ArrayList<String>();

    public static void logIndividualParameters(Individual iN, String what) {
        LogWhileRunning.log.add(iN.getSuckerOrCheatOrGrudger().toUpperCase()+" "+what+" :: "+"Gender :: "+iN.getMaleOrFemale().toUpperCase()+" Infected ::"+iN.isInfectedOrNot()+" at "+SimulationStatistics.globalTime);
    }
    
    public static void logEvents(String event){
        LogWhileRunning.log.add(event);
                
    }
    
}
