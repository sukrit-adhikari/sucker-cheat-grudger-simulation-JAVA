package BiologicalProcessModules;

import SimulationOutputDisplayViaSwingWorker.LogWhileRunning;
import SuckerCheatGrudger_Simulation.*;
import java.util.Random;


public class Copulation {
    
    public static Individual copulateTwoIndividual(Individual male, Individual female, SimulationParameters sP,Integer time){
        
       
        String newBornIndividualID;
        Integer newBornTimeOfCreation;              
        String newBornMaleOrFemale;                 
        String newBornSuckerOrCheatOrGrudger="";    // GARBAGE Initialiation as it be be SURELY changed   
        boolean newBornInfectedOrNot;               
        Float newBornHealth = new Float(100.0);     
        String newBornGenes;                        
        String newBornDominantGene="";              // GARBAGE Initialiation as it be be SURELY changed
        Integer newBornTotalBirthsGiven=0;          
        
        char maleGameteGene;
        char femaleGameteGene;
        
        
        
        Random rand = new Random();
        
        if(SimulationProbabilityStore.gameteCreationProbabilityObject.returnBooleanWithProbability()){
            maleGameteGene = male.getGenes().charAt(0);
        }else{
            maleGameteGene = male.getGenes().charAt(1);
        }
        
        if(SimulationProbabilityStore.gameteCreationProbabilityObject.returnBooleanWithProbability()){
            femaleGameteGene = female.getGenes().charAt(0); 
        }else{
            femaleGameteGene = female.getGenes().charAt(1); 
        }
         
         
        
        newBornGenes = String.valueOf(maleGameteGene)+String.valueOf(femaleGameteGene);
        
        if(SimulationProbabilityStore.maleFemaleProbabilityObject.returnBooleanWithProbability()){
            newBornMaleOrFemale="m";
        }else{
            newBornMaleOrFemale="f";
        }
        
       // System.out.println(newBornMaleOrFemale);
        
        newBornTimeOfCreation = time;
        
        if(male.isInfectedOrNot() && female.isInfectedOrNot()){
            newBornInfectedOrNot = true;
            
        }else{
            newBornInfectedOrNot = false;
        }
        
        if(newBornGenes.indexOf("ss") != -1){
            newBornDominantGene="s";
            
            newBornSuckerOrCheatOrGrudger="s";
        }
        else if(newBornGenes.indexOf("cc") != -1){
            newBornDominantGene="c";
            
            newBornSuckerOrCheatOrGrudger="c";
        }
        else if(newBornGenes.indexOf("gg") != -1){
            newBornDominantGene="g";
            
            newBornSuckerOrCheatOrGrudger="g";
        }
        else if(newBornGenes.indexOf("sc") !=-1 || newBornGenes.indexOf("cs") !=-1){
            
            
            if(SimulationProbabilityStore.s_SCProbabilityObject.returnBooleanWithProbability()){
                newBornDominantGene="s";
            
                newBornSuckerOrCheatOrGrudger="s";
            }else{
                newBornDominantGene="c";
            
                newBornSuckerOrCheatOrGrudger="c";
            }
        }
        else if(newBornGenes.indexOf("sg") !=-1 || newBornGenes.indexOf("gs") !=-1){
            
            
            if(SimulationProbabilityStore.g_SGProbabilityObject.returnBooleanWithProbability()){
                newBornDominantGene="g";
                
                newBornSuckerOrCheatOrGrudger="g";
            }else{
                newBornDominantGene="s";
                
                newBornSuckerOrCheatOrGrudger="s";
            }
        }
        else if(newBornGenes.indexOf("cg") !=-1 || newBornGenes.indexOf("gc") !=-1){
            
            
            if(SimulationProbabilityStore.c_CGProbabilityObject.returnBooleanWithProbability()){
                newBornDominantGene="c";
                
                newBornSuckerOrCheatOrGrudger="c";
            }else{
                newBornDominantGene="g";
                
                newBornSuckerOrCheatOrGrudger="g";
            }
        }
        
        newBornIndividualID = String.valueOf(System.currentTimeMillis()) + String.valueOf(rand.nextInt(10000)) + newBornDominantGene;
        Individual newBornIndividual = new Individual(newBornIndividualID, newBornTimeOfCreation, newBornMaleOrFemale, newBornSuckerOrCheatOrGrudger, newBornInfectedOrNot, newBornHealth, newBornGenes, newBornDominantGene, newBornTotalBirthsGiven);
        
        LogWhileRunning.logIndividualParameters(newBornIndividual,"Birth");
        
        SimulationStatisticsUpdate.updateSimulationStatistics(newBornIndividual, true,"NONE");// true Indicates BIRTH "NONE" indicated nothing of meaning to be passed GARBASE VALUE
        return newBornIndividual;
    }
}
