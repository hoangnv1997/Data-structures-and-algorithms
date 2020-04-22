package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A_PrimeGenerator {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Prime Generator"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			for (int j = m; j <= n; j++) {
				if (check_prime(j)) {
					System.out.println(j);
				}
			}
			System.out.println();
		}

	}

	private static boolean check_prime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;

	}
}
