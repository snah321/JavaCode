import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;




public class FerryLoading {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int i = 0; i<cases ; i++) {
            
            int ferryl = (sc.nextInt())*100 , n =  sc.nextInt();
            Queue<Integer> left = new LinkedList<>();
            Queue<Integer> right = new LinkedList<>();
            
            for(int j = 0 ; j < n ; j++) {
                
                int carlen = sc.nextInt();
                String pos = sc.next();
                
                if(pos.equals("left")) {
                    left.offer(carlen);
                }else {
                    right.offer(carlen);
                }
            }
            
            int trips = 0;
            String posn = "l";
           
            while(!left.isEmpty() || !right.isEmpty()) {
                int currlen = 0;
                if(posn.equals("l")){
                    while(!left.isEmpty() && (currlen+left.peek() <= ferryl)) {
                        currlen += left.peek();
                        left.poll();
                    }
                    posn = "r";
                    trips++;
                }else if (posn.equals("r")) {
                    while(!right.isEmpty() && (currlen + right.peek() <= ferryl)) {
                        currlen += right.peek();
                        right.poll();
                    }
                    posn = "l";
                    trips++;
                }
            }
            bw.append(trips + "\n");
        }
        bw.flush();
    }
}