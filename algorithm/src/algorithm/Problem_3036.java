package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3036 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int first = Integer.parseInt(st.nextToken());
		int now;
		for(int i =0;i<n-1;i++) {
			now = Integer.parseInt(st.nextToken());
			int a= maxDivide(first,now);
			System.out.println(first/a+"/"+now/a);
		}
	}
	
	public static int maxDivide(int num1,int num2) {
		int result =1;
		for(int i =1;i<=Math.min(num1, num2);i++) {
			if(num1%i==0&&num2%i==0)
				result = i;
		}
		return result;
	}
}
