package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<n;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		for(int i=0;i<n-1;i++) {
			arr.set(i+1, arr.get(i)+arr.get(i+1));
		}
		int ans=0;
		for(int i=0;i<n;i++)
			ans +=arr.get(i);
		System.out.println(ans);
	}
}
