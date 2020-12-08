import java.util.*;
class Persons{
    int index;
    String hands; 
    
    public Persons(int i , String h) {
        this.index = i;
        this.hands = h;
    }
}

public class CoconutSplat {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        List<Persons> alive = new ArrayList<Persons>();
        for (int  i = 1 ; i <= n ; i++) {
            alive.add(new Persons(i , "folded"));
        }
        int i = 0;
        while(alive.size() > 1 ) {

            int pop = ( i + s - 1)%alive.size();
            Persons temp = alive.get(pop);
            alive.remove(pop);
            if(temp.hands.equals("folded")) {
                alive.add(pop, new Persons(temp.index , "fist"));
                alive.add(pop, new Persons(temp.index , "fist"));
                i = pop;
            }else if(temp.hands.equals("fist")) {
                alive.add(pop , new Persons(temp.index , "palm"));
                i = pop +1;
            }else if (temp.hands.equals("palm")) {
                i = pop;
            }
        }
        System.out.println(alive.get(0).index);
    }
}
