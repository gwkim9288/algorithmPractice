package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce1 {
	//2798 블랙잭 0309
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cardNum = Integer.parseInt(st.nextToken());
		int targetNum = Integer.parseInt(st.nextToken());
		String[] cardS = br.readLine().split(" ");
		int[] card = new int[cardS.length];
		for(int i =0; i<cardS.length;i++)
			card[i] = Integer.parseInt(cardS[i]);
		int max = 0;
		for(int i =0 ;i<card.length-2;i++) {
			for(int j=i+1;j<card.length-1;j++) {
				for(int k =j+1;k<card.length;k++) {
					if(card[i]+card[j]+card[k]<=targetNum) {
						if(card[i]+card[j]+card[k]>max) {
							max = card[i]+card[j]+card[k];
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
