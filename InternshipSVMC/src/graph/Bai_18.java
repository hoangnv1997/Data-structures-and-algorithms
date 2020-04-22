package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_18 {
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
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 17"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int u = sc.nextInt();
			boolean[] check = new boolean[1000];
			int[][] input = new int[1000][1000];

			for (int i = 1; i <= n; i++) {
				check[i] = true;
			}

			for (int i = 1; i <= m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				input[x][y] = 1;
				input[y][x] = 1;
			}

			Stack st = new Stack(1000);
			st.push(u);
			check[u] = false;
			System.out.print(u + " ");
			while (!st.isEmpty()) {
				int v = st.peek();
				st.pop();
				for (int i = 1; i <= n; i++) {
					if (check[i] && input[v][i] == 1) {
						System.out.print(i + " ");
						st.push(v);
						st.push(i);
						check[i] = false;
						break;

					}
				}
			}
			System.out.println();
		}
	}

}
