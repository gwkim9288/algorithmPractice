package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10026 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        for(int i =0 ;i<N;i++){
            String str = br.readLine();
            for(int j =0;j<N;j++){
                if(str.charAt(j) =='R')
                    board[i][j] = 1;
                else if(str.charAt(j) == 'G')
                    board[i][j] = 2;
                else
                    board[i][j] = 3;
            }
        }
        int ans1 =0;
        for(int i =0 ;i<N;i++){
            for(int j=0 ; j<N;j++){
                if(!visited[i][j]){
                    ans1++;
                    dfs(i,j,board[i][j]);
                }
            }
        }

        visited = new boolean[N][N];
        int ans2 =0;
        for(int i =0 ;i<N;i++){
            for(int j=0 ; j<N;j++){
                if(!visited[i][j]){
                    ans2++;
                    dfs2(i,j,board[i][j]);
                }
            }
        }
        System.out.println(ans1+" "+ans2);
    }

    //1 = red, 2= green, 3 = blue
    static void dfs(int x, int y, int color){
        if(visited[x][y])
            return;

        if(color == board[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx >= 0 && newx < N && newy >= 0 && newy < N && !visited[newx][newy])
                    dfs(newx, newy, color);
            }
        }
    }

    static void dfs2(int x, int y, int color){
        if(visited[x][y])
            return;
        if(color == board[x][y]||color+board[x][y]==3) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx >= 0 && newx < N && newy >= 0 && newy < N && !visited[newx][newy])
                    dfs2(newx, newy, color);
            }
        }
    }
}
