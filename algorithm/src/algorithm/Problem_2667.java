package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2667 {
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		visited = new boolean[N][N];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i =0;i<N;i++) {
			String str = br.readLine();
			for(int j =0;j<N;j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					list.add(bfs(i,j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
	}
	
	public static int bfs(int m, int n) {
		Queue<int[]> qu = new LinkedList <int[]>();
		qu.add(new int[] {m,n});
		int ret = 1;
		visited[m][n] = true;
		while(!qu.isEmpty()) {
			int[] now = qu.poll();
			for(int i=0;i<4;i++) {
				int[] next = new int[2];
				next[0] = now[0]+dx[i];
				next[1] = now[1]+dy[i];
				if(next[0]<0||next[0]>=N||next[1]<0||next[1]>=N||visited[next[0]][next[1]]||map[next[0]][next[1]]!=1) {
					continue;
				}
				else {
					qu.add(next);
					visited[next[0]][next[1]] = true;
					ret++;
				}
			}
			
		}
		return ret;
	}
}
