package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_17 {
	static class Queue {
		private int[] queue;
		private int front;
		private int rear;
		private int size;

		public Queue(int leng) {
			size = leng;
			front = 0;
			rear = -1;
			queue = new int[size];
		}

		public boolean isEmpty() {
			if (front < 0 || front > rear) {
				return true;
			} else {
				return false;
			}
		}

		public int peek() {
			return queue[front];
		}

		public void push(int item) {
			rear++;
			queue[rear] = item;
		}

		public void pop() {
			queue[front] = 0;
			front++;
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 17"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int u = sc.nextInt();
			int finish = 5;
			boolean[] check = new boolean[1001];
			int[][] input = new int[1001][1001];

			for (int j = 1; j <= n; j++) {
				check[j] = true;
			}

			for (int j = 1; j <= m; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				input[x][y] = 1;
				input[y][x] = 1;
			}
			Queue q = new Queue(1001);
			q.push(u);
			check[u] = false;
			while (!q.isEmpty()) {
				int v = q.peek();
				System.out.print(v + " ");
//				if (v == finish) {
//					break;
//				}
				q.pop();
				for (int j = 1; j <= n; j++) {
					if (check[j] && input[v][j] == 1) {
						q.push(j);
						check[j] = false;
					}
				}
			}
			System.out.println();

		}
	}

}
