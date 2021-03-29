package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int node = Integer.parseInt(br.readLine());
		int link = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> virus = new ArrayList<Integer>();
		virus.add(1);
		for(int i =0;i<node;i++)
			arr.add(new ArrayList<Integer>());
		int[] next = new int[2];
		for(int i=0;i<link;i++){
			st= new StringTokenizer(br.readLine()," ");
			next[0] =Integer.parseInt(st.nextToken());
			next[1] =Integer.parseInt(st.nextToken());
			arr.get(next[0]-1).add(next[1]);
			arr.get(next[1]-1).add(next[0]);
		}
		System.out.println(link);
		for(int i =0; i<virus.size();i++) {
			System.out.println(i);
			for(int j=0;j<arr.get(virus.get(i)-1).size();j++) {
				if(!virus.contains(arr.get(virus.get(i)-1).get(j)))
					virus.add(arr.get(virus.get(i)-1).get(j));
				System.out.println(virus);
			}
		}
		System.out.println(virus.size()-1);
	}

}
