import java.util.*;

public class Apaxia {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        StringBuilder ans = new StringBuilder();
        String prev = "/";
        for (int i = 0 ; i < name.length() ; i++ ) {
            if (name.substring(i, i+1).equals(prev)) {
                continue ;
            }
            ans.append(name.charAt(i));
            prev = name.substring(i,i+1);
        }
        System.out.println(ans);
        sc.close();
    }
}
