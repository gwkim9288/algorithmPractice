package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2470 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int numA = 0;
        int numB = 0;
        int sum = 2000000000;
        for(int i =0;i<n;i++){
            int min = 0;
            int max = n-1;
            int mid = 0;
            while(min<max){
                mid = (min+max)/2;
                if(arr[i]+arr[mid]>0)
                    max = mid-1;
                else
                    min = mid+1;
            }
            mid = (min+max)/2;
            if(arr[i]== arr[mid])
                continue;
            if(Math.abs(arr[i]+arr[mid])<sum){
                sum = Math.abs(arr[i]+arr[mid]);
                numA = i;
                numB = mid;
            }

        }
        System.out.println(Math.min(arr[numA],arr[numB])+" "+Math.max(arr[numA],arr[numB]));

    }
}
