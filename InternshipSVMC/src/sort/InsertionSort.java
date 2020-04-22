package sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {
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

		insertionSort(input, n);

		for (int i = 0; i < n; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void insertionSort(int[] input, int n) {
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int temp = input[i];
			while (j >= 0 && temp < input[j]) {
				input[j + 1] = input[j];
				j--;
			}
			input[j + 1] = temp;
		}
	}
}
