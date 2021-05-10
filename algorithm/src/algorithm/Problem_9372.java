package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_9372 {
	
	public static int[] ans;
	public static int[] parents;
	public static boolean[] visited ;
	public static int[][] plane;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		ans = new int[testNum];
		for(int i =0;i<testNum;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int a,b;
			int answer =0;
			plane = new int[m+1][2];
			parents = new int[n+1];
			visited = new boolean[n+1];
			for(int j=0;j<n+1;j++) {
				parents[j] = j;
			}
			for(int j=0;j<m;j++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				plane[j][0] = a;
				plane[j][1] = b;
				a = find(plane[j][0]);
				b = find(plane[j][1]);
				if(a==b)
					continue;
				else {
					union(a,b);
					answer ++;
				}
			}
			System.out.println(answer);
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		parents[a] = find(parents[a]);
		return parents[a];
	}
	
	public static void union(int a ,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parents[aRoot] = b;
		}
	}
}


