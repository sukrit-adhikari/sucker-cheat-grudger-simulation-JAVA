package SuckerCheatGrudger_Simulation;

public class SimulationStatistics {

   public static Integer globalTime=0; 
    
   public static  Integer noOfSuckers=0;
   public static  Integer noOfCheats=0;
   public static  Integer noOfGrudgers=0;
    
   public static  Integer noOfInfectedIndividuals=0;
   
   public static  Integer noOfBirths=0;
   public static  Integer noOfDeaths_Natural=0;
   public static  Integer noOfDeaths_Ageing=0;
   public static  Integer noOfDeaths_Infection=0;
   
   
   public static  Integer noOf_SS_Genes=0;
   public static  Integer noOf_CC_Genes=0;
   public static  Integer noOf_GG_Genes=0;
   public static  Integer noOf_SC_Genes=0;
   public static  Integer noOf_CG_Genes=0;
   public static  Integer noOf_SG_Genes=0;
   
   
   public static  Integer noOf_S_DominantGenes=0;
   public static  Integer noOf_C_DominantGenes=0;
   public static  Integer noOf_G_DominantGenes=0;
    
   public static Integer noOfMales=0;
   public static Integer noOfFemales=0;
   
   
  public static void resetSimulationStatistics(){
   
    globalTime=0;  
      
    noOfSuckers=0;
    noOfCheats=0;
    noOfGrudgers=0;
    
    noOfInfectedIndividuals=0;
   
    noOfBirths=0;
    noOfDeaths_Natural=0;
    noOfDeaths_Ageing=0;
    noOfDeaths_Infection=0;
   
   
    noOf_SS_Genes=0;
    noOf_CC_Genes=0;
    noOf_GG_Genes=0;
    noOf_SC_Genes=0;
    noOf_CG_Genes=0;
    noOf_SG_Genes=0;
   
   
    noOf_S_DominantGenes=0;
    noOf_C_DominantGenes=0;
    noOf_G_DominantGenes=0;
    
    noOfMales=0;
    noOfFemales=0;
   }

    
}