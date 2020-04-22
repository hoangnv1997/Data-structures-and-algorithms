package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_20 {

	static class Stack {
		private int[] stack;
		private int top;
		private int size;

		public Stack(int leng) {
			size = leng;
			top = -1;
			stack = new int[size];
		}

		public boolean isEmpty() {
			if (top == -1) {
				return true;
			} else {
				return false;
			}
		}

		public int peek() {
			return stack[top];
		}

		public void push(int item) {
			top++;
			stack[top] = item;
		}

		public void pop() {
			stack[top] = 0;
			top--;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 19"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int[] chuaxet = new int[1001];
			int[][] input = new int[1001][1001];
			int n = sc.nextInt();
			int m = sc.nextInt();

			for (int i = 1; i <= n; i++) {
				chuaxet[i] = 0;
			}
			for (int i = 1; i <= m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				input[x][y] = 1;
				input[y][x] = 1;
			}
			Stack st = new Stack(1001);
			for (int i = 1; i <= n; i++) {
				if (chuaxet[i] == 0) {
					st.push(i);
					System.out.print(i + " ");
					chuaxet[i] = 1;
					while (!st.isEmpty()) {
						int v = st.peek();
						st.pop();
						for (int j = 1; j <= n; j++) {
							if (chuaxet[j] == 0 && input[v][j] == 1) {
								System.out.print(j + " ");
								st.push(v);
								st.push(j);
								chuaxet[j] = 1;
								break;
							}
						}
					}
					System.out.println();
				}
			}
		}

	}

}
