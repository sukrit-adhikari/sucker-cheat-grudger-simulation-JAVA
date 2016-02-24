/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SuckerCheatGrudger_Simulation;

/**
 *
 * @author Sukrit
 */
public class Utilities {

    static String removePercentageSign(String a){
        
        return a.substring(0, a.length()-1);
        
    }
    
    public static void displayIndividualParameters(Individual iN){
        System.out.println("Individual ID :: "+iN.getIndividualID());
        System.out.println("Time of Creation :: "+iN.getTimeOfCreation());
        System.out.println("Male or Female :: "+iN.getMaleOrFemale());
        System.out.println("Sucker or Cheat or Grudger :: "+iN.getSuckerOrCheatOrGrudger());
        System.out.println("Infected or Not :: "+iN.isInfectedOrNot());
        System.out.println("Health% :: "+iN.getHealth()+"%");
        System.out.println("Genes :: "+iN.getGenes());
        System.out.println("Dominant Gene :: "+iN.getDominantGene());
        System.out.println("Total births given :: "+iN.getTotalBirthsGiven());
        
    }
}
