import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class DelimeterSoup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        Stack<Character> stack = new Stack<Character>();      
        int n = sc.nextInt();
        
        sc.nextLine();
        
        String str = sc.nextLine();
        for(int i = 0 ; i < n ; i++) {
            char c = str.charAt(i);
            if (c == ' ' ) {
                continue;
            }
            //if (c == '(' || c == '[' || c == '{') {
                //stack.push(c);
            //}
            if (c == ')'|| c == ']' || c == '}') {
                if(stack.isEmpty()) {
                    pw.println(c + " " + i);
                    pw.close();
                }else{
                    char back = stack.pop();
                    if(back == '(' && c != ')' ) {
                        pw.println(c + " " + i);
                        pw.close();
                    }else if (back == '{' && c != '}') {
                        pw.println(c + " " + i);
                        pw.close();
                    }else if(back == '[' && c != ']') {
                        pw.println(c + " " + i);
                        pw.close();
                    }
                    
                }
            }else {
                stack.push(c);
            }
        }
        pw.println("ok so far");
        pw.close();
        sc.close();
    }
}
