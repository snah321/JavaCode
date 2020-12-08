import java.util.*;

public class SortOfSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if(n == 0 ) {
                sc.close();
                break;
               
            }
            String[] names = new String[n];
            for(int i = 0 ; i < n ; i++) {
                names[i] = sc.next();
            }
            Arrays.sort(names, Comparator.comparing(i -> i.substring(0,2)));
            
            for (int i = 0 ; i < names.length ; i++) {
                System.out.println(names[i]);
            }
            System.out.println();
        }
    }
}