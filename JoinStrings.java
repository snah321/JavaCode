import java.io.*;
import java.util.*;

public class JoinStrings {
    public static int a = 0;
    public static int b = 0;
    public static int lastid = 0;
    public static BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void join(String[] strings , ArrayList<ArrayList<Integer>> order , int last) throws IOException{
        //BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(System.out));
        pw.append(strings[last]);
        
        for(int i : order.get(last)) {
            join(strings, order , i);
        }
        
        
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n+1];
        ArrayList<ArrayList<Integer>> order = new ArrayList<ArrayList<Integer>>(n+1);
        
        for (int i = 0 ; i <n ; i++) {
            strings[i] = br.readLine();
            order.add(new ArrayList<Integer>(0));
        }

        for (int i = 0 ; i < n-1; i++) {
            String temp = br.readLine();
            int a = Integer.parseInt(temp.split(" ")[0]) -1 , b = Integer.parseInt(temp.split(" ")[1])-1;
            if (order.get(a).size() == 0 ) {
                order.get(a).add(b);
                lastid = a;
                continue;
            }
            order.get(a).add(b);
            lastid = a;
        }
        
        join(strings,order,lastid);
        

        pw.close();
        br.close();
    }

}