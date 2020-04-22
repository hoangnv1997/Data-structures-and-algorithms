package sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectionSort {

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

		selectionSort(input, n);

		for (int i = 0; i < n; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void selectionSort(int[] input, int n) {

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = input[minIndex];
				input[minIndex] = input[i];
				input[i] = temp;
			}
		}

	}
}
