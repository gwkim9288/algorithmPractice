package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy1 {
	//11047 동전 0310	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int coinNum = Integer.parseInt(st.nextToken());
		int targetNum = Integer.parseInt(st.nextToken());
		int[] coin = new int[coinNum];
		int answer = 0;
		for(int i =0; i<coinNum;i++)
			coin[i]= Integer.parseInt(br.readLine());
		for(int i =coinNum-1; i>=0;i--) {
			if(coin[i]<=targetNum) {
				answer = answer + targetNum/coin[i];
				targetNum = targetNum%coin[i];
			}
		}
		System.out.println(answer);
	}
}
