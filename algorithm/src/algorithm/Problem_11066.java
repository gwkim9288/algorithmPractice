package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_11066 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i =0; i<caseNum;i++) {
			int listSize = Integer.parseInt(br.readLine());
			int item=0; 
			long answer =0 ;
			st = new StringTokenizer(br.readLine()," ");
			PriorityQueue<Integer> file = new PriorityQueue<Integer>();
			for(int j=0;j<listSize;j++)
				file.add(Integer.parseInt(st.nextToken()));
			while(file.size()>1) {
				item = file.poll()+file.poll();
				file.add(item);
				answer = answer+item;
			}
			System.out.println(answer);
		}
	}
}
