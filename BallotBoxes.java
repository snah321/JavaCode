import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.math.*;

class Boxes implements Comparable<Boxes>{
    public int pop;
    public int box;
    public int per_box;
    
    public Boxes(int pop , int box , int per_box) {
        this.pop = pop;
        this.box = box;
        this.per_box = per_box;
    }
    
    public int compareTo(Boxes other) {
        return this.per_box - other.per_box;
    }
}

public class BallotBoxes {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    
    public static void main(String[] args) throws  IOException {
        
        for (int i = 0 ; i < 3 ; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(temp.nextToken());
            int b = Integer.parseInt(temp.nextToken());
            
            if(n == -1 || b == -1) {
                break;
            }else {
                
                PriorityQueue<Boxes> pq = new PriorityQueue<Boxes>(n,Collections.reverseOrder());
                for(int j= 0 ; j < n ; j++) {
                    int pop = Integer.parseInt(br.readLine());
                    pq.add(new Boxes(pop,1, pop));
                    b--;
                }
                
                br.readLine();
                while(b > 0) {
                    Boxes bz = pq.peek();
                    int temp_pop = bz.pop;
                    int temp_box = bz.box;
                    temp_box++;
                    int temp_per_box = (int) Math.ceil((((float)temp_pop)/((float)temp_box)));
                    pq.poll();
                    pq.add(new Boxes(temp_pop, temp_box,temp_per_box));
                    b--;
                    //for(Boxes bb : pq) {
                        //System.out.println(bb.per_box);
                    //}
                }
                Boxes maxb = pq.peek();
                bw.append(maxb.per_box +"\n");
                
            }
        }
        bw.flush();
    }
}
