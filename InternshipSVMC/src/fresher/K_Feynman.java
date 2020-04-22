package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class K_Feynman {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Feynman"));
		sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int sum = 0;
			sum = (n * (n + 1) * (2 * n + 1)) / 6;
//			for (int i = 1; i <= n; i++) {
//				sum += i * i;
//			}
			System.out.println(sum);
		}
	}

}
