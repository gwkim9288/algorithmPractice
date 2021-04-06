package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1012 {
	
	static int M,N,K;
	static int count;
	static boolean[][] visit;
	static int[][] field;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static Queue<int[]> queue;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i =0;i<testcase;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			field = new int[M][N];
			visit = new boolean[M][N];
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine()," ");
				field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			count=0;
			for(int j =0;j<M;j++) {
				for(int k =0;k<N;k++) {
					if(!visit[j][k]&&field[j][k]==1) {
						bfs(j,k);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void bfs(int x,int y) {
		queue = new LinkedList<int[]>();
		queue.add(new int[]{x,y});
		while(!queue.isEmpty()) {
			x=queue.peek()[0];
			y= queue.peek()[1];
			visit[x][y]=true;
			queue.poll();
			int cx;
			int cy;
			for(int i =0;i<4;i++) {
				cx = x+dx[i];
				cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<M&&cy<N) {
					if(field[cx][cy]==1&&!visit[cx][cy]) {
						queue.add(new int[] {cx,cy});
						visit[cx][cy]=true;
					}
				}
				
			}
		}
	}

}
