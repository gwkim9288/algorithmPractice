package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Stack1 {
	//17298 오큰수 0311
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int[] nums = new int[num];
		int[] result = new int[num];
		String[] input = bf.readLine().split(" ");
		for(int i = 0; i < num; i++)
			nums[i] = Integer.parseInt(input[i]);
		
		stack.push(0);
		for(int i = 1; i < num; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
				result[stack.pop()] = nums[i];
			stack.push(i);
		}
		
		while(!stack.isEmpty())
			result[stack.pop()] = -1;
		
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		
		for(int i = 0; i < num; i++)
			bw.write(result[i]+" ");
		
		bw.flush();
		return;
	}
}
//////////////////////0313
/////////0315