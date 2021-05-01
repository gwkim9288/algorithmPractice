package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1753 {
	static int[][] field;
	static final int INF = 1000000;
	static int v;
	static int[] dist;
	static boolean[] visited;
	static int start;
	static PriorityQueue<Integer> qu;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		field = new int[v+1][v+1];
		dist = new int[v+1];
		visited = new boolean[v+1];
		qu = new PriorityQueue<Integer>();
		for(int i =0 ; i<=v;i++) {
			for(int j=0;j<=v;j++) {
				if(i==j)
					field[i][j] =0;
				else
					field[i][j] = INF;
			}
			dist[i] = INF;
		}
		
		for(int i =0;i<e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			field[a][b] = Math.min(c,field[a][b]);
		}
		dist[start] = 0;
		visited[start] = true;
		shortPath(start);
		for(int i=1;i<=v;i++) {
			if(start == i)
				System.out.println(0);
			else if(dist[i]==INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
	
	public static void shortPath(int point) {
		for(int i=1;i<=v;i++) {
			dist[i] = Math.min(dist[i], dist[point]+field[point][i]);
			if(visited[i])
				continue;
			else {
				qu.add(i);
				visited[i] = true;
			}
		}
		for(Integer i :qu) {
			qu.poll();
			shortPath(i);
		}
	}

}
