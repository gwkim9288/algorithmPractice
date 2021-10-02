package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2206 {

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int[][] map;
    public static int[][] visited;
    public static int M;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new int[M][N];
        for(int i=0;i<M;i++){
            String next = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = Character.getNumericValue(next.charAt(j));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }

    public static int bfs(){
        Queue<Point> qu = new LinkedList<>();
        qu.add(new Point(0,0,1,0));
        while(!qu.isEmpty()){
            Point now = qu.poll();

            if(now.x==M-1&&now.y == N-1){
                return now.dist;
            }
            for(int i =0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx>=0&&nx<M&&ny>=0&&ny<N){
                    if(now.drill>=visited[nx][ny])
                        continue;
                    if(map[nx][ny] == 0){
                        qu.add(new Point(nx,ny,now.dist+1,now.drill) );
                        visited[nx][ny] = now.drill;
                    }else{
                        if(now.drill == 0){
                            qu.add(new Point(nx,ny,now.dist+1,now.drill+1));
                            visited[nx][ny] = now.drill+1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

class Point{
    int drill;
    int dist;
    int x;
    int y;
    Point(int x,int y,int dist, int drill){
        this.drill = drill;
        this.dist =dist;
        this.x = x;
        this.y =y;
    }
}