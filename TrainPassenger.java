import java.util.*;


public class TrainPassenger { 

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         
         boolean poss = true ;
         int maxCap = sc.nextInt();
         int stops = sc.nextInt();
         
         int left = 0 ;
         int enter = 0 ;
         int wait = 0 ; 
         int currCap = 0 ;
         
         
         for (int i = 0 ; i < stops ; i ++ ) {
             left = sc.nextInt();
             enter = sc.nextInt();
             wait = sc.nextInt();
             if (left > currCap) {
                 poss = false;
             }
             currCap = currCap - left + enter ; 
             if (currCap > maxCap) {
                 poss = false;
             }else if((currCap != maxCap) && wait > 0  ) {
                 poss = false;
             }else if((i == (stops-1)) && wait != 0 ) {
                 poss = false;
             }else if(currCap < 0) {
                 poss = false;
             }
         }
         if (currCap != 0 ) {
             poss = false;
         }
         if (poss) {
             System.out.println("possible");
         }else {
             System.out.println("impossible");
         }
         sc.close();
    }

}
