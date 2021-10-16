package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1654 {
    static int[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        lan = new int[k];
        for(int i =0 ;i<k;i++){
            lan[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lan);
        int target = lan[k-1];
        long max = target++;
        long min = 0;
        long mid;
        while(min<max){
            int num = 0;
            mid = (max+min)/2;
            for(int i=0;i<k;i++){
                num += lan[i]/mid;
            }
            if(num<n){
                max = mid;
            }else{
                min = mid+1;
            }

        }
        System.out.println(min-1);
    }
}
