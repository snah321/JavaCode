import java.util.*;
import java.io.*;

class cord{
    int y;
    int x; 
    
    public cord(int y , int x) {
        this.y =y;
        this.x = x;
    }
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if(!(o instanceof cord)) {
            return false;
        }
        cord temp = (cord) o;
        
        return Integer.compare(this.x, temp.x) == 0 && Integer.compare(this.y, temp.y) == 0;
    }
}
class edge implements Comparable<edge>{
    public cord v;
    public int weight;
    
    public edge(cord v , int weight) {  
        this.v = v;
        this.weight = weight;
    }
    
    public int compareTo(edge other) {
        return this.weight - other.weight;
    }
    public cord getV() {
        return this.v;
    }
    Integer getWeight() {
        return this.weight; 
    }

    public String toString() {
        return (getV().y) + " " + (getV().x) + " " + getWeight() ; 
    }

}




public class MM {
    public static ArrayList<edge> dijikstra(int[][] map , boolean[][] visited , cord start , cord end) {
        PriorityQueue<edge> pq = new PriorityQueue<edge>();
        ArrayList<edge> ssp = new ArrayList<edge>();
        pq.add(new edge(start , 0));
        
        while (!pq.isEmpty()) {
            edge u = pq.poll();
            ssp.add(u);
            cord curr  = u.v;
            
            if(u.v.equals(end)) {
                break;
            }
            if(!visited[curr.y][curr.x]) {
                visited[curr.y][curr.x] = true;
                for(int pos = 0 ; pos < 4 ; pos++) {
                    int newY = curr.y + y_axis[pos];
                    int newX = curr.x + x_axis[pos];
                
                    if(newY < 0) {
                        continue;
                    }
                    if(newX < 0) {
                        continue;
                    }
                    if(newY >= map.length) {
                        continue;
                    }
                    if(newX >= map[0].length) {
                        continue;
                    }
                
                    cord next = new cord(newY , newX);
                    if(map[newY][newX] < map[curr.y][curr.x] ) {
                        pq.add(new edge(next , 0));
                    }else {
                        int weight = map[newY][newX] - map[curr.y][curr.x];
                        pq.add(new edge(next , weight));
                    }
                }
            }
        }
        return ssp;
    }
         
         
         

    public static int[] y_axis = new int[] {1,-1,0,0};
    public  static int[] x_axis = new int[] {0,0,1,-1};
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(temp.nextToken());
        int n = Integer.parseInt(temp.nextToken());
        
        int[][] vault = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i < m ; i++) {
            StringTokenizer temp2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                vault[i][j] = Integer.parseInt(temp2.nextToken());
                visited[i][j] = false;
            }
        }
        cord start = new cord(0,0);
        cord end  = new cord((m-1) , (n-1));
        
        ArrayList<edge> ssp = dijikstra(vault , visited , start,end );
        int maxW = -10000;
        for(edge i : ssp) {
            if(i.weight > maxW) {
                maxW = i.weight;
            }
        }
        System.out.println(maxW);

    
    
    }

}
