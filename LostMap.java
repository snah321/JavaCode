import java.io.*;
import java.util.*;

class UFDS{
    public int[] p;
    public int[] rank;
    public int[] empty;
    
    public UFDS(int n) { 
        this.p = new int[n];
        this.rank = new int[n];
        
        for(int i = 0 ; i<n ;i++ ) {
            this.p[i] = i;
            this.rank[i] = 0;
        }
    }
    
    public int findSet(int i) {
        if (p[i] ==i) {
            return i;
        }else {
            p[i] = findSet(p[i]);
            return p[i];
        }
        
    }
    public boolean isSameSet(int i, int j) { 
        return findSet(i) == findSet(j); 
    }
    public void unionSet(int i, int j) { 
        if (!isSameSet(i, j)) { 
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                p[y] = x;
            }else {
                p[x] = y;
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y]+1; 
                }
            } 
        } 
    }
}


class Path implements Comparable<Path> {
    public int u;
    public int v;
    public int weight;

    public Path(int u, int v , int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int compareTo(Path other) {
        if(this.weight != other.weight) {
            return this.weight - other.weight;
        }else if(this.u != other.u) {
            return this.u - other.u;
        }else {
            return this.v - other.v; 
        }
    }
    Integer getU() {
        return this.u; 
    }
    
    Integer getV() {
        return this.v; 
    }
    Integer getWeight() {
        return this.weight; 
    }

    public String toString() {
        return (getU()+1) + " " + (getV()+1) + " " ; 
    }
}

public class LostMap {
    public static ArrayList<Path> Kruskal(ArrayList<Path> edgeList , int n ) {
        ArrayList<Path> KruskalMST = new ArrayList<Path>();
        UFDS UF = new UFDS(n);
        
        for(int i = 0 ; i <edgeList.size() ; i++) {
            Path path = edgeList.get(i);
            int u = path.u;
            int v = path.v;
            
            if(!UF.isSameSet(u,v)) {
                UF.unionSet(u, v);
                KruskalMST.add(path);
            }
        }
        return KruskalMST;
        
        
        
    }

        public static int[] y_axis = new int[] {1,-1,0,0};
        public  static int[] x_axis = new int[] {0,0,1,-1};
        
        public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        public static void main(String[] args) throws IOException {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(temp.nextToken());
            
            ArrayList<Path> edgeList = new ArrayList<Path>();
            
            for(int i=0 ; i<n ; i++) {
                StringTokenizer temp2 = new StringTokenizer(br.readLine());
                for(int j=0 ; j<n ; j++) {
                    Path temp3 = new Path(i,j, Integer.parseInt(temp2.nextToken()));
                    edgeList.add(temp3);
                }
            }
            
            Collections.sort(edgeList);
            /*for(Path i : edgeList) {
                System.out.println(i);
            }*/
            ArrayList<Path> MST = Kruskal(edgeList,n);
            for(Path i : MST) {
                System.out.println(i);
            }
    }

}
