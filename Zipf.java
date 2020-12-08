import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Song implements Comparable<Song>{

    public double qi;
    public String si;
    public int i_song;
    
    public Song(double qi , String si , int i_song) {
        this.qi = qi;
        this.si = si;
        this.i_song = i_song;
    }
    public int compareTo(Song other) {
        if(this.qi < other.qi ) {
            return 1;
        }else if(this.qi > other.qi) {
            return -1;
        }else {
            if(this.i_song < other.i_song) {
                return -1;
            }else if(this.i_song > other.i_song){
                return 1;
            }else {
                return 0;
            }
        }
    }
}

public class Zipf {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws  IOException {
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(temp.nextToken());
        int m = Integer.parseInt(temp.nextToken());
        
        ArrayList<Song> song = new ArrayList<Song>();
        int i_song = 0;         
        
        for(int i = 0 ; i < n ; i++) {
                StringTokenizer temp2 = new StringTokenizer(br.readLine());
                long fi = Long.parseLong(temp2.nextToken());
                String si = temp2.nextToken();
                long zi = fi;
                double qi = fi * (i+1);
                song.add(new Song(qi , si , i_song++));     
        }
        Collections.sort(song);
        for(int i = 0; i < m ; i++) {
            bw.append(song.get(i).si + "\n");
        }
        bw.flush();
    }
}
