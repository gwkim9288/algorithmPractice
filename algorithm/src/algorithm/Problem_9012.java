package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_9012 {
	
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			boolean check = true;
			Stack<Integer> st = new Stack<Integer>(); 
			for(int j =0 ; j<str.length();j++) {
				if(str.charAt(j) == '(') {
					st.push(1);
				}
				else {
					if(st.isEmpty())
						check = false;
					else
						st.pop();
				}
			}
			if(!st.isEmpty())
				check = false;
			if(check)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
