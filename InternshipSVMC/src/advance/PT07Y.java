package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// kiểm tra xem đồ thị có là cây ko
public class PT07Y {
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
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai PT07Y"));
		sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] input = new int[10005][10005];
		int[] chuaxet = new int[10005];

		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			input[x][y] = 1;
			input[y][x] = 1;
		}
		int lt = 0;
		for (int i = 1; i <= n; i++) {
			if (chuaxet[i] == 0) {
				lt++;
				Stack st = new Stack(10005);
				st.push(i);
				chuaxet[i] = 1;
				while (!st.isEmpty()) {
					int v = st.peek();
					st.pop();
					for (int j = 1; j <= n; j++) {
						if (chuaxet[j] == 0 && input[v][j] == 1) {
							st.push(v);
							st.push(j);
							chuaxet[j] = 1;
							break;
						}
					}
				}
			}
		}
		if (n == m + 1 && lt == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
