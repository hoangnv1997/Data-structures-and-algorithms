package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_22 {

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
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 21"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int start = sc.nextInt();
			int finish = sc.nextInt();
			int[] chuaxet = new int[1001];
			int[][] input = new int[1001][1001];
			int[] before = new int[1001];

			for (int i = 1; i <= n; i++) {
				chuaxet[i] = 0;
				before[i] = 0;
			}
			for (int i = 1; i <= m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				input[x][y] = 1;
				input[y][x] = 1;
			}

			Stack st = new Stack(1001);
			st.push(start);
			chuaxet[start] = 1;
			while (!st.isEmpty()) {
				int v = st.peek();
				st.pop();
				for (int i = 1; i <= n; i++) {
					if (chuaxet[i] == 0 && input[v][i] == 1) {
						chuaxet[i] = 1;
						st.push(v);
						st.push(i);
						before[i] = v;
						break;

					}
				}
			}
			if (before[finish] == 0) {
				System.out.println(-1);
			} else {
				int i = finish;
				int res = 1;
				System.out.print(i + " ");
				while (before[i] != start) {
					System.out.print(before[i] + " ");
					i = before[i];
					res++;
					
				}
				System.out.println(start);
				System.out.println(res);
			}
		}

	}

}
