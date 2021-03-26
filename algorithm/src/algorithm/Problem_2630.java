package algorithm;

import java.util.Scanner;

public class Problem_2630 {

	static int[][] list;
	static int white = 0, blue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		list = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				list[i][j] = sc.nextInt();
		coleredPaper(n, 0, 0);
		System.out.print(white + "\n" + blue);
	}

	static void coleredPaper(int n, int x, int y) {
		if (isSame(n, x, y)) {
			if (list[y][x] == 0)
				white++;
			else
				blue++;
			return;
		}
		coleredPaper(n / 2, x, y);
		coleredPaper(n / 2, x + n / 2, y);
		coleredPaper(n / 2, x, y + n / 2);
		coleredPaper(n / 2, x + n / 2, y + n / 2);
	}

	static boolean isSame(int n, int x, int y) {
		int criteria = list[y][x];
		for (int i = y; i < y + n; i++)
			for (int j = x; j < x + n; j++)
				if (criteria != list[i][j])
					return false;
		return true;
	}

}
