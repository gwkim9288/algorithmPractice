package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_7562 {
	
	static int caseNum;
	static int[][] map;
	static Queue<int[]> qu = new LinkedList<int[]>();
	static int[] dx = {2,2,1,1,-2,-2,-1,-1};
	static int[] dy = {1,-1,2,-2,1,-1,2,-2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		caseNum = Integer.parseInt(br.readLine());
		for(int i =0 ; i < caseNum ; i++) {
			int len = Integer.parseInt(br.readLine());
			map = new int[len][len];
			int[] start = new int[2];
			int[] target = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			target[0] = Integer.parseInt(st.nextToken());
			target[1] = Integer.parseInt(st.nextToken());
			bfs(start,target,len);
			System.out.println(map[target[0]][target[1]]);
			
		}
	}
	
	public static void bfs(int[] start, int[] end,int len) {
		if(start.equals(end))
			return;
		qu.clear();
		qu.add(start);
		map[start[0]][start[1]] = 1;
		while(!qu.isEmpty()) {
			int[] now = qu.poll();
			int[] next = new int[2];
			for(int i =0 ;i<8;i++) {
				next[0] = now[0] + dx[i];
				next[1] = now[1] + dy[i];
				if(next[0]<len&&next[0]>=0&&next[1]<len&&next[1]>=0&&map[next[0]][next[1]]==0) {
					map[next[0]][next[1]] = map[now[0]][now[1]]+1;
					qu.add(next);
				}
				if(next[0] == end[0]&&next[1] == end[1])
					return;
			}
		}
	}
}
