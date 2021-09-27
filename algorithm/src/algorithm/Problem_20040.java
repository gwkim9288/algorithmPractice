package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_20040 {
	
	
	public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int pointNum = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int answer;
		for(int i =0;i<num;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			if(arr.get(v1).contains(v2)||arr.get(v2).contains(v1)) {
				answer = i;
				break;
			}
			
			for(int o : arr.get(v1)) {
				arr.get(o).add(v1);
				
			}
		}
	}
	
	public void nextTurn() {
		
	}

}
