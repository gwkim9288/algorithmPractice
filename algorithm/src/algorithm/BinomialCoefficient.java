package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient {
	//11051이항계수2 0310
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] triangle = new int [N+1][N+1];
		for(int i =0 ; i<N+1;i++) {
			for(int j=0;j<=i ;j++) {
				if(j==0||j==i)
					triangle[i][j] = 1;
				else
					triangle[i][j] = (triangle[i-1][j-1]+triangle[i-1][j])%10007;
			}
		}
		System.out.println(triangle[N][k]%10007);
	}
}
