package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_1655 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minq = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>();
		int nextItem;
		maxq.add(Integer.parseInt(br.readLine()));
		System.out.println(maxq.peek());
		for(int i = 1; i<n;i++) {
			nextItem = Integer.parseInt(br.readLine());
			if(maxq.peek()>nextItem) {
				minq.add(nextItem);
			}else {
				maxq.add(nextItem);
			}
			if(maxq.size()>minq.size()+1) {
				minq.add(maxq.poll());
			}else if(minq.size()>maxq.size()+1) {
				maxq.add(minq.poll());
			}
			if(minq.size()>maxq.size())
				System.out.println(minq.peek());
			else if(minq.size()==maxq.size())
				System.out.println(minq.peek());
			else
				System.out.println(maxq.peek());
		}
	}

}
