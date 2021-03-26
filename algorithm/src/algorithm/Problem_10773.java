package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int num;
		int answer =0;
		for(int i = 0; i<n;i++) {
			num = Integer.parseInt(br.readLine());
			if(num==0)
				stack.pop();
			else
				stack.push(num);
		}
		while(!stack.isEmpty()) {
			answer = answer+stack.pop();
		}
		System.out.println(answer);
	}
}
