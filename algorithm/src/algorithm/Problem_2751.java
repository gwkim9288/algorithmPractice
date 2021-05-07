package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  =new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> qu = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			qu.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(qu);
		for(Integer i : qu) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
