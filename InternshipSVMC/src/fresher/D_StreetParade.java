package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class D_StreetParade {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Street Parade"));
		sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int[] input = new int[1100];
			Stack<Integer> base = new Stack<Integer>();
			Stack<Integer> temp = new Stack<Integer>();
			boolean check = true;
			int index = 1;

			if (n == 0) {
				break;
			}
			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}
			for (int i = n - 1; i >= 0; i--) {
				base.push(input[i]);
			}
			while (!base.isEmpty()) {
				int indexTop = base.peek();
				if (index != indexTop) {
					if (!temp.isEmpty()) {
						while (!temp.isEmpty() && temp.peek() == index) {
							index++;
							temp.pop();
						}
						if (!temp.isEmpty() && indexTop > temp.peek()) {
							check = false;
							break;
						}
					}
					temp.push(indexTop);
				} else {
					index++;
				}
				base.pop();
			}

			if (check) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}
