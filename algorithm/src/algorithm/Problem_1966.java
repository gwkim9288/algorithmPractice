package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int count =1 ;
		for(int i =0 ; i<testcase;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			Queue<Integer> qu = new LinkedList<Integer>();
			LinkedList<Integer> forSort = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine()," ");
			int file;
			for(int j=0;j<n;j++) {
				file = Integer.parseInt(st.nextToken());
				qu.add(file);
				forSort.add(file);
			}
			Collections.sort(forSort,Collections.reverseOrder());
			Queue<Integer> sorted = forSort;
			while(!qu.isEmpty()) {
				if(qu.peek() == sorted.peek()) {
					if(target == 0)
						break;
					qu.poll();
					sorted.poll();
					count++;
					target--;
				}else {
					if(target==0)
						target = qu.size()-1;
					else
						target--;
					qu.add(qu.poll());
					
				}
			}
			System.out.println(count);
			count =1;
		}
	}
}
