import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ILists {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            char[] c = (br.readLine()).toCharArray();
            int num = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            String[] temp2;
            if(temp.length()>2) {
                temp2 = temp.substring(1,temp.length()-1).split(",");
            }else {
                temp2 = new String[0];
            }
            String pos = "f";
            boolean error = false;
            Deque<Integer> dq = new LinkedList<Integer>();
            for(String z : temp2) {
                dq.add(Integer.parseInt(z));
            }
            for(char cc : c ) {
                if(cc == 'R') {
                    if(pos.equals("f")) {
                        pos = "b";
                    }else if(pos.equals("b")) {
                        pos = "f";
                    }
                }else if (cc == 'D') {
                    if(dq.size() == 0 ) {
                        error = true;
                        break;
                    }else if(pos.equals("f")) {
                        dq.removeFirst();
                    }else if(pos.equals("b")) {
                        dq.removeLast();
                    }
                }
            }
            
            if(error ) {
                bw.append("error" + "\n");
                
            }else {
                if(pos.equals("f")) {
                    bw.append(dq.toString().replace(" ", "") + "\n");
                }else if(pos.equals("b")) {
                    Deque<Integer> rdq = new LinkedList<Integer>();
                    for(Integer k : dq ) {
                        rdq.addFirst(k);
                    }
                    bw.append(rdq.toString().replace(" ", "") + "\n");
                }
            }
            bw.flush();
        }
    }
}
