package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_1931 {
	static int[][] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		time = new int[n][2];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1] == arg1[1]) {
                    return arg0[0] - arg1[0];
                } else {
                    return arg0[1] - arg1[1];
                }
            }
        });   
		int end=0;
		int count = 0;
		if(n !=0) {
			end = time[0][1];
			count++;
		}
		for(int i=1 ;i<n;i++) {
			if(end<=time[i][0]) {
				end = time[i][1];
				count ++;
			}
		}
		System.out.println(count);
	}
	
}
