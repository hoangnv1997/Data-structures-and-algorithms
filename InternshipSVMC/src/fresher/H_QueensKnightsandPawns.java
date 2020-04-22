package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class H_QueensKnightsandPawns {

	static int[] Xk = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] Yk = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static int[] Xq = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] Yq = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(
				new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Queens, Knights and Pawns"));
		sc = new Scanner(System.in);
		int tc = 1;
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0) {
				break;
			}
			int[][] board = new int[n][m];
			int nQ = sc.nextInt();
			for (int i = 1; i <= nQ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x - 1][y - 1] = 1;
			}
			int nK = sc.nextInt();
			for (int i = 0; i < nK; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x - 1][y - 1] = 2;
			}
			int nP = sc.nextInt();
			for (int i = 0; i < nP; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x - 1][y - 1] = 3;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == 2) {
						for (int k = 0; k < 8; k++) {
							int x = i + Xk[k];
							int y = j + Yk[k];
							if (x >= 0 && x < n && y >= 0 && y <= m && board[x][y] != 1 && board[x][y] != 3) {
								board[x][y] = 4;
							}
						}
					}
					if (board[i][j] == 1) {
						for (int k = 0; k < 8; k++) {
							int x = i + Xq[k];
							int y = j + Yq[k];
							while (x >= 0 && x < n && y >= 0 && y < m) {
								if (board[x][y] != 1 && board[x][y] != 2 && board[x][y] != 3) {
									if (board[x][y] == 0) {
										board[x][y] = 4;
									} else {
										x += Xq[k];
										y += Yq[k];
									}
								} else {
									break;
								}
							}
						}
					}
				}
			}
			int dem = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == 0) {
						dem++;
					}
				}
			}
			System.out.println("Board " + tc++ + " has " + dem + " safe squares.");

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}

}
