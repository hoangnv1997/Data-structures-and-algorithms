package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EZSUDOKU {

	private static Scanner sc;

	static boolean checkValues(int[][] input, int x, int y, int values) {
		for (int i = 0; i < 8; i++) {
			if (input[x][i] == values) {
				return false;
			}
			if (input[i][y] == values) {
				return false;
			}
		}
		int a = x / 4;
		int b = y / 4;
		int count = 0;
		for (int i = a * 4; i < a * 4 + 4; i++) {
			for (int j = b * 4; j < b * 4 + 4; j++) {
				if (input[i][j] == values) {
					count++;
				}
			}
		}
		if (count >= 2) {
			return false;
		}
		return true;
	}

	static boolean solution(int[][] input, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = false;
		boolean isTM = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = true;
					break;
				}
			}
			if (isEmpty) {
				break;
			}
		}

		int temp;
		if (isEmpty == false) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp = input[i][j];
					input[i][j] = 0;
					if (!checkValues(input, i, j, temp)) {
						isTM = true;
						break;
					} else {
						input[i][j] = temp;
					}
				}
				if (isTM == true) {
					break;
				}
			}
			if (isTM) {
				return false;
			} else {
				return true;
			}
		}
		for (int i = 1; i <= 8; i++) {
			if (checkValues(input, row, col, i)) {
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
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai EZSUDOKU"));
		sc = new Scanner(System.in);
		int nTc = sc.nextInt();
		for (int tc = 1; tc <= nTc; tc++) {
			int[][] input = new int[8][8];
			int n = 8;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					input[i][j] = sc.nextInt();
				}
			}
			solution(input, n);
			if (solution(input, n)) {
				System.out.println("Test case #" + tc + ": YES");
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						System.out.print(input[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Test case #" + tc + ": NO");
			}
		}

	}

}
