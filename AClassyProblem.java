import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

class Person implements Comparable<Person>{
    public String name;
    public int[] tier; 
  
    
    @SuppressWarnings("serial")
    final static HashMap<Character,Integer> tiercount = new HashMap<Character,Integer>(){{
        put('u',0);
        put('m',1);
        put('l',2);
    }};
    
    public  Person(String name , String[] tierz) {
        this.name = name;
        int[] tempArr = new int[10];
        for (int i = 0 ; i < tierz.length ; i++) {
            tempArr[i] = tiercount.get(tierz[tierz.length-i-1].charAt(0));
        }
        for (int j = tierz.length ; j < 10 ; j ++  ) {
            tempArr[j] = 1 ;
        }
        this.tier = tempArr;
        
    }
    
    public int compareTier(Person other) {
        for (int i = 0 ; i < this.tier.length ; i++) {
            if(this.tier[i] < other.tier[i]) {
                return -1;
            
            }else if(this.tier[i] > other.tier[i]) {
                return 1;
            
            }else if(this.tier[i] == other.tier[i]) {
                continue;
            }
        }
        return 0;
    }
    public int compareTo(Person other) {
        int x = compareTier(other);
        if(x==0) {
            return this.name.compareTo(other.name);
            
        }else {
            return x;
        }
    }
}


public class AClassyProblem{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args)  throws IOException{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        for (int i = 0; i < T ; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Person> people = new ArrayList<Person>();
            for(int j = 0 ; j <n ; j++) {
                String name = sc.next();
                String tiers = sc.next();
                String[] aTier = tiers.split("-");
                people.add( new Person(name.substring(0,name.length() -1 ) , aTier));  
                sc.next();
            }
            Collections.sort(people);
            for(Person k : people) {
                pw.print(k.name +"\n");
            }
            pw.println("==============================");
            
        }
        pw.close();
    }
}