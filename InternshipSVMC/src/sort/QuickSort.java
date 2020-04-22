package sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\sort\\inputSort"));
		sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		quickSort(input, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(input[i] + " ");
		}

	}

	private static int partition(int[] input, int low, int hight) {
		int left = low;
		int right = hight - 1;
		int pivot = input[hight];
		int temp;
		while (true) {
			while (left <= right && input[left] < pivot)
				left++;
			while (right >= left && input[right] > pivot)
				right--;
			if (left >= right) {
				break;
			}
			temp = input[left];
			input[left] = input[right];
			input[right] = temp;

			left++;
			right--;
		}

		temp = input[left];
		input[left] = input[hight];
		input[hight] = temp;
		return left;
	}

	private static void quickSort(int[] input, int low, int hight) {

		if (low < hight) {
			int mark = partition(input, low, hight);

			quickSort(input, low, mark - 1);
			quickSort(input, mark + 1, hight);
		}
	}
}
