package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai3 {

	static int[] H = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\inputbai3"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int[] input = new int[n];

			for (int j = 0; j < n; j++) {
				input[j] = sc.nextInt();
			}

			int sumInput = 0;
			for (int j = 0; j < n; j++) {
				sumInput += input[j];
			}

			int sum = s - sumInput;
			int x = 0, y = 0;
			int dem = 0;

			for (int j = 0; j < 9; j++) {
				x = H[j];
				y = sum - x;
				if (0 < x && x <= 9 && 0 < y && y <= 9 && check(x, input) && check(y, input) && x != y) {
					dem++;
				}
			}

			System.out.println(dem);
//			for(int j=0; j<n; j++) {
//				System.out.print(input[j]+" ");
//			}
//			System.out.println();
		}

	}

	private static boolean check(int x, int[] input) {

		for (int i = 0; i < input.length; i++) {
			if (x == input[i]) {
				return false;
			}
		}

		return true;
	}

}
