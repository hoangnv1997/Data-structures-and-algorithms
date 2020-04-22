package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BUGLIFE {

	private static Scanner sc;

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

		public void push(int item) {
			top++;
			stack[top] = item;
		}

		public int peek() {
			return stack[top];
		}

		public void pop() {
			stack[top] = 0;
			top--;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai BUGLIFE"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int nBug = sc.nextInt();
		int nInteration = sc.nextInt();
		for (int nTC = 1; nTC <= tc; nTC++) {

			int[][] input = new int[2005][2005];
			int[] chuaxet = new int[2005];
			int[] mark = new int[2005];
			int indexMark = 1;

			for (int i = 1; i <= nInteration; i++) {
				int x = sc.nextInt();
				mark[indexMark] = x;
				indexMark++;
				int y = sc.nextInt();
				mark[indexMark] = y;
				indexMark++;
				input[x][y] = input[y][x] = 1;
			}
			for (int i = 1; i <= nBug; i++) {
				if (chuaxet[i] == 0) {
					Stack st = new Stack(2005);
					st.push(i);
					chuaxet[i] = 1;
					while (!st.isEmpty()) {
						int v = st.peek();
						st.pop();
						for (int j = 1; j <= nBug; j++) {
							if (chuaxet[j] == 0 && input[v][j] == 1) {
								st.push(v);
								st.push(j);
								if (chuaxet[v] == 1) {
									chuaxet[j] = 2;
								}
								if (chuaxet[v] == 2) {
									chuaxet[j] = 1;
								}
								break;
							}
						}
					}
				}
			}
			boolean check = true;
			System.out.println("Scenario #" + nTC + ":");
			for (int i = 1; i <= nInteration * 2 - 1; i = i + 2) {
				if (chuaxet[mark[i]] == chuaxet[mark[i + 1]]) {
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println("No suspicious bugs found!");
			} else {
				System.out.println("Suspicious bugs found!");
			}
		}

	}

}
