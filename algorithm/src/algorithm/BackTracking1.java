package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking1{
	//9663 n-queen 0309 not clear
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for(int i =0;i<n;i++) {
			for(int j =0 ; j<n;j++) {
				if(board[i][j] == 0) {
					for(int k =0;k<n;k++) {
						board[i][k]=1;
						board[k][j]=1;
						if(i-(n/2)+k>=0&&j-(n/2)+k>=0)
							board[i-(n/2)+k][j-(n/2)+k]=1;
						if(i+(n/2)-k<n&&j+(n/2)-k<n)
							board[i+(n/2)-k][j+(n/2)-k]=1;
					}
					break;
				}
			}
		}
	}
}
