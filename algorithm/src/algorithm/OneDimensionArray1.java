package algorithm;

import java.util.Scanner;

public class OneDimensionArray1 {
	//4344 평균은 넘겠지	0308
	static public void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int testcaseNum = scan.nextInt();
		for(int i = 0 ; i<testcaseNum;i++) {
			int studentNum = scan.nextInt();
			int[] score = new int[studentNum];
			int scoreSum =0;
			for(int j =0 ; j<studentNum;j++) {
				score[j] = scan.nextInt();
				scoreSum += score[j];
			}
			float average = scoreSum/studentNum;
			int overAverage =0;
			for(int j =0;j<studentNum;j++) {
				if(score[j]>average)
					overAverage++;
			}
			float answer = (float)overAverage/(float)studentNum*100;
			System.out.printf("%.3f%%\n",answer);
		}
		scan.close();
	}
}
