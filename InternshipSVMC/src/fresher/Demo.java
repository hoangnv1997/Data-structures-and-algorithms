package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {

	private static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\demo"));
		sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] input = new int[n][m];
		
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				input[j][k] = sc.nextInt();
			}
		}
		System.out.print(tinh(input));
	}
	private static int tinh(int[][] input) {
		int sum = 0;

		for (int i = 2; i <= 4; i++) {
			if (input[i][0] == input[i][1] && input[i][0] == input[i][2] && input[i][0] == 7) {
				sum += 100;
			} else if (input[i][0] == input[i][1] && input[i][0] == input[i][2] && input[i][0] != 7) {
				sum += input[i][0] * 10;
			} else if (input[i][0] != input[i][1]||input[i][0]!=input[i][2]||input[i][1]!=input[i][2]) {
				sum += input[i][0] + input[i][1] + input[i][2];
			}
		}

		return sum;

	}
}
