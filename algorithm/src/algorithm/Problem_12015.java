package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_12015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	//	int[] list = new int[n];
//		for(int i =0 ;i<n;i++)
//			list[i] = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int start =0;
		int end=n-1;
		int mid;
		int value;
		arr.add(0);
		for(int i =0;i<n;i++) {
			value = Integer.parseInt(st.nextToken());
			if(value>arr.get(arr.size()-1))
				arr.add(value);
			else {
				start =0;
				end = arr.size()-1;
				mid = (start+end)/2;
				while(start<end) {
					mid = (start+end)/2;
					if(value<=arr.get(mid))
						end = mid;
					else
						start = mid+1;
				}
				arr.set(end, value);
			}
				
		}
		System.out.println(arr.size()-1);
	}

}
