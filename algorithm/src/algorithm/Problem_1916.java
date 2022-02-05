package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node_1916 implements Comparable<Node_1916>{
    int end;
    int weight;
    public Node_1916(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node_1916 o) {
        return weight- o.weight;
    }
}
public class Problem_1916 {
    static int N;
    static int M;
    static int[][] roadList;
    static boolean[] visited;
    static int[] costList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        roadList = new int[N+1][N+1];
        visited = new boolean[N+1];
        costList = new int[N+1];
        for(int i =0 ;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(roadList[start][end] !=0)
                roadList[start][end] = Math.min(roadList[start][end],cost);
            else
                roadList[start][end] = cost;
        }

        for(int i =0 ;i< costList.length;i++){
            costList[i] = Integer.MAX_VALUE;
        }
        int start,end;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        costList[start] =0;
        visited[0] = true;
        dijkstra(start);
        System.out.println(costList[end]);
    }

    static void dijkstra(int idx){
        if(visited[idx])
            return;
        visited[idx]= true;
        for(int i=0;i<roadList[idx].length;i++){
            if(roadList[idx][i]==0)
                continue;
            if(costList[i]>costList[idx]+roadList[idx][i]) {
                costList[i] = costList[idx] + roadList[idx][i];
            }
        }
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i=0;i< costList.length;i++){
            if(min>costList[i]&&!visited[i]){
                min = costList[i];
                minIdx = i;
            }
        }
        dijkstra(minIdx);
    }
}
