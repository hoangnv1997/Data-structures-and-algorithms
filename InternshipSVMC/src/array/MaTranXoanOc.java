package array;

import java.util.Scanner;

public class MaTranXoanOc {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int d = 0, h = n - 1, c = n - 1, temp = n*n;
		while (d <= n / 2) {
			for (int i = d; i <= c; i++) {
				arr[d][i] = temp;
				temp--;
			}
			for (int i = d + 1; i <= h; i++) {
				arr[i][c] = temp;
				temp--;
			}
			for (int i = c - 1; i >= d; i--) {
				arr[h][i] = temp;
				temp--;
			}
			for (int i = h - 1; i > d; i--) {
				arr[i][d] = temp;
				temp--;
			}
			d++;
			h--;
			c--;

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
