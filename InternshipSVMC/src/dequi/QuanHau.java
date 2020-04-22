package dequi;

public class QuanHau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = 0;
			}
		}
		if (setQueen(board, 0, 8)) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.print("No solution");
		}
	}

	private static boolean isOK(int[][] board, int x, int y) {
		int h, c = 0;
		for (int i = 0; i < y; i++) {
			if (board[x][i] == 1) {
				return false;
			}
		}
		h = x;
		c = y;
		while (h >= 0 && c >= 0) {
			if (board[h][c] == 1) {
				return false;
			}
			h--;
			c--;
		}
		h = x;
		c = y;
		while (h < 8 && c >= 0) {
			if (board[h][c] == 1) {
				return false;
			}
			h++;
			c--;
		}
		return true;
	}

	private static boolean setQueen(int[][] board, int col, int n) {
		if (col >= n) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (isOK(board, i, col)) {
				board[i][col] = 1;
				if (setQueen(board, col + 1, n)) {
					return true;
				}
				board[i][col] = 0;
			}
		}
		return false;
	}
}
