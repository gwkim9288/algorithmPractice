package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		;
		for (int i = 0; i < testNum; i++) {
			String command = br.readLine();
			int num = Integer.parseInt(br.readLine());
			String[] listStr = br.readLine().trim().split(",|\\[|\\]");
			Deque<Integer> list = new ArrayDeque<Integer>();
			boolean first = true;
			boolean error = false;
			for (int j = 0; j < listStr.length; j++) {
				if (listStr[j].equals(""))
					continue;
				list.add(Integer.parseInt(listStr[j]));
			}
			for (int j = 0; j < command.length(); j++) {
				if (command.charAt(j) == 'R') {
					first = !first;
				} else if (command.charAt(j) == 'D') {
					if (list.isEmpty()) {
						error = true;
						break;
					}
					if (first)
						list.pollFirst();
					else
						list.pollLast();
				}
			}
			int size = list.size();
			if (error)
				System.out.println("error");
			else {
				if (first) {
					if (list.isEmpty())
						System.out.println("[]");
					else
						System.out.println(list.toString().replace(" ", ""));
				} else {
					if (list.isEmpty())
						System.out.println("[]");
					else {
						List<Integer> listp = new LinkedList<Integer>();
						for (int j = 0; j < size; j++)
							listp.add(list.pollLast());
						System.out.println(listp);
						System.out.println(listp.toString().replace(" ", ""));
					}
				}
			}
		}
	}
}
