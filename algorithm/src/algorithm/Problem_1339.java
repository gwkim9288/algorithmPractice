package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1339 {
    public static HashMap<Character,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            String str = br.readLine();
            for(int j =0;j<str.length();j++){
                char now = str.charAt(j);
                if(map.containsKey(now)){
                    map.put(now, (int) (map.get(now)+Math.pow(10,(str.length()-j-1))));
                }else{
                    map.put(now, (int) Math.pow(10,(str.length()-j-1)));
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        for(Character c : map.keySet()){
            if(list.size()==0){
                list.add(0,map.get(c));
                continue;
            }
            for(int i =0;i<list.size();i++){
                if(list.get(i)>=map.get(c)) {
                    list.add(i, map.get(c));
                    break;
                }
            }
        }

        System.out.println()
        int ans =0;
        for(int i =0;i<list.size();i++){
            ans += list.get(i)*(i+(10-list.size()));
        }
        System.out.println(ans);
    }
}
