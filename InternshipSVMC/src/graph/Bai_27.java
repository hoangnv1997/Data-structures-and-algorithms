package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Floy

public class Bai_27 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 27"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] input = new int[7][7];
		int[][] mark = new int[7][7];

		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			input[x][y] = d;
			input[y][x] = d;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j && input[i][j] == 0) {
					input[i][j] = 100;
				}
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (input[i][k] + input[k][j] < input[i][j]) {
						input[i][j] = input[i][k] + input[k][j];
						mark[i][j] = k;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			int start = sc.nextInt();
			int finish = sc.nextInt();
			int[] before = new int[15];
			System.out.println(input[start][finish]);
			before[1] = start;
			before[2] = finish;
			boolean check = true;
			int count = 2;

			while (check) {
				int k = 0;
				for (int i = 1; i <= count - 1; i++) {
					if (before[i] != 0 && before[i + 1] != 0) {
						k = i;
						break;
					} else {
						check = false;
					}
				}
				if (k != 0) {
					for (int i = count + 1; i >= k + 2; i--) {
						before[i] = before[i - 1];
					}
					before[k + 1] = mark[before[k]][before[k + 1]];
					count++;
				}

			}
			for (int i = 1; i <= count; i++) {
				if (before[i] == 0) {
					System.out.print("->");
				} else {
					System.out.print(before[i]);
				}
			}
			System.out.println();
		}

	}
}
