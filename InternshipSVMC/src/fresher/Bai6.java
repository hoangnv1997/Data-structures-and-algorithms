package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai6 {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\inputbai6"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int[] res = new int[12];
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] input = new int[n][m];
			int[][] temp = new int[n][m];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					input[j][k] = sc.nextInt();
				}
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					temp[j][k] = input[j][k];
				}
			}

			int down11 = 0;
			input[4][0] = temp[3][0];
			input[3][0] = temp[2][0];
			input[2][0] = temp[1][0];
			down11 = tinh(input);
			res[0] = down11;

			int down12 = 0;
			input[4][0] = temp[2][0];
			input[3][0] = temp[1][0];
			input[2][0] = temp[0][0];
			down12 = tinh(input);
			res[1] = down12;

			int up11 = 0;
			input[2][0] = temp[3][0];
			input[3][0] = temp[4][0];
			input[4][0] = temp[5][0];
			up11 = tinh(input);
			res[2] = up11;

			int up12 = 0;
			input[2][0] = temp[4][0];
			input[3][0] = temp[5][0];
			input[4][0] = temp[6][0];
			up12 = tinh(input);
			res[3] = up12;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					input[j][k] = temp[j][k];
				}
			}

			int down21 = 0;
			input[4][1] = temp[3][1];
			input[3][1] = temp[2][1];
			input[2][1] = temp[1][1];
			down21 = tinh(input);
			res[4] = down21;

			int down22 = 0;
			input[4][1] = temp[2][1];
			input[3][1] = temp[1][1];
			input[2][1] = temp[0][1];
			down22 = tinh(input);
			res[5] = down22;

			int up21 = 0;
			input[2][1] = temp[3][1];
			input[3][1] = temp[4][1];
			input[4][1] = temp[5][1];
			up21 = tinh(input);
			res[6] = up21;

			int up22 = 0;
			input[2][1] = temp[4][1];
			input[3][1] = temp[5][1];
			input[4][1] = temp[6][1];
			up22 = tinh(input);
			res[7] = up22;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					input[j][k] = temp[j][k];
				}
			}
			int down31 = 0;
			input[4][2] = temp[3][2];
			input[3][2] = temp[2][2];
			input[2][2] = temp[1][2];
			down31 = tinh(input);
			res[8] = down31;

			int down32 = 0;
			input[4][2] = temp[2][2];
			input[3][2] = temp[1][2];
			input[2][2] = temp[0][2];
			down32 = tinh(input);
			res[9] = down32;

			int up31 = 0;
			input[2][2] = temp[3][2];
			input[3][2] = temp[4][2];
			input[4][2] = temp[5][2];
			up31 = tinh(input);
			res[10] = up31;

			int up32 = 0;
			input[2][2] = temp[4][2];
			input[3][2] = temp[5][2];
			input[4][2] = temp[6][2];
			up32 = tinh(input);
			res[11] = up32;

			int max = res[0];
			for (int j = 1; j < 12; j++) {
				if (max < res[j]) {
					max = res[j];
				}
			}
			System.out.println(max);
//			for (int j = 0; j < n; j++) {
//				for (int k = 0; k < m; k++) {
//					System.out.print(temp[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}

	private static int tinh(int[][] input) {
		int sum = 0;

		for (int i = 2; i <= 4; i++) {
			if (input[i][0] == input[i][1] && input[i][0] == input[i][2] && input[i][0] == 7) {
				sum += 100;
			} else if (input[i][0] == input[i][1] && input[i][0] == input[i][2] && input[i][0] != 7) {
				sum += input[i][0] * 10;
			} else if (input[i][0] != input[i][1] || input[i][0] != input[i][2] || input[i][1] != input[i][2]) {
				sum += input[i][0] + input[i][1] + input[i][2];
			}
		}

		return sum;

	}
}
