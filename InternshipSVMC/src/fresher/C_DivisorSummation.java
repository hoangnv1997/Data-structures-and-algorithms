package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C_DivisorSummation {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\DivisorSummation"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
//			int sum = 0;
//			for (int j = 1; j < n; j++) {
//				if (n % j == 0) {
//					sum += j;
//				}
//			}
//			System.out.println(sum);

			int sum = 1;
			for (int j = 2; j * j < n; j++) {
				if (n % j == 0) {
					int a = n / j;
					if (j != a) {
						sum += a + j;
					} else
						sum += j;
				}
			}
			System.out.println(sum);
		}
	}

}
