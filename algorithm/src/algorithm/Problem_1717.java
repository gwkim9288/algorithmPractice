package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Problem_1717 {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new int[n+1];
        for(int i =0;i<n+1;i++)
            list[i] = i;

        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(command == 0){
                union(a,b);
            }else if(command ==1){
                hasSameParent(a,b);
            }
        }
    }

    public static int find(int x){
        if(list[x] == x)
            return x;
        else
            return list[x] = find(list[x]);
    }

    public static void hasSameParent(int x, int y){
        if(find(x) == find(y))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y)
            list[y] = x;
    }

}
