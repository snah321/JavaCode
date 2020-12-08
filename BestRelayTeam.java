import java.util.*;

class Runner implements Comparable<Runner>{ // Make a Runner Class that can compare by the leg2 timing)  
    String name;
    double leg1;
    double leg2;
    
    public Runner(String name , double leg1 , double leg2) {
        this.name = name;
        this.leg1 = leg1;
        this.leg2 = leg2; 
    }
    public int compareTo(Runner other) {
        if(this.leg2 > other.leg2) {
            return 1;
        }else if (this.leg2 < other.leg2) {
            return -1;
        }
        return 0;
    }
    
    
}

public class BestRelayTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Runner> timings = new ArrayList<Runner>();
        for (int i = 0 ; i < n ; i++) {
            String name = sc.next();
            double time1 = sc.nextDouble();
            double time2 = sc.nextDouble();
            timings.add(new Runner(name, time1 , time2 )) ;
        }//just adding all of my data into the arraylist to be sorted later.
        
        Collections.sort(timings); // All runners sorted by leg2 
        List<String> bestTeam = new ArrayList<String>();
        double bestTime = 100000000; // This one is like the max camp to initialise the variable cause 
                                    // it wont exceed the timing.
        
        for(int i = 0 ; i < timings.size() ; i++) {
            double totalTime = timings.get(i).leg1;
            String name = timings.get(i).name;
            List<String> tempTeam = new ArrayList<String>();
            tempTeam.add(name);
            for (int j = 0 ; tempTeam.size() <4 ; j++) {
                if (j == i) {
                    continue;
                }
                totalTime = totalTime + timings.get(j).leg2;
                tempTeam.add(timings.get(j).name);
            }   
            if(totalTime < bestTime) {
                bestTime = totalTime;
                bestTeam = tempTeam;
            }
        }
        System.out.println(bestTime);
        for (String k : bestTeam ) {
            System.out.println(k);
        }       
    }
}