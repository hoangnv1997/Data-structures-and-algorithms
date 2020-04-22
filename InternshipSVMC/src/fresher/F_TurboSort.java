package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class F_TurboSort {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Turbo Sort"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		bubbleSort(input, n);
		for (int i = 0; i < n; i++) {
			System.out.print(input[i] + " ");
		}

	}

	public static void bubbleSort(int[] input, int n) {
		for (int i = 0; i < n; i++) {
			boolean haveSwap = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (input[j + 1] < input[j]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					haveSwap = true;
				}
			}
			if (haveSwap == false) {
				break;
			}
		}
	}

}
