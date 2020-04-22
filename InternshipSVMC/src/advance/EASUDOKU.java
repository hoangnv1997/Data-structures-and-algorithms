package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EASUDOKU {

	static boolean checkValue(int[][] input, int x, int y, int value) {
		for (int i = 0; i < 9; i++) {
			// kiem tra hang x co gia tri value chua
			if (input[x][i] == value) {
				return false;
			}
			// kiem tra cot y co gia tri value chua
			if (input[i][y] == value) {
				return false;
			}

		}
		// kiem tra khoi 3x3 co gia tri value chua
		int a = x / 3;
		int b = y / 3;
		for (int i = 3 * a; i < 3 * a + 3; i++) {
			for (int j = 3 * b; j < 3 * b + 3; j++) {
				if (input[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	private static Scanner sc;

	static boolean solution(int[][] input, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (isEmpty == false) {
				break;
			}
		}
		if (isEmpty) {
			return true;
		}
		for (int i = 1; i <= 9; i++) {
			if (checkValue(input, row, col, i)) {
				input[row][col] = i;
				if (solution(input, n)) {
					return true;
				} else {
					input[row][col] = 0;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai EASUDOKU"));
		sc = new Scanner(System.in);

		int nTc = sc.nextInt();
		for (int tc = 1; tc <= nTc; tc++) {
			int[][] input = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					input[i][j] = sc.nextInt();
				}
			}

			if (solution(input, 9)) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(input[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("No solution");
			}
		}
	}

}
