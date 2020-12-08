import java.util.*;
import java.io.*;

public class Conformity {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String , Integer> hm = new HashMap<String,Integer>();
        
        for(int i = 0 ; i < n ; i++) {
            String temp = br.readLine();
            String[] temps = temp.split(" ");
            Arrays.sort(temps);
            String x = Arrays.toString(temps);
            if(!hm.containsKey(x)) {
                hm.put(x, 1);
            }else if (hm.containsKey(x)) {
                int y = hm.get(x);
                y++;
                hm.put(x,y);
            }
        }
        int max = Collections.max(hm.values());
        int counter = 0 ; 
        Set<String> keys = hm.keySet();
        for(String key : keys ) {
            if(hm.get(key) == max) {
                counter++;
            }
        }
        bw.append(Integer.toString(max*counter));
        bw.flush();

    }

}
