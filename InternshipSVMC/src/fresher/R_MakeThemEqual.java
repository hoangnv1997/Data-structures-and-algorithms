package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class R_MakeThemEqual {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Make Them Equal!"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				sum += temp;
			}
			if (sum % n == 0) {
				System.out.println(n);
			} else {
				System.out.println(n - 1);
			}
		}

	}

}
