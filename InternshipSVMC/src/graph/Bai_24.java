package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_24 {

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
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 23"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int u = sc.nextInt();
			int[] chuaxet = new int[1001];
			int[][] input = new int[1001][1001];

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
			st.push(u);
			chuaxet[u] = 1;
			int[][] res = new int[n][2];
			int k = 1;
			while (!st.isEmpty()) {
				int v = st.peek();
				st.pop();
				for (int i = 1; i <= n; i++) {
					if (chuaxet[i] == 0 && input[v][i] == 1) {
						st.push(v);
						st.push(i);
						chuaxet[i] = 1;
						res[k][0] = v;
						res[k][1] = i;
						k++;
						break;
					}
				}
			}
			boolean ok = true;
			for (int i = 1; i <= n; i++) {
				if (chuaxet[i] == 0) {
					ok = false;
					break;
				}
			}
			if (ok) {
				for (int i = 1; i <= n - 1; i++) {
					System.out.println(res[i][0] + " " + res[i][1]);
				}
			} else {
				System.out.println(-1);
			}
		}

	}

}
