package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_15955 {
	
	static LinkedList<int[]> points;
	static boolean[] visited;
	static int caseNum;
	static int pointNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		pointNum = Integer.parseInt(st.nextToken());
		caseNum = Integer.parseInt(st.nextToken());
		points = new LinkedList<int[]>();
		points.add(new int[] {0,0}); 
		for(int i=0;i<pointNum;i++) {
			st= new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new int[] {x,y});
		}
		for(int i =0 ;i<caseNum;i++) {
			st = new StringTokenizer(br.readLine()," ");
			visited = new boolean[pointNum+1];
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int hp = Integer.parseInt(st.nextToken());
		}
	}
	
	public static boolean moveChr(int start,int end, int maxhp) {
		Queue<Integer> qu = new LinkedList<Integer>(); 
		qu.add(start);
		int hp = maxhp;
		visited[start] = true;
		while(!qu.isEmpty()) {
			int now = qu.poll();
			int[] nowPoint = points.get(now);
			for(int i=1;i<=pointNum;i++) {
				if(i==now)
					continue;
				int[] ckpoint = points.get(i);
				if(ckpoint[0]==nowPoint[0]||ckpoint[1]==nowPoint[1]) {
					qu.add(i);
					visited[i] = true;
					hp = maxhp;
				}
//				else if(Math.abs(ckpoint[0]-nowPoint[0])+Math.pow(ckpoint[1]-nowPoint[1])<Math.pow(hp)) {
//					qu.add(i);
//					visited[i] = true;
//					hp = maxhp;
//				}

			}
		}
		return false;
	}
}
