package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15955 {
	
	static int[][] points;
	static int caseNum;
	static int pointNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		pointNum = Integer.parseInt(st.nextToken());
		caseNum = Integer.parseInt(st.nextToken());
		for(int i =0 ;i<caseNum;i++) {
			st = new StringTokenizer(br.readLine()," ");
		}
	}
}
