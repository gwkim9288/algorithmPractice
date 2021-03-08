package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class String1 {
	//1157 	단어 공부	0308
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.toUpperCase();
		char[] input = str.toCharArray();
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		for(char i : input) {
			if(charMap.containsKey(i)) {
				charMap.put(i, charMap.get(i)+1);
			}else {
				charMap.put(i,1);
			}
		}
		char maxChar = 'a';
		int maxCharNum = 0;
		boolean check = false;
		for(char i : charMap.keySet()) {
			if(charMap.get(i)>maxCharNum) {
				check = false;
				maxChar = i;
				maxCharNum = charMap.get(i);
			}else if(charMap.get(i)==maxCharNum) {
				check = true;
			}
		}
		if(check) {
			System.out.println("?");
		}else {
			System.out.printf("%c", maxChar);
		}
		scan.close();
	}

}
