package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class U_HydroelectricDams {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Hydroelectric Dams"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int[] input = new int[n];
			for (int j = 0; j < n; j++) {
				input[j] = sc.nextInt();
			}

			int left_index = 0, right_index = 0, res = 0, max_left = 0, max_right = 0;
			for (int j = 0; j < n; j++) {
				if (j > left_index && j < right_index) {
					res += get_Min(max_left, max_right) - input[j];
					continue;
				}
				max_left = get_Max_Left(j, input);
				max_right = get_Max_Right(j, input);

				if (max_left == input[j] || max_right == input[j]) {
					left_index = 0;
					right_index = 0;
					continue;
				}
				res += get_Min(max_left, max_right) - input[j];
			}
			System.out.println(res);
		}
	}

	private static int get_Min(int a, int b) {
		if (a < b) {
			return a;
		} else if (a == b) {
			return a;
		} else {
			return b;
		}
	}

	private static int get_Max_Left(int index, int[] input) {
		int left_index = 0;
		int temp = input[index];
		for (int i = 0; i < index; i++) {
			if (input[i] > temp) {
				temp = input[i];
				left_index = i;
			}
		}
		return temp;
	}

	private static int get_Max_Right(int index, int[] input) {
		int right_index = 0;
		int temp = input[index];
		for (int i = index + 1; i < input.length; i++) {
			if (input[i] > temp) {
				temp = input[i];
				right_index = i;
			}
		}
		return temp;
	}

}
