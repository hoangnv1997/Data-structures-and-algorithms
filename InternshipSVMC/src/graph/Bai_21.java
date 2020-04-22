package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_21 {

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

		public void push(int item) {
			rear++;
			queue[rear] = item;
		}

		public int peek() {
			return queue[front];
		}

		public void pop() {
			queue[front] = 0;
			front++;
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

			Queue q = new Queue(1001);
			q.push(start);
			chuaxet[start] = 1;
			while (!q.isEmpty()) {
				int v = q.peek();
				q.pop();
				for (int i = 1; i <= n; i++) {
					if (chuaxet[i] == 0 && input[v][i] == 1) {
						q.push(i);
						chuaxet[i] = 1;
						before[i] = v;
					}
				}
			}
			if (before[finish] == 0) {
				System.out.println(-1);
			} else {
				int res = 1;
				int i = finish;
				System.out.print(i + " ");
				while (before[i] != start) {
					System.out.print(before[i] + " ");
					i = before[i];
					res++;
				}
				System.out.println(start);

//				System.out.println(res);
			}
		}

	}

}
