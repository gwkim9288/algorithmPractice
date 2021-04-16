package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_11286 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> quplus = new PriorityQueue<Integer>();
		PriorityQueue<Integer> quminus = new PriorityQueue<Integer>(Collections.reverseOrder());
		int num;
		for(int i=0 ; i<n;i++) {
			num = Integer.parseInt(br.readLine());
			if(num>0) {
				quplus.add(num);
			}
			else if(num<0) {
				quminus.add(num);
			}
			else {
				if(quminus.isEmpty()&&quplus.isEmpty())
					System.out.println(0);
				else if(quplus.isEmpty())
					System.out.println(quminus.poll());
				else if(quminus.isEmpty())
					System.out.println(quplus.poll());
				else {
					if(quplus.peek()==-1*quminus.peek()) {
						System.out.println(quminus.poll());
					}else if(quplus.peek()<-1*quminus.peek()) {
						System.out.println(quplus.poll());
					}else {
						System.out.println(quminus.poll());
					}
				}
				
			}
		}
	}
}
