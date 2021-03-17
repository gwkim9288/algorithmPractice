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
		int num=0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i =0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		LinkedList<String> prList= new LinkedList<String>();
		boolean check = true;
		
		for(int i=1;i<N+1;i++) {
			if(i<=list.get(num)) {
				stack.push(i);
				prList.add("+");
			}else {
				if(stack.peek().equals(list.get(num))) {
					stack.pop();
					prList.add("-");
					num++;
					i--;
				}
				else {
					System.out.println("NO");
					check=false;
					break;
				}
			}
		}
		if(check) {
			for(String i : prList) {
				System.out.println(i);
			}
		}
	}
}
