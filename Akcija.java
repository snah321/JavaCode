import java.util.*;

public class Akcija {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> price = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++) {
            price.add(sc.nextInt());
        }
        Collections.sort(price);
        int total = 0 ;
        for(int i = price.size()-1 ; i > price.size()%3 ; i = i -3) {
            total = total + price.get(i);
            total = total + price.get(i-1);
        }
        for(int i = 0 ; i < price.size()%3; i++ ) {
            total = total + price.get(i);
        }
        System.out.println(total);
    }
}