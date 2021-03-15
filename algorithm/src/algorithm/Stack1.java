package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack1 {
	//17298 오큰수 0311
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stackN = new Stack<Integer>();
		int[] list = new int[n];
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {	
			int size = stack.size();
			for (int j = 0; j<size; j++) {
				if(stack.isEmpty())
					break;
				if (stack.peek() < list[i]) {
					stack.pop();
					answer[stackN.pop()] = list[i];
				}
				else
					break;
			}
			stack.push(list[i]);
			stackN.push(i);
		}
		for(int i =0;i<n;i++) {
			if(answer[i]!=0)
				System.out.print(answer[i]+ " ");
			else
				System.out.print("-1 ");
		}
	}
}
//////////////////////0313
/////////0315