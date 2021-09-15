package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Problem_7490 {
	public static LinkedList<String> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i =0;i<testCase;i++) {
			int N = Integer.parseInt(br.readLine());
			arr= new LinkedList<String>();
			addStr("1",0,0,N,1,0);
			Collections.sort(arr);
			for(int j =0 ;j<arr.size();j++)
				System.out.println(arr.get(j));
			System.out.println();
		}
		
	}
	
	public static void addStr(String str, int sign,int prev, int target, int now, int num) {
		
		if(now == target) {
			if(sign == 0)
				num = num+(prev*10+now);
			else
				num = num -(prev*10+now);
			
			if(num==0)
				arr.add(str);
			return;
		}
		if(sign==0) {
			addStr(str+"+"+(now+1),0,0,target,now+1,num+(prev*10+now));
			addStr(str+"-"+(now+1),1,0,target,now+1,num+(prev*10+now));
			addStr(str+" "+(now+1),sign,prev*10+now,target,now+1,num);
		}else {
			addStr(str+"+"+(now+1),0,0,target,now+1,num-(prev*10+now));
			addStr(str+"-"+(now+1),1,0,target,now+1,num-(prev*10+now));
			addStr(str+" "+(now+1),sign,prev*10+now,target,now+1,num);
		}
	}
	

}
