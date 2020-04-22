package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P_Divisibility {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Divisibility"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = 2; j < n; j++) {
				if (j % x == 0 && j % y != 0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}

	}

}
