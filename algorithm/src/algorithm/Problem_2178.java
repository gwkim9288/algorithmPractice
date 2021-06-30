package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2178 {
	
	static byte[] dx = {0,1,0,-1}; 
	static byte[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] board;
	static int n,m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];
		for(int i =0;i<n;i++) {
			String str = br.readLine();
			for(int j =0 ;j<m;j++) {
				board[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}	
		bfs();
		System.out.println(board[n-1][m-1]);
	}
	
	public static void bfs() {
		Queue<byte[]> qu = new LinkedList<byte[]>();
		qu.add(new byte[]{0,0});
		byte[] now;
		visited[0][0] = true;
		while(!qu.isEmpty()) {
			byte [] next = new byte [2]; 
			now = qu.poll();
			
			for(int i =0;i<4;i++) {
				next[0] = (byte) (now[0]+dx[i]);
				next[1] = (byte)(now[1]+dy[i]);
				if(next[0]<0||next[0]>=n||next[1]<0||next[1]>=m||board[next[0]][next[1]]==0||visited[next[0]][next[1]])
					continue;
				else {
//					if(next[0]==n-1&&next[1]==m-1)
//						board[next[0]][next[1]]=board[now[0]][now[1]]+1;
					qu.add(new byte[] {next[0],next[1]});
					board[next[0]][next[1]]=board[now[0]][now[1]]+1;
					visited[next[0]][next[1]] = true;

				}
			}
		}
	}
}
