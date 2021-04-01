package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1260 {
	
	static ArrayList<ArrayList<Integer>> way = new ArrayList<ArrayList<Integer>>();
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int point = Integer.parseInt(st.nextToken());
		int wayNum = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		for(int i =0;i<point+1;i++)
			way.add(new ArrayList<Integer>());
		int n1;
		int n2;
		for(int i =0;i<wayNum;i++) {
			st = new StringTokenizer(br.readLine()," ");
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			way.get(n1).add(n2);
			way.get(n2).add(n1);
		}
		for(int i =0;i<point+1;i++) {
			Collections.sort(way.get(i));
		}
		check = new boolean[point+1];
		dfs(start);
        System.out.println();

		
		check = new boolean[point+1];
		bfs(start);
        System.out.println();

	}
	
	public static void dfs(int now) {//,ArrayList<Integer> list 
		if(check[now])
			return;
		check[now] =true;
		System.out.print(now+" ");

		for(int i =0; i<way.get(now).size();i++) {
			dfs(way.get(now).get(i));
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int y : way.get(x)) {
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }
	}

}
