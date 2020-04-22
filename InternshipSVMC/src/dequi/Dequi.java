package dequi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dequi {

	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\dequi\\ThapHN"));
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		ThapHN(n, 'A', 'C', 'B');

	}

	public static void Chuyen(int n, char a, char c) {
		System.out.println("Chuyen dia thu " + n + " tu cot " + a + " sang cot " + c);
	}

	public static void ThapHN(int n, char a, char c, char b) {
		if (n == 1) {
			Chuyen(1, a, c);
		} else {
			ThapHN(n - 1, a, b, c);
			Chuyen(n, a, c);
			ThapHN(n - 1, b, c, a);
		}

	}
}
