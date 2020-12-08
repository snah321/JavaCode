import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*; 

class res implements Comparable<res>{
    int a; 
    int s;
    public res(int a , int s) {
        this.a = a;
        this.s = s;
    }
    public int compareTo(res other) {
        return this.a - other.a;
    }
}

class work implements Comparable<work>{
    public int nextLock; 
    public int inUse;
    
    public work(res r, int m) {
        this.nextLock = r.a + r.s + m ;
        this.inUse = r.a + r.s ;
    }
    public int compareTo(work other) {
        return other.nextLock - this.nextLock;
    }
}


public class WorkStation {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws  IOException {
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(temp.nextToken());
        int m = Integer.parseInt(temp.nextToken());
        ArrayList<res> al = new ArrayList<res>();
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer temp2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(temp2.nextToken());
            int s = Integer.parseInt(temp2.nextToken());
            al.add(new res(a,s));
        }
        Collections.sort(al);

        PriorityQueue<work> wpq = new PriorityQueue<work>(Collections.reverseOrder());
        
        int locks = 0;
        boolean first = true;
        
        for(res r : al) {
            if(first) { // first ws unlock once
                wpq.add(new work(r,m));
                locks++;
                first = false;
                
            }else if(wpq.peek().inUse > r.a ) { // if ws is in use , unlock a new ws
                wpq.add(new work(r,m));
                locks++;
            }else if((r.a >= wpq.peek().inUse) && (r.a <= wpq.peek().nextLock) ) {
                work temp2 = wpq.poll();
                temp2.inUse = r.a + r.s ;
                temp2.nextLock = r.a + r.s +m  ;
                wpq.add( temp2);
            }else if((r.a > wpq.peek().inUse) && (r.a > wpq.peek().nextLock) ) {
                boolean free = false;
                for(int i = 0 ; i < wpq.size() ; i++) {
                    if(r.a > wpq.peek().nextLock ) {
                        wpq.remove();
                    }else if((r.a >= wpq.peek().inUse) && (r.a <= wpq.peek().nextLock)) {
                        work temp3 = wpq.poll();
                        temp3.inUse = r.a + r.s ;
                        temp3.nextLock = r.a + r.s +m  ;
                        wpq.add(temp3);
                        free = true;
                        break;
                    }
                }if(free) {
                    ;
                }else {
                    
                    wpq.add(new work(r,m));
                    locks++;
                }
            }
        }
        System.out.println(n-locks);
        
        
    }
}

