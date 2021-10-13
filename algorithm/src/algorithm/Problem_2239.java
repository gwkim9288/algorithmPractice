package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2239 {
    static int[][] board;
    static boolean target = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for(int i =0;i<9;i++){
            String str = br.readLine();
            for(int j=0;j<9;j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        dfs(0);
        String[] ans = new String[9];
        for(int i =0;i<9;i++)
            ans[i] = "";
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                ans[i] += Integer.toString(board[i][j]);
            }
            System.out.println(ans[i]);
        }
    }

    public static void dfs(int address){
        if(address==81){
            target = true;
            return;
        }
        int a = address/9;
        int b = address%9;

        if(board[a][b] ==0){
            boolean[] check = new boolean[10];
            for(int j=0;j<9;j++){
                check[board[a][j]] =true;
                check[board[j][b]] = true;
            }
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    check[board[(a/3)*3+j][(b/3)*3+k]] =true;
                }
            }
            for(int i=1;i<10;i++){
                if(target)
                    break;
                board[a][b] = 0;
                if(!check[i]){
                    System.out.println(address);
                    board[a][b] = i;
                    dfs(address+1);
                }
            }
            if(!target) {
                board[a][b] = 0;
            }
        }
        else{
            dfs(address+1);
        }
    }
}
