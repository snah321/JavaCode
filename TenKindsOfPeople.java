import java.io.*;
import java.util.*;

class coord{
    
    public int y;
    public int x;
    
    public coord(int y , int x) {
        this.y= y ; 
        this.x = x;
    }
}

public class TenKindsOfPeople {
    
    public static void print2D(int mat[][]){  
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row)); 
            }
    }
    public static void bfs(char[][] original_map , int[][] coloured_map) {
        
        Queue<coord> q = new LinkedList<coord>();
        char curr = '0';
        int colour = 2;
        
        for(int i = 0 ; i < original_map.length ; i++) {
            for(int j =0 ; j < original_map[0].length ; j++) {
                if(coloured_map[i][j] > 1) {
                    continue;
                }
                curr = original_map[i][j];
                coloured_map[i][j] = colour;
                q.add(new coord(i,j));
                while(!q.isEmpty()) {
                    coord temp = q.poll();
                    for(int k= 0 ; k<4 ;k++) {
                        int newY = temp.y + y_axis[k];
                        int newX = temp.x + x_axis[k];
                        
                        if (newY>= 0 && newY< original_map.length && newX >= 0 && newX < original_map[0].length) {
                            if(coloured_map[newY][newX] < 2 && original_map[newY][newX] == curr) {
                                coloured_map[newY][newX] = colour;
                                q.add(new coord(newY , newX));
                            }   
                            
                        }
                    }
                }
                colour++;   
            }
        }
    }

    public static int[] y_axis = new int[] {1,-1,0,0};
    public  static int[] x_axis = new int[] {0,0,1,-1};
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer temp = new StringTokenizer(br.readLine());
        
        int rows = Integer.parseInt(temp.nextToken());
        int cols = Integer.parseInt(temp.nextToken());
        
        char[][] original_map = new char[rows][cols];
        int[][] coloured_map = new int[rows][cols];
        
        for(int i = 0 ; i < rows; i++) {
            String temp2 = br.readLine();
            for(int j = 0 ; j<cols ; j++) {
                original_map[i][j] = temp2.charAt(j);
                coloured_map[i][j] = 0;
            }
        }
        //print2D(coloured_map);
        bfs(original_map , coloured_map);
        //print2D(coloured_map);
        int query = Integer.parseInt(br.readLine());
        
        if(query == 0 ) {
            bw.append("neither" + "\n");
            
        }else {
            for(int i = 0 ; i < query ; i++) {
                StringTokenizer tempe = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(tempe.nextToken())-1;
                int c1 = Integer.parseInt(tempe.nextToken())-1;
                int r2 = Integer.parseInt(tempe.nextToken())-1;
                int c2 = Integer.parseInt(tempe.nextToken())-1;
                if(coloured_map[r1][c1] == coloured_map[r2][c2]) {
                    if(original_map[r1][c1] == '0') {
                        bw.append("binary" + "\n");
                    }else {
                        bw.append("decimal" + "\n");
                    }
                }else {
                    bw.append("neither" + "\n");
                }
            }
        }
        bw.flush();
        
    }
}
