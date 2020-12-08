import java.util.*;
import java.io.*;

public class Island {
    
    public static void dfs(int i , int j , ArrayList<ArrayList<Character>> adjMat , ArrayList<ArrayList<Boolean>> visited ) {
        if(visited.get(i).get(j) == true) {
            return;
        }
        visited.get(i).set(j, true);
        
        for(int pos = 0 ; pos < 4 ; pos++) {
            int newXpos = i + x_axis[pos];
            int newYpos = j + y_axis[pos];
            
            if(newXpos < 0) {
                continue;
            }
            if(newYpos < 0) {
                continue;
            }
            if(newXpos >= adjMat.size()) {
                continue;
            }
            if(newYpos >= adjMat.get(0).size()) {
                continue;
            }
            
            if(adjMat.get(newXpos).get(newYpos) == 'C' || adjMat.get(newXpos).get(newYpos) == 'L' ){
                dfs(newXpos , newYpos , adjMat , visited);
            }
        }
        
        
    }
    public static int[] x_axis = new int[] {1,-1,0,0};
    public  static int[] y_axis = new int[] {0,0,1,-1};
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer temp = new StringTokenizer( br.readLine());
        int rows = Integer.parseInt(temp.nextToken());
        int cols = Integer.parseInt(temp.nextToken());
        
        ArrayList<ArrayList<Character>> adjMat = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>(); 
        
        for (int i = 0 ; i < rows ; i++) {
            String temp2 = br.readLine();
            ArrayList<Character> temp3 = new ArrayList<Character>();
            ArrayList<Boolean> temp4 = new ArrayList<Boolean>();
            for(int j = 0 ; j < cols ; j++) {
                temp3.add(temp2.charAt(j));
                temp4.add(false);
            }
            adjMat.add(temp3);
            visited.add(temp4);
        }
        //System.out.println(adjMat);
        int count = 0;
        
        for (int i = 0; i < rows ; i++) {
            for(int j =0 ; j<cols ; j++) {
                if(visited.get(i).get(j)== false && adjMat.get(i).get(j) == 'L') {
                    dfs(i,j,adjMat,visited );
                    count++;
                }
            }
        }
        System.out.println(count);
        
        

    }

}
