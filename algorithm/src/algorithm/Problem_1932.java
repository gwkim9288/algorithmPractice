package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr  = new int[n];
		arr[0] = Integer.parseInt(br.readLine());
		for(int i =1; i <n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =i;j>-1;j--) {
				
				if(j ==i) {
					arr[j] = arr[i-1]+Integer.parseInt(st.nextToken());
				}
				else if(j ==0) {
					arr[j] = arr[j]+Integer.parseInt(st.nextToken());
				}
				else {
					if(arr[j]>arr[j-1]) {
						arr[j] = arr[j]+Integer.parseInt(st.nextToken());
					}
					else {
						arr[j] = arr[j-1]+Integer.parseInt(st.nextToken());
					}
				}
			}
		}
		int max =0;
		for(int i=0;i<n;i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		System.out.println(max);
	}
}
