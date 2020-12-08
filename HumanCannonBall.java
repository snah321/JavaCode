import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;



class coordinate{
    double x;
    double y;
    
    public coordinate(double x , double y) {
        this.x = x;
        this.y = y;
    }
}
class edgee implements Comparable<edgee>{
    
    coordinate v;
    double time;
    
    public edgee( coordinate v , double time) {
        
        this.v = v;
        this.time  = time;
    }
    
    public int compareTo(edgee other) {
        if(this.time > other.time) {
            return 1;
        }else if(this.time < other.time) {
            return -1;
        }
        return 0;
    }
}

public class HumanCannonBall {
    public static void dijikstra (Hashtable<coordinate , ArrayList<edgee>> map , Hashtable<coordinate , Double> times ,Hashtable<coordinate,Boolean> visited , coordinate start) {
        
        PriorityQueue<edgee> pq = new PriorityQueue<edgee>();
        pq.add(new edgee(start,0));
        times.replace(start, 0d);
        
        while(!pq.isEmpty()) {
            edgee curr = pq.poll();
            if(visited.get(curr.v)) {
                continue;
            }
            visited.replace(curr.v, true);
            for(edgee i : map.get(curr.v)) {
                if(!visited.get(i.v) && curr.time + i.time < times.get(i.v) ) {
                    times.replace(i.v, curr.time + i.time);
                    pq.add(new edgee(i.v , times.get(i.v)));
                }
            }
        }       
    }
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer a = new StringTokenizer(br.readLine());
        coordinate start = new coordinate(Double.parseDouble(a.nextToken()) , Double.parseDouble(a.nextToken()));
        
        StringTokenizer b = new StringTokenizer(br.readLine());
        coordinate end = new coordinate(Double.parseDouble(b.nextToken()) , Double.parseDouble(b.nextToken()));
        
        Hashtable<coordinate , ArrayList<edgee>> map = new Hashtable<coordinate , ArrayList<edgee>>();
        Hashtable<coordinate,Boolean> visited = new Hashtable<coordinate,Boolean>();
        Hashtable<coordinate,Double> times = new Hashtable<coordinate , Double>();
        
        times.put(start, Double.MAX_VALUE);
        times.put(end, Double.MAX_VALUE);
        
        visited.put(start, false);
        visited.put(end, false);
        
        ArrayList<edgee> start_edges = new ArrayList<edgee>();
        ArrayList<edgee> end_edges = new ArrayList<edgee>();
        
        double temp_time = Math.hypot(Math.abs(start.x - end.x) , Math.abs(start.y - end.y))/5;
        edgee start_end = new edgee(end , temp_time);
        edgee end_start = new edgee(start, temp_time);
        
        start_edges.add(start_end);
        end_edges.add(end_start);
        
        map.put(start, start_edges);
        map.put(end, end_edges);
        
        ArrayList<coordinate> cannons = new ArrayList<coordinate>();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer c = new StringTokenizer(br.readLine());
            coordinate loc = new coordinate(Double.parseDouble(c.nextToken()) , Double.parseDouble(c.nextToken()));
            cannons.add(loc);
            visited.put(loc , false);
            times.put(loc, Double.MAX_VALUE);
        }
        // add all edges from source to cannon
        for (int i = 0 ; i < n ; i++) {
            coordinate cannon = cannons.get(i);
            double dist = Math.hypot(Math.abs(start.x - cannon.x) , Math.abs(start.y - cannon.y));
            edgee start_to_cannon = new edgee(cannon, dist/5);
            map.get(start).add(start_to_cannon);
            
            edgee cannon_to_start = new edgee(start , Math.abs(dist-50)/5 + 2);
            ArrayList<edgee> cannon_edges =  new ArrayList<edgee>();
            cannon_edges.add(cannon_to_start);
            map.put(cannon, cannon_edges);
        }
        // add all edges from end to cannon
        for(int i = 0 ; i < n ; i++) {
            coordinate cannon = cannons.get(i);
            double dist = Math.hypot(Math.abs(end.x - cannon.x) , Math.abs(end.y - cannon.y));
            edgee end_to_cannon = new edgee(cannon, dist/5);
            map.get(end).add(end_to_cannon);
            
            edgee cannon_to_end = new edgee(end ,Math.abs(dist-50)/5 + 2 );
            map.get(cannon).add(cannon_to_end);
        }
        
        // add all edges from cannon1 -> cannon 2
        for(int i =0 ; i < n ; i++) {
            for(int j = 1 ; j<n ; j++) {
                coordinate cannon1 = cannons.get(i);
                coordinate cannon2 = cannons.get(j);
                double dist = Math.hypot(Math.abs(cannon1.x - cannon2.x), Math.abs(cannon1.y - cannon2.y));
                
                edgee c1_c2 = new edgee(cannon2 ,  Math.abs(dist-50)/5+2);
                edgee c2_c1 = new edgee(cannon1 , Math.abs(dist-50)/5+2);
                
                map.get(cannon1).add(c1_c2);
                map.get(cannon2).add(c2_c1);
                
            }
        }
        dijikstra(map,times,visited,start);
        System.out.println(times.get(end));
        
        
        
        
    }

}
