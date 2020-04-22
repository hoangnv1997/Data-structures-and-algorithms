package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class B_TransformTheExpression {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\Transform the Expression"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= tc; i++) {
			String input = sc.nextLine();
			Stack<Character> s = new Stack<Character>();
			String res = "";
			for (int j = 0; j < input.length(); j++) {
				char ch = input.charAt(j);
				if (ch - '0' >= 0 && ch - '0' <= 9 || isCharacters(ch)) {
					res += ch;
				} else if (ch == '(') {
					s.push(ch);
				} else if (ch == ')') {
					while (!s.isEmpty() && s.peek() != '(') {
						res += s.pop();
					}
					s.pop();
				} else {
					while (!s.isEmpty() && uuTien(ch) <= uuTien(s.peek())) {
						res += s.pop();
					}
					s.push(ch);
				}
			}
			while (!s.isEmpty()) {
				res += s.pop();
			}
			System.out.println(res);

		}
	}

	private static int uuTien(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		}
		if (ch == '*' || ch == '/') {
			return 2;
		}
		return -1;
	}

	private static boolean isCharacters(char ch) {
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
			return true;
		}
		return false;
	}
}
