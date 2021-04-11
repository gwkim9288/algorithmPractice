package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Problem_1874 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		LinkedList<String> prList= new LinkedList<String>();
		int next = Integer.parseInt(br.readLine());
		int count = 1;
		for(int i=1;i<N+1;i++) {
			stack.push(i);
			prList.add("+");
			while(stack.peek().equals(next)&&prList.size()<N*2) {
				stack.pop();
				prList.add("-");
				if(count == N)
					break;
				next = Integer.parseInt(br.readLine());
				count++;
				if(stack.isEmpty())
					break;
			}
		}
		if(stack.isEmpty()) {
			for(String i : prList) {
				System.out.println(i);
			}
		}
		else
			System.out.println("NO");
		
	}
}
