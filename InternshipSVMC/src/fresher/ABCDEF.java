package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ABCDEF {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\inputbaiABCDEF"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int num_country = sc.nextInt();
			int[] army = new int[num_country];
			int[] left = new int[num_country];
			int[] right = new int[num_country];

			for (int j = 0; j < num_country; j++) {
				army[j] = sc.nextInt();

			}

			for (int j = 0; j < num_country; j++) {
				int t = 0, sum = 0;
				t = army[j];
				for (int k = j; k < num_country - 1; k++) {
					if (t / 2 > army[k + 1]) {
						t = t + army[k + 1];
						sum += army[k + 1];
					} else if (t / 2 < army[k + 1] && t > army[k + 1]) {
						t = t - army[k + 1];
						sum += army[k + 1];
					} else {
						sum += t;
						break;
					}
				}
				left[j] = sum;
			}

			for (int j = num_country - 1; j >= 0; j--) {
				int t = 0, sum = 0;
				t = army[j];
				for (int k = j; k >= 1; k--) {
					if (t / 2 > army[k - 1]) {
						t = t + army[k - 1];
						sum += army[k - 1];
					} else if (t / 2 < army[k - 1] && t > army[k - 1]) {
						t = t - army[k - 1];
						sum += army[k - 1];
					} else {
						sum += t;
						break;
					}
				}
				right[j] = sum;
			}

			System.out.print("#" + i + " ");
			for (int j = 0; j < num_country; j++) {
				if (left[j] < right[j]) {
					System.out.print(right[j] + " ");
				} else {
					System.out.print(left[j] + " ");
				}
			}
			System.out.println();
		}

	}

}
