package array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\array\\input"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		int[] output = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		// 1 .Tinh trung binh cong cac so le o vi tri chan
		// Chu y: Vi tri chan = chi so le
		System.out.println("Trung binh cong cac so le o vi tri chan: ");
		int sum = 0;
		int count = 0;
		for (int i = 1; i < n; i = i + 2) {
			if (input[i] % 2 == 1) {
				count++;
				sum += input[i];
			}
		}
		System.out.print((float) sum / count);
		System.out.println();

		// 2. Tim so lon nhat trong mang vua nhap
		System.out.println("So lon nhat trong mang: ");
		int maxX = input[0];
		for (int i = 0; i < n; i++) {
			if (maxX < input[i]) {
				maxX = input[i];
			}
		}
		System.out.print(maxX);
		System.out.println();

		// 3. Tim vi tri cac so nho nhat trong mang
		int minX = input[0];
		int vitri = 0;
		for (int i = 0; i < n; i++) {
			if (input[i] < minX) {
				minX = input[i];
				vitri = i + 1;
			}
		}
		System.out.print("So nho nhat: " + minX + " vi tri so: " + vitri);
		System.out.println();

		// 4. Dem cac so chinh phuong co trong mang
		int demSCP = 0;
		for (int i = 0; i < n; i++) {
			if (KTSoChinhPhuong(input[i])) {
				demSCP++;
			}
		}
		System.out.print("Mang da cho co " + demSCP + " so chinh phuong");
		System.out.println();

		// 5. Hien thi cac so nguyen to co trong mang
		System.out.println("Cac so nguyen to co trong mang la: ");
		for (int i = 0; i < n; i++) {
			if (KTSoNguyenTo(input[i])) {
				System.out.print(input[i] + " ");
			}
		}
		System.out.println();

		System.out.println("Sap xep mang: ");
		SapXepMang(input, n);
		for (int i = 0; i < n; i++) {
			System.out.print(input[i] + " ");
		}
	}

	private static boolean KTSoChinhPhuong(int k) {
		for (int i = 0; i * i <= k; i++) {
			if (i * i == k) {
				return true;
			}
		}
		return false;
	}

	private static boolean KTSoNguyenTo(int k) {
		if (k == 1 || k == 0) {
			return false;
		}
		for (int i = 2; i < k; i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] SapXepMang(int[] input, int n) {
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (input[j] < input[i]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}
}
