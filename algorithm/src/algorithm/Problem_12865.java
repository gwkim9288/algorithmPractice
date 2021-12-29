package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_12865 {

    static int N;
    static int K;
    static ArrayList<int[]> list;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.add(new int[]{M,V});
        }
        decide(0,0,0);
    }

    public static void decide(int m , int v, int index){
        for(int i=index+1;i<list.size();i++){
            if(list.get(i)[0]+m<K){
                decide(list.get(i)[0]+m,list.get(i)[1]+v,i);
            }
        }
    }
}
