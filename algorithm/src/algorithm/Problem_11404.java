package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11404 {

	static int cityNum;
	static int[][] bus;
	static int busNum;
	static final int inf = 100000;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cityNum = Integer.parseInt(br.readLine());
		bus = new int[cityNum+1][cityNum+1];
		busNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int start,end,price;
		for(int i =0 ;i<cityNum+1;i++) {
			for(int j=0; j<cityNum+1;j++) {
				if(i==j) continue;
				bus[i][j] = inf;
			}
		}
		for(int i =0;i<busNum;i++) {
			st = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			price = Integer.parseInt(st.nextToken());
			bus[start][end]=Math.min(price, bus[start][end]);
		}
		System.out.println(bus[1][3]);
		for(int i=1;i<cityNum+1;i++) {
			for(int j=1;j<cityNum+1;j++) {
				System.out.print(dfs(i,j,0,0)+" ");
			}
			System.out.println();
		}
		
	}
	public static int dfs(int start,int end,int escape,int test) {
		for(int i=1;i<cityNum+1;i++) {
			
		}
	}
}
