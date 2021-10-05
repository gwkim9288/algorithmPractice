package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_2533 {

    static ArrayList<Integer>[] nodes;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        nodes = new ArrayList[num+1];
        list = new int[num+1][2];

        for(int i=0;i<num+1;i++)
            nodes[i] = new ArrayList<>();
        for(int i =0;i<num-1;i++){
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        dfs(1,-1);

        System.out.println(Math.min(list[1][0],list[1][1]));
    }

    public static void dfs(int now,  int parent){
        list[now][0] = 0;
        list[now][1] = 1;
        for(int i =0 ;i<nodes[now].size();i++) {
            int next = nodes[now].get(i);
            if (next == parent)
                continue;
            dfs(next,now);
            list[now][1] += Math.min(list[next][1],list[next][0]);
            list[now][0] += list[next][1];
        }

    }
}
