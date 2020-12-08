import java.util.*;
public class ShatteredCake {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int piece = sc.nextInt();
        int area = 0; 
        while (piece > 0) {
            area = area +(sc.nextInt() * sc.nextInt());
            piece = piece - 1 ;
        }
        System.out.println(area/width);
    }

}
