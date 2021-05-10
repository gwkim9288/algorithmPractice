package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15998 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		System.out.println(-15500%10000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rest = 0;
		long now =10000;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a>=0) {
				rest = b;
				continue;
			}
			else if(rest>=-1*a) {
				rest = b;
				continue;
			}
			else {
				if(now<b)
					now = b;
				while(now<=9*Math.pow(10,18)) {
					
					if((rest+a)%now+now ==b)
						break;
					now++;
				}
				rest = b;
			}
		}
		if(now == 9*Math.pow(10,18)+1)
			System.out.println(-1);
		else
			System.out.println(now);

	}
}
