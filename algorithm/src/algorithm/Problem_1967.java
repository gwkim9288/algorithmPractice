package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1967 {

    static ArrayList<Node1967>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i =0;i<n+1;i++)
            list[i] = new ArrayList<Node1967>();
        for(int i =0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Node1967(b,weight));
            list[b].add(new Node1967(a,weight));
        }
        visited[1] = true;
        int[] tmp = dfs(1,0);

        visited= new boolean[n+1];
        visited[tmp[1]] = true;
        int[] ans = dfs(tmp[1],0);
        System.out.println(ans[0]);
    }

    public static int[] dfs(int num, int dist) {
        int[] set = new int[2];
        set[0] = dist;
        set[1] = num;
        int max =0;
        for(int i=0;i<list[num].size();i++){
            if(!visited[list[num].get(i).num]){
                visited[list[num].get(i).num] =true;
                int[] temp = dfs(list[num].get(i).num,list[num].get(i).weight);
                if(max<temp[0]){
                    max = temp[0];
                    set[1] = temp[1];
                }
            }

        }
        set[0] = dist+max ;
        return set;
    }
}

class Node1967{
    int num;
    int weight;
    Node1967(int num, int weight){
        this.num = num;
        this.weight = weight;
    }
}
