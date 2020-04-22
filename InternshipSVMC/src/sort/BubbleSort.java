package sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BubbleSort {
	private static Scanner sc;
	private static int[] input;
	private static int n;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\sort\\inputSort"));
		sc = new Scanner(System.in);
		n = sc.nextInt();
		input = new int[n];
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
			for (int j = n - 1; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					int temp = input[j-1];
					input[j - 1] = input[j];
					input[j] = temp;
					haveSwap = true;
				}
			}
			if (haveSwap == false) {
				break;
			}
		}

	}
}
