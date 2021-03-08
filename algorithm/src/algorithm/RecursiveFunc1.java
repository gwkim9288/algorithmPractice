package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFunc1 {
	//10872 팩토리얼 0308
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int answer = 1;
		for(int i =0; i<input;i++) {
			answer = answer*(i+1);
		}
		System.out.println(answer);
	}
}
