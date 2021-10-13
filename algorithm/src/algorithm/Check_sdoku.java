package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check_sdoku {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for(int i =0;i<9;i++){
            String str = br.readLine();
            for(int j=0;j<9;j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        boolean ans= true;
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                int a = i;
                int b= j;

                for(int k =0;k<9;k++){
                    if((a!=k&&board[a][b] == board[k][b])||(b!=k&&board[a][b]==board[a][k])){
                        System.out.println(a+" "+b);
                        ans = false;
                    }

                }
            }
        }
        System.out.println(ans);
    }
}
