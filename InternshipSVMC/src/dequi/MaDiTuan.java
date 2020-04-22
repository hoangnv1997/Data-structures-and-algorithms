package dequi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaDiTuan {

	static int[] X = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] Y = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int dem = 0, count = 0;
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\dequi\\Ma Di Tuan"));
		sc = new Scanner(System.in);

		int[][] board = new int[4][5];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		find(board, 0, 2);
		System.out.print("Khong tim thay duong di");
	}

	private static void find(int[][] board, int x, int y) {
		dem++;
		board[x][y] = dem;
		for (int k = 0; k < 8; k++) {
			if (dem == 20) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 5; j++) {
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
				}
				System.exit(0);
			}
			int u = x + X[k];
			int v = y + Y[k];

			if (u >= 0 && u < 4 && v >= 0 && v < 5 && board[u][v] == 0) {
				find(board, u, v);
			}
		}
		dem--;
		board[x][y] = 0;

	}

}
