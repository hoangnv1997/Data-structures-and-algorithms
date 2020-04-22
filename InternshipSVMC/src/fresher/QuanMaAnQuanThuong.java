package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuanMaAnQuanThuong {

	static int[] X = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] Y = { -1, 1, -2, 2, -2, 2, -1, 1 };
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\inputbai1"));

		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int dem = 0;
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] board = new int[m][n];

			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					board[j][k] = sc.nextInt();
				}
			}
			
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (board[j][k] == 2) {
						for (int h = 0; h <= 7; h++) {
							int u = j + X[h];
							int v = k + Y[h];
							if (u < m && u >= 0 && v >= 0 && v < n) {
								if (board[u][v] == 1) {
									dem++;
									board[u][v] = 0;
								}
							}
						}
					}
				}
			}
			System.out.println("#" + i + " " + dem);
//			for (int j = 0; j < m; j++) {
//				for (int k = 0; k < n; k++) {
//					System.out.print(board[j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

	}

}
