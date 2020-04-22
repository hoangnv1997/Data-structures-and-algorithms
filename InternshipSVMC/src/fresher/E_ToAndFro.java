package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E_ToAndFro {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\To And Fro"));
		sc = new Scanner(System.in);

//Cach 2
		while (true) {
			int col = sc.nextInt();
			if (col == 0) {
				break;
			}

			sc.nextLine();
			String input = sc.nextLine();
			int row = 0, mark = 0;
			int leng = input.length();
			char[][] res = new char[leng / col][20];

			for (int i = 0; i < leng; i++) {
				if (mark == 0) {
					for (int j = 0; j < col; j++) {
						res[row][j] = input.charAt(i);
						i++;
					}
					row++;
					mark = 1;
				} else {
					for (int j = col - 1; j >= 0; j--) {
						res[row][j] = input.charAt(i);
						i++;
					}
					row++;
					mark = 0;
				}
				i--;
			}

			for (int i = 0; i < col; i++) {
				for (int j = 0; j < leng / col; j++) {
					System.out.print(res[j][i]);
				}
			}
			System.out.println();
		}

	}

}
