package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T_PowerOfArray {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Power Of Array"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int[] input = new int[n];

			for (int j = 0; j < n; j++) {
				input[j] = sc.nextInt();
			}
			int power = 0;
			for (int j = 0; j < n; j++) {
				power += input[j] + 1;
			}
			System.out.println(power);
		}

	}

}
