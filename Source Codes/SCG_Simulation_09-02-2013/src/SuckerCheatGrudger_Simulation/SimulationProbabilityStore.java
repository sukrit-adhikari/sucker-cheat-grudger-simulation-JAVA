/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SuckerCheatGrudger_Simulation;

import mathematicalFunctions.Probability;

/**
 *
 * @author Sukrit
 */
public class SimulationProbabilityStore {
    
    public static Probability deathFromNaturalCauseProbabilityObject = new Probability();    
    public static Probability infectionProbabilityObject = new Probability();    
    public static Probability maleFemaleProbabilityObject = new Probability();    
    public static Probability s_SCProbabilityObject = new Probability();    
    public static Probability g_SGProbabilityObject = new Probability();    
    public static Probability c_CGProbabilityObject = new Probability();    
    public static Probability copulationProbabilityObject = new Probability();
    public static Probability gameteCreationProbabilityObject = new Probability();
    
    public void changeProbability(SimulationParameters sP){
        deathFromNaturalCauseProbabilityObject.changeProbabilityArray(sP.getDeathFromNaturalCauseProbability());
        infectionProbabilityObject.changeProbabilityArray(sP.getInfectionProbability());
        maleFemaleProbabilityObject.changeProbabilityArray(sP.getMaleFemaleProbability());
        s_SCProbabilityObject.changeProbabilityArray(sP.getS_SCProbability());
        g_SGProbabilityObject.changeProbabilityArray(sP.getG_SGProbability());
        c_CGProbabilityObject.changeProbabilityArray(sP.getC_CGProbability());
        copulationProbabilityObject.changeProbabilityArray(sP.getCopulationProbability());
        
        Float gameteCreation = new Float(50);
        gameteCreationProbabilityObject.changeProbabilityArray(gameteCreation);
    }
        
    
    
    
    
}
