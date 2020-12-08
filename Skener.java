import java.util.*;

public class Skener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int rowZ = sc.nextInt();
        int colZ = sc.nextInt();
        
        String[][] ans = new String[row][col];
        
        for (int i = 0 ; i < row ; i++) {
            String inRow = sc.next();
            
            for (int j = 0 ; j < col ; j++) {
                ans[i][j] = inRow.substring(j, j+1);
            }
        }
        for (int rows = 0 ; rows < ans.length ; rows++) {
            for(int rowMulti = 0 ; rowMulti < rowZ ; rowMulti ++) {
                for (int cols = 0 ; cols<ans[0].length; cols++) {
                    for (int colMulti = 0 ; colMulti < colZ ; colMulti ++) {
                        System.out.print(ans[rows][cols]);
                    }
                }
            System.out.println();   
            }
        }
    }
}
