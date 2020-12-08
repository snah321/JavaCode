import java.util.*;
import java.io.*;

class UnionFind{
    public int[] p;
    public int[] rank;
    public int[] empty;
    
    public UnionFind(int n) {
        this.p = new int[n];
        this.rank = new int[n];
        this.empty = new int[n];
        
        for(int i = 0 ; i<n ;i++ ) {
            this.p[i] = i;
            this.rank[i] = 0;
            this.empty[i] = 1;
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
                empty[x] += empty[y];
            }else {
                p[x] = y;
                empty[y] += empty[x];
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y]+1; 
                }
            } 
        } 
    }
    
    public boolean add_at(int i) {
        int x = findSet(i);
        empty[x]--;
        if(empty[x] >=0) {
            return true;
        }else {
            empty[x]++;
            return false;
        }
    }
}

public class Ladice {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    
    public static void main(String[] args) throws  IOException {
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(temp.nextToken());
        int l = Integer.parseInt(temp.nextToken());
        
        UnionFind uf = new UnionFind(l+1);
        
        for(int i = 0; i<n ; i++) {
            StringTokenizer temp2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(temp2.nextToken());
            int b = Integer.parseInt(temp2.nextToken());
            
            uf.unionSet(a, b);
            
            if(uf.add_at(a)) {
                bw.append("LADICA" + "\n");
            }else {
                bw.append("SMECE" + "\n");
            }
        }
        bw.flush();
    }

}