package mathematicalFunctions;
import java.util.ArrayList;
import java.util.Random;

public class Probability {
        /* TEST CODE to test Probability Result
        public static void main(String args[]) {
                int ones=0, zeroes=0;
                for(int i=1;i<=1000;i++){
                    if(returnBooleanWithProbability(10)==true){ // here 10 is 10% probability to get '1' and 90% probability to get '0'
                        ones++;
                    }else{
                        zeroes++;
                    }
                }
                    System.out.println(ones +"  "+ zeroes );
         }
        */
           
            Float probability;
            ArrayList<Integer> samplePopulation = new ArrayList<Integer>();
            Random randomNo = new Random();

            public Probability(Float probability_) {
                int i;

                if(probability_>100){ 
                    System.out.println("SIMULATION ERROR :: Probability can not be greater than 100%.");
                    System.exit(1);
                }
            
                for(i=1;i<=probability_.intValue();i++){
                    samplePopulation.add(1);
                }
                for(i=((probability_.intValue())+1);i<=100;i++){
                    samplePopulation.add(0);
                }
            
                //java.util.Collections.shuffle(samplePopulation); // Shuffle or Randomize the samplePopulation
            }
            
            public Probability(){
                
            }
            
            
            
            public boolean returnBooleanWithProbability(){ // Returns 'true' with probability_% and Probability should be already stored via CONSTRUCTOR FUNCTION
                if(samplePopulation.get(randomNo.nextInt(100))==1){
                    return true;
                }else{
                    return false;
                }
            }
            
            
            
            public void changeProbabilityArray(Float newProbability){
                this.samplePopulation.removeAll(samplePopulation);
                
                int i;

                if(newProbability>100){ 
                    System.out.println("SIMULATION ERROR :: Probability can not be greater than 100%.");
                    System.exit(1);
                }
            
                for(i=1;i<=newProbability.intValue();i++){
                    this.samplePopulation.add(1);
                }
                for(i=((newProbability.intValue())+1);i<=100;i++){
                    this.samplePopulation.add(0);
                }
            
                //java.util.Collections.shuffle(samplePopulation); // Shuffle or Randomize the samplePopulation
                
                
                
            }
}