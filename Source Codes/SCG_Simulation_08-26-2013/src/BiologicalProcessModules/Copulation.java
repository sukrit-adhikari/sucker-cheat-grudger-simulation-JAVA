package BiologicalProcessModules;

import SuckerCheatGrudger_Simulation.*;
import java.util.Random;
import mathematicalFunctions.*;

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
        
        Random rand = new Random();
        char maleGameteGene = male.getGenes().charAt(rand.nextInt(1)); // Create male gamete with one of the Randomly chosen gene
        char femaleGameteGene = female.getGenes().charAt(rand.nextInt(1)); // Create male gamete with one of the Randomly chosen gene
        
        newBornGenes = String.valueOf(maleGameteGene)+String.valueOf(femaleGameteGene);
        newBornMaleOrFemale = String.valueOf("mf".charAt(rand.nextInt(1)));
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
            
            Probability pNewBornDominantGeneSC = new Probability(sP.getS_SCProbability());
            if(pNewBornDominantGeneSC.returnBooleanWithProbability()){
                newBornDominantGene="s";
            
                newBornSuckerOrCheatOrGrudger="s";
            }else{
                newBornDominantGene="c";
            
                newBornSuckerOrCheatOrGrudger="c";
            }
        }
        else if(newBornGenes.indexOf("sg") !=-1 || newBornGenes.indexOf("gs") !=-1){
            
            Probability pNewBornDominantGeneSG = new Probability(sP.getG_SGProbability());
            if(pNewBornDominantGeneSG.returnBooleanWithProbability()){
                newBornDominantGene="g";
                
                newBornSuckerOrCheatOrGrudger="g";
            }else{
                newBornDominantGene="s";
                
                newBornSuckerOrCheatOrGrudger="s";
            }
        }
        else if(newBornGenes.indexOf("cg") !=-1 || newBornGenes.indexOf("gc") !=-1){
            
            Probability pNewBornDominantGeneCG = new Probability(sP.getC_CGProbability());
            if(pNewBornDominantGeneCG.returnBooleanWithProbability()){
                newBornDominantGene="c";
                
                newBornSuckerOrCheatOrGrudger="c";
            }else{
                newBornDominantGene="g";
                
                newBornSuckerOrCheatOrGrudger="g";
            }
        }
        
        newBornIndividualID = String.valueOf(System.currentTimeMillis()) + String.valueOf(rand.nextInt(10000)) + newBornDominantGene;
        
        
        
        
        
        Individual newBornIndividual = new Individual(newBornIndividualID, newBornTimeOfCreation, newBornMaleOrFemale, newBornSuckerOrCheatOrGrudger, newBornInfectedOrNot, newBornHealth, newBornGenes, newBornDominantGene, newBornTotalBirthsGiven);
        
        SimulationStatisticsUpdate.updateSimulationStatistics(newBornIndividual, true,"NONE");// true Indicates BIRTH "NONE" indicated nothing of meaning to be passed GARBASE VALUE
        
        return newBornIndividual;
    }
    
    
    
}
