package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SERGRID {
	static class Queue {
		private Point[] queue;
		private int front;
		private int rear;
		private int size;

		public Queue(int leng) {
			size = leng;
			front = 0;
			rear = -1;
			queue = new Point[size];
		}

		public boolean isEmpty() {
			if (front > rear || front < 0) {
				return true;
			} else {
				return false;
			}
		}

		public void push(Point item) {
			rear++;
			queue[rear] = item;
		}

		public Point peek() {
			return queue[front];
		}

		public void pop() {
//			queue[front].x = 0;
//			queue[front].y = 0;
			front++;
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

	static int[] xValues = { -1, 1, 0, 0 };
	static int[] yValues = { 0, 0, 1, -1 };
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai SERGRID"));
		sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[][] input = new int[505][505];
		int[][] mark = new int[505][505];
		for (int i = 0; i < n; i++) {
			String in = sc.nextLine();
			int x = 0;
			for (int j = 0; j < m; j++) {
				x = in.charAt(j) - '0';
				input[i][j] = x;
			}
		}

		Queue q = new Queue(505);
		Point p = null;
		q.push(new Point(0, 0));
		// mark[0][0]=1;
		while (!q.isEmpty()) {
			p = q.peek();
			q.pop();
			if (p.x == n - 1 && p.y == m - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int xTemp = p.x + xValues[i] * input[p.x][p.y];
				int yTemp = p.y + yValues[i] * input[p.x][p.y];
				if (xTemp >= 0 && xTemp < n && yTemp >= 0 && yTemp < m && mark[xTemp][yTemp] == 0) {
					q.push(new Point(xTemp, yTemp));
					mark[xTemp][yTemp] = mark[p.x][p.y] + 1;
				}
			}
		}
		if (mark[n - 1][m - 1] != 0) {
			System.out.print(mark[n - 1][m - 1]);
		} else {
			System.out.print(-1);
		}

	}

}
