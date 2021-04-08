package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_7569 {
	
	static int M,N,H;
	static int[][][] box;
	static boolean[][][] visit;
	static Queue<int[]> qu = new LinkedList<int[]>();
	static Queue<int[]> qu2 = new LinkedList<int[]>();
	static int count =-1;
	static int[] dx = {0,1,0,-1,0,0};
	static int[] dy = {1,0,-1,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		visit = new boolean[H][N][M];
		for(int h = 0;h<H;h++) {
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int m=0;m<M;m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for(int h = 0;h<H;h++) {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(box[h][n][m]==1) {
						qu.add(new int[] {m,n,h});
						visit[h][n][m]= true;
					}
				}
			}
		}
		while(true) {
			if(qu.isEmpty())
				break;
			bfs();
		}
		boolean check = true;
		for(int h = 0;h<H;h++) {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(box[h][n][m]==0) {
						check =false;
						break;
					}
				}
				if(!check)
					break;
			}
			if(!check)
				break;
		}
		if(check)
			System.out.println(count);
		else
			System.out.println(-1);
		
	}
	
	public static void bfs() {

		qu2.addAll(qu);
		qu.removeAll(qu);
		int[] next;
		int x,y,z;
		while(!qu2.isEmpty()) {
			next = qu2.poll();
			for(int i =0;i<6;i++) {
				x=next[0]+dx[i];
				y = next[1]+dy[i];
				z = next[2]+dz[i];
				if(x<M&&x>=0&&y<N&&y>=0&&z<H&&z>=0) {
					if(!visit[z][y][x]&&box[z][y][x]==0) {
						qu.add(new int[] {x,y,z});
						visit[z][y][x] =true;
						box[z][y][x] = 1;
					}
				}
			}
		}
		count++;
	}
}
