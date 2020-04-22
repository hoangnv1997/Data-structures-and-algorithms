package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class M_FindStringRoots {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Find String Roots"));
		sc = new Scanner(System.in);

		while (true) {
			String input = sc.nextLine();
			if (input.charAt(0) == '*') {
				break;
			}
			int leng_sub = 1;
			int N = 0;
			while (true) {
				if (input.length() % leng_sub != 0) {
					leng_sub++;
					continue;
				}

				int id = 0;
				boolean check = true;
				while (true) {
					if (id + leng_sub + 1 > input.length()) {
						break;
					}

					for (int i = 0; i < leng_sub; i++) {
						if (input.charAt(id + i) != input.charAt(id + i + leng_sub)) {
							check = false;
							break;
						}
						
					}
					if (check == false) {
						break;
					}
					id += leng_sub;

				}
				if (check == true) {
					N = input.length() / leng_sub;
					break;
				}
				leng_sub++;
			}
			System.out.println(N);

		}
	}

}
