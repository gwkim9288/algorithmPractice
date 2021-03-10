package algorithm;

import java.util.Scanner;

public class BackTracking2 {
	//12865 평범한 배낭 0309
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int weight = scan.nextInt();
		int[][] product = new int[num][2];
		for(int i =0;i<num;i++) {
			product[i][0] = scan.nextInt();
			product[i][1] = scan.nextInt();
		}
		
	}

}
