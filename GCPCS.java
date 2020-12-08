import java.io.*;
import java.util.*;

class team {
    public int score;
    public int penalty;
    
    public team(int score) {
        this.score = score;
        
    }
    public void addPenalty(int p) {
        this.score++;
        this.penalty = this.penalty +p;
    }
    
}

public class GCPCS {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws  IOException {
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(temp.nextToken());
        int m = Integer.parseInt(temp.nextToken());
        
        ArrayList<team> scores = new ArrayList<team>();
        HashSet<Integer> teams_unbeaten = new HashSet<Integer>();
        
        
        scores.add(new team(0));

        for(int i = 0 ; i < n ; i++) {
            scores.add(new team(0));
        }
        
        for(int i = 0 ; i< m ; i++) {
            StringTokenizer temp2 = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(temp2.nextToken());
            int penalty = Integer.parseInt(temp2.nextToken());
            

            scores.get(team).addPenalty(penalty);
            
            if(team != 1 ) {
                if(scores.get(team).score > scores.get(1).score ) {
                    teams_unbeaten.add(team);
                }
                if(scores.get(team).score == scores.get(1).score && scores.get(team).penalty < scores.get(1).penalty) {
                    teams_unbeaten.add(team);
                }
                
                bw.append(teams_unbeaten.size()+ 1 + "\n");
            }else if( team == 1) {
                ArrayList<Integer> temp3 = new ArrayList<Integer>(teams_unbeaten);
                for(Integer j : temp3) {
                    if(scores.get(j).score < scores.get(1).score) {
                        teams_unbeaten.remove(j);
                    }else if(scores.get(j).score == scores.get(1).score && scores.get(j).penalty > scores.get(1).penalty) {
                        teams_unbeaten.remove(j);
                    }else if(scores.get(j).score == scores.get(1).score && scores.get(j).penalty == scores.get(1).penalty){
                        teams_unbeaten.remove(j);
                    }
                    else {
                        continue;
                    }
                }
                bw.append(teams_unbeaten.size() + 1 + "\n");
            
            }
            bw.flush();
        }
    }
}