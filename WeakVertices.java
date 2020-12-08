import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WeakVertices {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws  IOException{
        int n ;
        
        while( (n = Integer.parseInt(br.readLine())) != -1 ) {
        
            int[][] adjmat = new int[n][n];
        
            for(int i = 0 ; i <n ; i++) {
                StringTokenizer temp = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < n ; j++) {
                    adjmat[i][j] = Integer.parseInt(temp.nextToken());
                }
            }
        
            for(int i = 0 ; i<n ; i++) {
                boolean notTriangle = true;
                for(int j = 0 ; j<n ; j++) {
                
                    for(int k = 0 ; k<n ; k++) {
                        if(adjmat[i][j] == 1 && adjmat[i][k] == 1 && adjmat[j][k] == 1) {
                            if(i != j && i != k && j !=k) {
                                notTriangle = false;
                            }
                        }
                    }
            
                }
                if(notTriangle) {
                    bw.append(i + " ");
                }
            }
        bw.append("\n");
        }
        bw.flush();
    }

}
