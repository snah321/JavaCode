import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class GuessTheDS {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    
    public static void main(String[] args) throws  IOException {
        String line = "i";
        while((line = br.readLine())!=null) {
            Stack<Integer> stack = new Stack<>();
            boolean isStack = true;
            
            Queue<Integer> queue = new LinkedList<>();
            boolean isQueue = true;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            boolean isPQ = true;
            
            int n = Integer.parseInt(line);
            for (int i = 0 ; i <n ; i++) {
                StringTokenizer temp = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(temp.nextToken());
                int inp = Integer.parseInt(temp.nextToken());
                
                if(cmd == 1) {
                    if(isStack) {
                        stack.push(inp);
                    }
                    if(isQueue) {
                        queue.offer(inp);
                    }
                    if(isPQ) {
                        pq.offer(inp);
                    }
                }else if(cmd == 2) {
                    if(stack.size() == 0 ||stack.pop() != inp) {
                        isStack = false;
                    }
                    if(queue.size() == 0 ||queue.poll() != inp) {
                        isQueue = false;
                    }
                    if(pq.size() == 0 || pq.poll() != inp ) {
                        isPQ = false;
                    }
                }
            }
                
            if(!isStack && !isQueue && !isPQ) {
                bw.append("impossible" + "\n");
            }else if((isStack && isQueue) || (isStack && isPQ) || (isQueue && isPQ)) {
                bw.append("not sure" + "\n");
            }else if(isStack) {
                bw.append("stack" + "\n");
            }else if(isQueue) {
                bw.append("queue" + "\n");
            }else if(isPQ) {
                bw.append("priority queue" + "\n");
            }
                
            bw.flush();
            
        }
    }

}
