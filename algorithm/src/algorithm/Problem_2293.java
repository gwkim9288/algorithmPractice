package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2293 {
	static int n,k;
	static List<Integer> coin;
	static int count =0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new LinkedList<Integer>();
		for(int i =0;i<n;i++) {
			coin.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(coin);
		addcoin(0,0);
		System.out.println(count);
	}
	
	public static void addcoin(int sum,int a) {
		int now;
		for(int i =a;i<n;i++) {
			now = sum+coin.get(i);
			if(now ==k) {
				count++;
				return;
			}
			else if(now>k)
				return;
			addcoin(now,i);
		}
		return;
	}
}
