package SuckerCheatGrudger_Simulation;

import java.util.ArrayList;

public class Individual {
        
    private String individualID;
    private Integer timeOfCreation;
    private String maleOrFemale; //"m","f"
    private String suckerOrCheatOrGrudger; // "s" OR "c" OR "g"
    private Integer totalBirthsGiven; // If FEMALE there is restriction , MALES Have Infinite reproduction Capability
    private boolean infectedOrNot; // true false
    private Float health;
    private String genes; // "ss","cc","gg","sc","sg","cg" ONE OF THESE
    private String dominantGene; // "s" OR "c" OR "g"
    private ArrayList<String> grudgeList = new ArrayList<String>(); // NOT USED FOR CHEATERS AND SUCKERS
    private boolean  killThis = false;
    
    // IMPORTANT :: variables suckerOrCheatOrGrudger and dominantGene are LOGICALLY same.
    
    public Individual(String IndividualID_,Integer timeOfCreation_,String maleOrFemale_,String suckerOrCheatOrGrudger_,boolean infectedOrNot_,Float health_,String genes_,String dominantGene_,Integer totalBirthsGiven_){   
        individualID=IndividualID_;
        timeOfCreation=timeOfCreation_;
        maleOrFemale=maleOrFemale_;
        suckerOrCheatOrGrudger=suckerOrCheatOrGrudger_;
        infectedOrNot=infectedOrNot_;
        health=health_;
        genes=genes_;
        dominantGene = dominantGene_;
        totalBirthsGiven=totalBirthsGiven_;
    }

    /**
     * @return the individualID
     */
    public String getIndividualID() {
        return individualID;
    }

    /**
     * @param individualID the individualID to set
     */
    public void setIndividualID(String individualID) {
        this.individualID = individualID;
    }

    /**
     * @return the timeOfCreation
     */
    public Integer getTimeOfCreation() {
        return timeOfCreation;
    }

    /**
     * @param timeOfCreation the timeOfCreation to set
     */
    public void setTimeOfCreation(Integer timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    /**
     * @return the maleOrFemale
     */
    public String getMaleOrFemale() {
        return maleOrFemale;
    }

    /**
     * @param maleOrFemale the maleOrFemale to set
     */
    public void setMaleOrFemale(String maleOrFemale) {
        this.maleOrFemale = maleOrFemale;
    }

    /**
     * @return the suckerOrCheatOrGrudger
     */
    public String getSuckerOrCheatOrGrudger() {
        return suckerOrCheatOrGrudger;
    }

    /**
     * @param suckerOrCheatOrGrudger the suckerOrCheatOrGrudger to set
     */
    public void setSuckerOrCheatOrGrudger(String suckerOrCheatOrGrudger) {
        this.suckerOrCheatOrGrudger = suckerOrCheatOrGrudger;
    }

    /**
     * @return the totalBirthsGiven
     */
    public Integer getTotalBirthsGiven() {
        return totalBirthsGiven;
    }

    /**
     * @param totalBirthsGiven the totalBirthsGiven to set
     */
    public void setTotalBirthsGiven(Integer totalBirthsGiven) {
        this.totalBirthsGiven = totalBirthsGiven;
    }

    /**
     * @return the infectedOrNot
     */
    public boolean isInfectedOrNot() {
        return infectedOrNot;
    }

    /**
     * @param infectedOrNot the infectedOrNot to set
     */
    public void setInfectedOrNot(boolean infectedOrNot) {
        this.infectedOrNot = infectedOrNot;
    }

    /**
     * @return the health
     */
    public Float getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(Float health) {
        this.health = health;
    }

    /**
     * @return the genes
     */
    public String getGenes() {
        return genes;
    }

    /**
     * @param genes the genes to set
     */
    public void setGenes(String genes) {
        this.genes = genes;
    }

    /**
     * @return the dominantGene
     */
    public String getDominantGene() {
        return dominantGene;
    }

    /**
     * @param dominantGene the dominantGene to set
     */
    public void setDominantGene(String dominantGene) {
        this.dominantGene = dominantGene;
    }

    /**
     * @return the grudgeList
     */
    public ArrayList<String> getGrudgeList() {
        return grudgeList;
    }

    /**
     * @param grudgeList the grudgeList to set
     */
    public void setGrudgeList(ArrayList<String> grudgeList) {
        this.grudgeList = grudgeList;
    }

    /**
     * @return the killThis
     */
    public boolean isKillThis() {
        return killThis;
    }

    /**
     * @param killThis the killThis to set
     */
    public void setKillThis(boolean killThis) {
        this.killThis = killThis;
    }

    
}

