import java.util.*;

public class PassHack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           
        double[] prob = new double[n];
        
        for (int i = 0 ; i < n ; i++ ) {
            sc.next();
            prob[i] = sc.nextDouble();
        }
        Arrays.sort(prob);
        
        double total = 0 ;
        
        for(int i = n-1 ; i>= 0 ; i--) {
            total = total + (n-i)*prob[i];
        }
        System.out.println(total);
    }
}
