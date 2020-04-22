package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai_19 {

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
			int lt = 0;
			for (int i = 1; i <= n; i++) {
				if (chuaxet[i] == 0) {
					lt++;
					Queue q = new Queue(1001);
					q.push(i);
					chuaxet[i] = 1;
					System.out.println(lt);
					while (!q.isEmpty()) {
						int v = q.peek();
						System.out.print(v + " ");
						q.pop();
						for (int j = 1; j <= n; j++) {
							if (chuaxet[j] == 0 && input[v][j] == 1) {
								q.push(j);
								chuaxet[j] = 1;
							}
						}
					}
					System.out.println();
				}

			}
//			int lt = 0;
//			for (int i = 1; i <= n; i++) {
//				if (chuaxet[i] == 0) {
//					lt++;
//					Queue q = new Queue(1001);
//					q.push(i);
//					chuaxet[i] = lt;
//					while (!q.isEmpty()) {
//						int v = q.peek();
//						q.pop();
//						for (int j = 1; j <= n; j++) {
//							if (chuaxet[j] == 0 && input[v][j] == 1) {
//								q.push(j);
//								chuaxet[j] = lt;
//							}
//						}
//					}
//				}
//
//			}
//			for (int i = 1; i <= lt; i++) {
//				for (int j = 1; j <= n; j++) {
//					if (chuaxet[j] == i) {
//						System.out.print(j + " ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.print(lt);

		}

	}

}
