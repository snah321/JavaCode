import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class WhatDoesTheFoxSay {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws  IOException {
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < t ; i++ ) {
            String[] sounds = br.readLine().split(" ");
            ArrayList<String> all = new ArrayList<String>(); 
            ArrayList<String> others = new ArrayList<String>(); 
            for(String j : sounds) {
                all.add(j);
            }
            
            while (true) {
                String temp = br.readLine();
                if(temp.equals("what does the fox say?")) {
                    break;
                }
                temp = temp.split(" ")[2];
                others.add(temp);
                
            }
            for(String k : all){
                if(!others.contains(k)) {
                    bw.append(k + " ");
                }
            }
        }
        bw.flush();
    }

}