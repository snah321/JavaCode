import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

class teque{
    public HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
    public int lStart ;
    public int lEnd ;
    public int rStart ;
    public int rEnd ;
    
    public teque() {
        this.left = new HashMap<Integer, Integer>();
        this.right = new HashMap<Integer, Integer>();
        this.lStart = 0;
        this.lEnd = 0;
        this.rStart = 0; 
        this.rEnd = 0;
    }
    public void balance() {
        if( left.size() > right.size() ){
            lEnd--;
            int temp = left.remove(lEnd);
            rStart--;
            right.put(rStart , temp);
        }else if( right.size() > left.size()+1  ){
            int temp = right.remove(rStart);
            left.put(lEnd, temp);
            lEnd++;
            rStart++;
        }
    }

    public void push_back(int i) {
        right.put(rEnd , i);
        rEnd++;
        balance();
    }
    public void push_front_right(int i){
        rStart--;
        right.put(rStart , i);
        balance();
    }
    public void push_front(int i) {
        lStart--;
        left.put(lStart,i);
        balance();
    }
    public void push_back_left(int i) {
        left.put(lEnd, i);
        lEnd++;
        balance();

    }
    public void push_middle(int i) {
        //int med = (numElem+1)/2;
        if (left.size() == right.size()){
            rStart--;   
            right.put(rStart,i);
        }else {
            int temp = right.remove(rStart);
            left.put(lEnd, temp) ;
            lEnd++;
            right.put(rStart,i);
        }
        
        /*for (Integer key : left.keySet()) {
            System.out.println(left.get(key) + "left" + key);
        }
        for (Integer key : right.keySet()) {
            System.out.println(right.get(key) + "right" + key);
        }*/
    }

    public int gett(int i ) {
        int n = lEnd - lStart;
        if(i < n ) {
            int temp = i + lStart;
            return left.get(temp);
        }else {
            i = i - n ;
            return right.get(rStart + i);
        }
        
    }
}
public class TQ{
    public static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)  throws IOException{
        teque tq = new teque();
        /*tq.push_back(8);
        tq.push_back(9);
        tq.push_back(10);
        tq.push_front(3);
        tq.push_front(2);
        tq.push_front(1);
        tq.push_middle(4);
        tq.push_middle(5);
        tq.push_middle(6);
        tq.push_middle(7);
        //tq.gett(3);
        //tq.gett(8); */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n ; i++) {
            String temp =  br.readLine();
            String cmd = (temp.split(" ")[0]);
            int id = Integer.parseInt(temp.split(" ")[1]);
            if(cmd.equals("push_back")) {
                tq.push_back(id);
            }else if(cmd.equals("push_front")) {
                tq.push_front(id);
            }else if(cmd.equals("push_middle")) {
                tq.push_middle(id);
            }else if(cmd.equals("get")) {
                bw.append(tq.gett(id) +"\n" );
            }
        }
        bw.close();
    }
}
