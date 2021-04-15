package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem_10866 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> deq = new ArrayDeque<Integer>();
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			switch(command) {
			case "push_front":
				deq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(deq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deq.pollFirst());
				break;
			case "pop_back":
				if(deq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deq.pollLast());
				break;
			case "size":
				System.out.println(deq.size());
				break;
			case "empty":
				if(deq.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if(deq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deq.peekFirst());
				break;
			case "back":
				if(deq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deq.peekLast());
				break;
			}
		}
	}
}
