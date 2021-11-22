package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_4195 {

    static int caseNum;
    static int num;
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseNum = Integer.parseInt(br.readLine());
        for(int i =0;i<caseNum ; i++){
            num = Integer.parseInt(br.readLine());
            for(int j=0;j<num;j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String a = st.nextToken();
                String b = st.nextToken();
                int num1=0;
                int num2=0;
                if(map.containsKey(a)){
                    num1 = map.get(a);
                }else{
                    num1 =1;
                }
                if(map.containsKey(b)){
                    num2 = map.get(b);
                }else{
                    num2 =1;
                }
                int sum = num1+num2;
                map.put(a,sum);
                map.put(b,sum);
                System.out.println(sum);
            }
            map.clear();
        }
    }

}
