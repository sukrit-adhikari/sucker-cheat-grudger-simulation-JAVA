    package SuckerCheatGrudger_Simulation;

public class SimulationParameters {
       
        private Integer noOfSuckers;
        private Integer noOfCheats;
        private Integer noOfGrudgers;
    
        private Float deathFromNaturalCauseProbability;
        private Float copulationProbability;
        private Float infectionProbability;
        private Float maleFemaleProbability;
       
        private Float maximumReproductionCapabilityOfFemale;
        private Float startingHealth;
       
        private Float s_SCProbability;
        private Float g_SGProbability;
        private Float c_CGProbability;
       
        private Integer healthDecreasePerTime;
        private Integer healthIncreasePerHelp;
        private Integer healthDecreasePerHelpGiven;
        
        private Integer lifeExpectancy;
        
        private Integer totalIterations;

    /**
     * @return the noOfSuckers
     */
    public Integer getNoOfSuckers() {
        return noOfSuckers;
    }

    /**
     * @param noOfSuckers the noOfSuckers to set
     */
    public void setNoOfSuckers(Integer noOfSuckers) {
        this.noOfSuckers = noOfSuckers;
    }

    /**
     * @return the noOfCheats
     */
    public Integer getNoOfCheats() {
        return noOfCheats;
    }

    /**
     * @param noOfCheats the noOfCheats to set
     */
    public void setNoOfCheats(Integer noOfCheats) {
        this.noOfCheats = noOfCheats;
    }

    /**
     * @return the noOfGrudgers
     */
    public Integer getNoOfGrudgers() {
        return noOfGrudgers;
    }

    /**
     * @param noOfGrudgers the noOfGrudgers to set
     */
    public void setNoOfGrudgers(Integer noOfGrudgers) {
        this.noOfGrudgers = noOfGrudgers;
    }

    /**
     * @return the deathFromNaturalCauseProbability
     */
    public Float getDeathFromNaturalCauseProbability() {
        return deathFromNaturalCauseProbability;
    }

    /**
     * @param deathFromNaturalCauseProbability the deathFromNaturalCauseProbability to set
     */
    public void setDeathFromNaturalCauseProbability(float deathFromNaturalCauseProbability) {
        this.deathFromNaturalCauseProbability = deathFromNaturalCauseProbability;
    }

    /**
     * @return the copulationProbability
     */
    public Float getCopulationProbability() {
        return copulationProbability;
    }

    /**
     * @param copulationProbability the copulationProbability to set
     */
    public void setCopulationProbability(float copulationProbability) {
        this.copulationProbability = copulationProbability;
    }

    /**
     * @return the infectionProbability
     */
    public Float getInfectionProbability() {
        return infectionProbability;
    }

    /**
     * @param infectionProbability the infectionProbability to set
     */
    public void setInfectionProbability(float infectionProbability) {
        this.infectionProbability = infectionProbability;
    }

    /**
     * @return the maleFemaleProbability
     */
    public Float getMaleFemaleProbability() {
        return maleFemaleProbability;
    }

    /**
     * @param maleFemaleProbability the maleFemaleProbability to set
     */
    public void setMaleFemaleProbability(float maleFemaleProbability) {
        this.maleFemaleProbability = maleFemaleProbability;
    }

    /**
     * @return the maximumReproductionCapabilityOfFemale
     */
    public Float getMaximumReproductionCapabilityOfFemale() {
        return maximumReproductionCapabilityOfFemale;
    }

    /**
     * @param maximumReproductionCapabilityOfFemale the maximumReproductionCapabilityOfFemale to set
     */
    public void setMaximumReproductionCapabilityOfFemale(float maximumReproductionCapabilityOfFemale) {
        this.maximumReproductionCapabilityOfFemale = maximumReproductionCapabilityOfFemale;
    }

    /**
     * @return the startingHealth
     */
    public Float getStartingHealth() {
        return startingHealth;
    }

    /**
     * @param startingHealth the startingHealth to set
     */
    public void setStartingHealth(float startingHealth) {
        this.startingHealth = startingHealth;
    }

    /**
     * @return the s_SCProbability
     */
    public Float getS_SCProbability() {
        return s_SCProbability;
    }

    /**
     * @param s_SCProbability the s_SCProbability to set
     */
    public void setS_SCProbability(float s_SCProbability) {
        this.s_SCProbability = s_SCProbability;
    }

    /**
     * @return the g_SGProbability
     */
    public Float getG_SGProbability() {
        return g_SGProbability;
    }

    /**
     * @param g_SGProbability the g_SGProbability to set
     */
    public void setG_SGProbability(float g_SGProbability) {
        this.g_SGProbability = g_SGProbability;
    }

    /**
     * @return the c_CGProbability
     */
    public Float getC_CGProbability() {
        return c_CGProbability;
    }

    /**
     * @param c_CGProbability the c_CGProbability to set
     */
    public void setC_CGProbability(float c_CGProbability) {
        this.c_CGProbability = c_CGProbability;
    }
    

    /**
     * @return the lifeExpectancy
     */
    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * @param lifeExpectancy the lifeExpectancy to set
     */
    public void setLifeExpectancy(Integer lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * @return the totalIterations
     */
    public Integer getTotalIterations() {
        return totalIterations;
    }

    /**
     * @param totalIterations the totalIterations to set
     */
    public void setTotalIterations(Integer totalIterations) {
        this.totalIterations = totalIterations;
    }

    /**
     * @return the healthDecreasePerTime
     */
    public Integer getHealthDecreasePerTime() {
        return healthDecreasePerTime;
    }

    /**
     * @param healthDecreasePerTime the healthDecreasePerTime to set
     */
    public void setHealthDecreasePerTime(Integer healthDecreasePerTime) {
        this.healthDecreasePerTime = healthDecreasePerTime;
    }

    /**
     * @return the healthIncreasePerHelp
     */
    public Integer getHealthIncreasePerHelp() {
        return healthIncreasePerHelp;
    }

    /**
     * @param healthIncreasePerHelp the healthIncreasePerHelp to set
     */
    public void setHealthIncreasePerHelp(Integer healthIncreasePerHelp) {
        this.healthIncreasePerHelp = healthIncreasePerHelp;
    }

    /**
     * @return the healthDecreasePerHelpGiven
     */
    public Integer getHealthDecreasePerHelpGiven() {
        return healthDecreasePerHelpGiven;
    }

    /**
     * @param healthDecreasePerHelpGiven the healthDecreasePerHelpGiven to set
     */
    public void setHealthDecreasePerHelpGiven(Integer healthDecreasePerHelpGiven) {
        this.healthDecreasePerHelpGiven = healthDecreasePerHelpGiven;
    }

  

}