package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1697 {

	//방문처리 필수 / 없으면 메모리 터짐
	static int start,end;
	static Queue<Integer> field = new LinkedList<Integer>();
	static int ans =0;
	static boolean find = false;
	static boolean[] visit = new boolean[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		bfs();
		if(start == end)
			ans =0;
		System.out.println(ans);
	}
	
	public static void bfs() {
		field.add(start);
		int a =start;
		int count;
		int b= 0;
		while(true) {
			count = field.size();
			for(int i =0;i<count;i++) {
				a= field.poll();
				for(int j=0; j<3;j++) {
					switch(j) {
					case 0:
						b = a-1;
						break;
					case 1:
						b = a+1;
						break;
					case 2:
						b = a*2;
						break;
					}
					if(b<0||b>100000||visit[b])
						continue;
					if(b== end){
						find = true;
						break;
					}
					visit[b] = true;
					field.add(b);
				}
				if(find) 
					break;
			}
			ans++;
			if(find)
				break;
		}
	}
}
