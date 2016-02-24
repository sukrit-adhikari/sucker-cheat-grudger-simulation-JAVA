/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SuckerCheatGrudger_Simulation;

import mathematicalFunctions.*;
import BiologicalProcessModules.*;

/**
 *
 * @author Sukrit
 */
public class SimulationStatisticsUpdate {
    
    public static void updateSimulationStatistics(Individual iN,boolean birthOrDeath,String deathByNaturalOrInfectionOrAgeing){
        
       
        String MaleOrFemale = iN.getMaleOrFemale();                 
        String SuckerOrCheatOrGrudger=iN.getSuckerOrCheatOrGrudger();      
        boolean InfectedOrNot=iN.isInfectedOrNot();               
        String genes=iN.getGenes();                        
        String DominantGene=iN.getDominantGene();              
      
        
        
        if(birthOrDeath){
            SimulationStatistics.noOfBirths++;
        }else{
            if(deathByNaturalOrInfectionOrAgeing=="natural"){
            SimulationStatistics.noOfDeaths_Natural++;
            }
        }
        
        
        
        
        if(InfectedOrNot){
            SimulationStatistics.noOfInfectedIndividuals++;
        }else{
            ;
        }
        
        if(MaleOrFemale=="m"){
            if(birthOrDeath){
            SimulationStatistics.noOfMales++;
            }else{
            SimulationStatistics.noOfMales--;    
            }
        }else{
            if(birthOrDeath){
            SimulationStatistics.noOfFemales++;    
            }else{
            SimulationStatistics.noOfFemales--;        
            }
            
        }
        
        if(genes.indexOf("ss") != -1){
            if(birthOrDeath){
            SimulationStatistics.noOf_SS_Genes++;
            }else{
            SimulationStatistics.noOf_SS_Genes--;    
            }
        }
        else if(genes.indexOf("cc") != -1){
            if(birthOrDeath){
            SimulationStatistics.noOf_CC_Genes++;
            }else{
            SimulationStatistics.noOf_CC_Genes--;    
            }
        }
        else if(genes.indexOf("gg") != -1){
            if(birthOrDeath){
            SimulationStatistics.noOf_GG_Genes++;
            }else{
            SimulationStatistics.noOf_GG_Genes--;    
            }
        }
        else if(genes.indexOf("sc") !=-1 || genes.indexOf("cs") !=-1){
            if(birthOrDeath){
            SimulationStatistics.noOf_SC_Genes++;
            }else{
            SimulationStatistics.noOf_SC_Genes--;    
            }
        }
        else if(genes.indexOf("sg") !=-1 || genes.indexOf("gs") !=-1){
            if(birthOrDeath){
            SimulationStatistics.noOf_SG_Genes++;
            }else{
            SimulationStatistics.noOf_SG_Genes--;    
            }
        }
        else if(genes.indexOf("cg") !=-1 || genes.indexOf("gc") !=-1){
            if(birthOrDeath){
            SimulationStatistics.noOf_CG_Genes++;
            }else{
            SimulationStatistics.noOf_CG_Genes--;    
            }
        }
        
        if(SuckerOrCheatOrGrudger=="s"){
            if(birthOrDeath){
            SimulationStatistics.noOfSuckers++;
            SimulationStatistics.noOf_S_DominantGenes++;
            }else{
            SimulationStatistics.noOfSuckers--;
            SimulationStatistics.noOf_S_DominantGenes--;    
            }
        }else if(SuckerOrCheatOrGrudger=="c"){
            if(birthOrDeath){
            SimulationStatistics.noOfCheats++;
            SimulationStatistics.noOf_C_DominantGenes++;
            }else{
            SimulationStatistics.noOfCheats--;
            SimulationStatistics.noOf_C_DominantGenes--;    
            }
        }else if(SuckerOrCheatOrGrudger=="g"){
            if(birthOrDeath){
            SimulationStatistics.noOfGrudgers++;
            SimulationStatistics.noOf_G_DominantGenes++;
            }else{
            SimulationStatistics.noOfGrudgers--;
            SimulationStatistics.noOf_G_DominantGenes--;    
            }
        }
    }
    
}
