import java.util.*;
import java.io.*;

class vc implements Comparable<vc>{
    public int v; 
    public int c;
    
    public vc(int v , int c) {
        this.v = v;
        this.c = c;
    }
    
    public int compareTo(vc other) {
        if(this.v == other.v) {
            return this.c -other.c;
        }else {
            return this.v - other.v;
        }
    }
}

public class kattisquest {

        public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        public static void main(String[] args) throws  IOException {
            long n = Long.parseLong(br.readLine());
            TreeMap<Integer,TreeSet<vc>> tmap = new TreeMap<Integer,TreeSet<vc>>();
            int counter = 0;
            for(int i = 0 ; i<n ; i++) {
                StringTokenizer temp = new StringTokenizer(br.readLine());
                String cmd = temp.nextToken();
                
                if(cmd.equals("add")) {
                    int e = Integer.parseInt(temp.nextToken());
                    int g = Integer.parseInt(temp.nextToken());
                    
                    if(tmap.containsKey(e)) {
                        tmap.get(e).add(new vc(g,counter++));
                    }
                    else {
                        TreeSet<vc> tset = new TreeSet<vc>();
                        tset.add(new vc(g,counter++));
                        tmap.put(e, tset);
                    }
                //System.out.println(tmap);
                }else if(cmd.equals("query")) {
                    int total_e = Integer.parseInt(temp.nextToken());
                    long g = 0;
                    
                    while(!tmap.isEmpty() && total_e >0) { 
                        var pred = tmap.floorKey(total_e);
                        if(pred == null) {
                            break;
                        }
                        int maxG  = tmap.get(pred).pollLast().v;

                        if(tmap.get(pred).isEmpty()) {
                            tmap.remove(pred);
                        }
                        g = g + maxG;
                        total_e = total_e - pred;
                    }
                    System.out.println(g);
                }
            }
    }
}