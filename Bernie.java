import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Bernie {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws  IOException {
        
        int n = Integer.parseInt(br.readLine());
        Hashtable<String,ArrayList<Integer>> trips = new Hashtable<String,ArrayList<Integer>>();
        
        for(int i = 0 ;  i< n ; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            String country = temp.nextToken();
            int yr = Integer.parseInt( temp.nextToken());
            
            if(trips.get(country) == null) {
                trips.put(country , new ArrayList<Integer>());
                trips.get(country).add(yr);
            }else {
                trips.get(country).add(yr);
            }
            
        }
        int q = Integer.parseInt(br.readLine());
        Set<String> tripsKey = trips.keySet();
        for(String key: tripsKey) {
            Collections.sort(trips.get(key));
        }
        
        for(int i = 0 ; i < q ; i++) {
            StringTokenizer temp2 = new StringTokenizer(br.readLine());
            String country = temp2.nextToken();
            int num = Integer.parseInt( temp2.nextToken());
            
            
            
            int ans = trips.get(country).get(num-1);
            
            
            bw.append(ans + "\n");
        }
        bw.flush();
    }
}

