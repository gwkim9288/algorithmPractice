package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String num = "";
		int ans = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		int i=0;
		int j=100;
		for(i =0;i<str.length();i++) {
			if(str.charAt(i)=='+'||str.charAt(i)=='-') {
				list.add(Integer.parseInt(num));
				num = "";
				if(str.charAt(i)=='-') {
					j=Math.min(list.size(), j);
				}
			}
			else {
				num += str.charAt(i);
			}
			
		}
		list.add(Integer.parseInt(num));
		if(j>list.size())
			j = list.size();
		for(int k =0;k<j;k++)
			ans += list.get(k);
		for(int k = j;k<list.size();k++)
			ans -= list.get(k);
		System.out.println(ans);
	}
}
