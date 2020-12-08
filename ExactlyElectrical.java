import java.util.*;
import static java.lang.Math.*;
public class ExactlyElectrical{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int fuel = sc.nextInt();
        boolean poss = true; 
        int dist = abs((c-a)) + abs((d-b));
        if (dist> fuel ) {
            poss = false;
        }else if((fuel%2==0) && (dist %2 == 0)) {
            poss = true;
        }else if ((fuel%2!=0) && (dist%2!=0)) {
            poss = true;
        }else {
            poss = false;
        }
        if (poss) {
            System.out.println("Y");
        }else {
            System.out.println("N");
        }
    }
}
