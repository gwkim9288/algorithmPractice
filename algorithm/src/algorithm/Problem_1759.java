package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1759 {

    static int C;
    static int L;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new char[C];
        for(int i =0;i<C;i++)
            arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        for(int i=0;i<=C-L;i++)
            addStr(i,Character.toString(arr[i]),L-1);


    }

    public static void addStr(int idx, String str, int num){
        if(num==0) {
            if(correctPwd(str))
                System.out.println(str);

            return;
        }
        for(int i =idx+1;i<=C-num;i++){
            addStr(i,str+arr[i],num-1);
        }
    }

    public static boolean correctPwd(String str){
        int a = 0;
        int b = 0;
        for(int i=0;i<str.length();i++){
            char now = str.charAt(i);
            if(now == 'a'||now == 'e'||now == 'i'||now == 'o'||now == 'u')
                a++;
            else
                b++;
        }
        if(a>=1&&b>=2)
            return true;
        else
            return false;
    }
}
