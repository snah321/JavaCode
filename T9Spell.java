import java.util.*;
import java.io.*;
public class T9Spell {

    public static void main(String[] args) throws IOException{
        HashMap<String,String> keyPress = new HashMap<String,String>(); 
        keyPress.put("a", "2");
        keyPress.put("b", "22");
        keyPress.put("c", "222");
        keyPress.put("d", "3");
        keyPress.put("e", "33");
        keyPress.put("f", "333");
        keyPress.put("g", "4");
        keyPress.put("h", "44");
        keyPress.put("i", "444");
        keyPress.put("j", "5");
        keyPress.put("k", "55");
        keyPress.put("l", "555");
        keyPress.put("m", "6");
        keyPress.put("n", "66");
        keyPress.put("o", "666");
        keyPress.put("p", "7");
        keyPress.put("q", "77");
        keyPress.put("r", "777");
        keyPress.put("s", "7777");
        keyPress.put("t", "8");
        keyPress.put("u", "88");
        keyPress.put("v", "888");
        keyPress.put("w", "9");
        keyPress.put("x", "99");
        keyPress.put("y", "999");
        keyPress.put("z", "9999");
        keyPress.put(" ", "0");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int nCase =  Integer.parseInt(br.readLine());
        
        for(int j=0 ; j < nCase ; j++) {
            String msg = br.readLine();
            StringBuilder ans = new StringBuilder() ;
            String prev = "/";
            pw.print("Case #"+(j+1)+":");
            
            for(int i=0 ; i < msg.length(); i ++) {
                String key = msg.substring(i, i+1);
                String next = keyPress.get(key);
                if(next.substring(0,1).equals(prev.substring(0,1))) {
                    ans.append(" ");
                }
                prev = next;
                ans.append(next);

            }
            pw.print(" " + ans);
            pw.println();
        }
        br.close();
        pw.close();
    }

}
