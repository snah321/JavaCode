import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BoatParts {
        public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {
            String tempp = br.readLine();
            String temppp[] = tempp.split(" ");
            int p = Integer.parseInt(temppp[0]), n = Integer.parseInt(temppp[1]);
            HashSet<String> hs = new HashSet<String>();
            int counter = 0;
            for(int i = 0 ; i < n ; i++) {
                String temp = br.readLine();
                hs.add(temp);
                
                if(hs.size() == p ) {
                    break;
                }
                counter++;
            }
            if(counter  == n) {
                bw.append("paradox avoided" + "\n");
            }else {
                bw.append(counter+1 + "\n");
            }
            bw.flush();
        }
}