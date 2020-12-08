import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    Integer val;
    Integer depth;
    
    public Node(Integer val , Integer depth) {
        this.val = val;
        this.depth = depth;
    }
    
    public int compareTo(Node other) {
        return this.val - other.val;
    }
    
}

    
    


public class BSTT {
        public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws  IOException {
            int n = Integer.parseInt(br.readLine());
            TreeSet<Node> tset = new TreeSet<Node>();
            long total_depth = 0; 
            
            for (int i = 0 ; i<n ; i++) {
                assert total_depth >= 0;
                int x = Integer.parseInt(br.readLine());
                Node temp = new Node(x , 0);
                Node pre = tset.floor(temp);
                Node suc = tset.ceiling(temp);
                
                if(pre == null) {
                    if(suc == null) {
                        temp.depth = 0;
                    }else {
                        temp.depth = suc.depth + 1;
                    }
                }else if(suc == null) {
                    temp.depth = pre.depth + 1; 
                }else {
                    temp.depth = Math.max(suc.depth, pre.depth) + 1;
                }
                tset.add(temp);
                total_depth += temp.depth;
                bw.append(total_depth + "\n");
            }
            
            bw.close();
    }

}
