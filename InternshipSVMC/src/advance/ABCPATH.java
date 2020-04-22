package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ABCPATH {
	static class Stack {
		private Point[] stack;
		private int top;
		private int size;

		public Stack(int leng) {
			size = leng;
			top = -1;
			stack = new Point[size];
		}

		public boolean isEmpty() {
			if (top == -1) {
				return true;
			} else {
				return false;
			}
		}

		public void push(Point item) {
			top++;
			stack[top] = item;
		}

		public Point peek() {
			return stack[top];
		}

		public void pop() {
			// stack[top] = 0;
			top--;
		}

	}

	static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] xValues = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] yValues = { 0, 0, -1, 1, -1, -1, 1, 1 };
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai ABCPATH"));
		sc = new Scanner(System.in);
		while (true) {
			int tc = 1;
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r == 0 && c == 0) {
				break;
			}
			sc.nextLine();
			char[][] input = new char[r][c];
			int[][] mark = new int[r][c];
			Stack st = new Stack(30);
			for (int i = 0; i < r; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < c; j++) {
					input[i][j] = s.charAt(j);
					if (input[i][j] == 'A') {
						st.push(new Point(i, j));
						mark[i][j] = 1;
					}
				}
			}

			Point current = null;
			while (!st.isEmpty()) {
				current = st.peek();
				st.pop();
				for (int i = 0; i < 8; i++) {
					int xTemp = current.x + xValues[i];
					int yTemp = current.y + yValues[i];
					if (xTemp >= 0 && xTemp < r && yTemp >= 0 && yTemp < c
							&& (input[xTemp][yTemp] - 'A') == (input[current.x][current.y] - 'A' + 1)
							&& mark[xTemp][yTemp] == 0) {
						st.push(new Point(current.x, current.y));
						st.push(new Point(xTemp, yTemp));
						mark[xTemp][yTemp] = mark[current.x][current.y] + 1;
						break;
					}
				}

			}

			int res = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (res < mark[i][j]) {
						res = mark[i][j];
					}
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(mark[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("Case " + tc + ": " + res);
			tc++;
		}

	}

}
