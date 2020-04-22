package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LABYR1 {
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
			// queue[front] = 0;
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

	static int[] xValues = { 1, -1, 0, 0 };
	static int[] yValues = { 0, 0, -1, 1 };
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai LABYR1"));
		sc = new Scanner(System.in);
		int nTc = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= nTc; tc++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			int[][] mark = new int[r + 1][c + 1];
			char[][] input = new char[r + 1][c + 1];
			sc.nextLine();
			String in = null;
			for (int i = 0; i < r; i++) {
				in = sc.nextLine();
				for (int j = 0; j < c; j++) {
					char ch = in.charAt(j);
					input[i][j] = ch;
				}
			}
			// Tim diem '.'
			int xStart = 0;
			int yStart = 0;
			boolean check = false;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (input[i][j] == '.') {
						xStart = i;
						yStart = j;
						check = true;
						break;
					}
				}
				if (check == true) {
					break;
				}
			}
			// BFS tu diem '.'

			Queue q = new Queue(1005);
			Point current = null;
			q.push(new Point(xStart, yStart));
			mark[xStart][yStart] = 1;
			while (!q.isEmpty()) {
				current = q.peek();
				q.pop();
				for (int i = 0; i < 4; i++) {
					int xTemp = current.x + xValues[i];
					int yTemp = current.y + yValues[i];
					if (xTemp >= 0 && xTemp < r && yTemp >= 0 && yTemp < c && mark[xTemp][yTemp] == 0
							&& input[xTemp][yTemp] == '.') {
						q.push(new Point(xTemp, yTemp));
						mark[xTemp][yTemp] = mark[current.x][current.y] + 1;
					}
				}
			}

			// Tim diem xa nhat tu diem BFS ban dau
			int m = 0;
			int xStart2 = 0;
			int yStart2 = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (m < mark[i][j]) {
						m = mark[i][j];
					}
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (mark[i][j] == m) {
						xStart2 = i;
						yStart2 = j;
					}
				}
			}
			// BFS lan 2
			Queue q2 = new Queue(1005);
			Point current2 = null;
			q2.push(new Point(xStart2, yStart2));
			mark[xStart2][yStart2] = 1;
			while (!q2.isEmpty()) {
				current2 = q2.peek();
				q2.pop();
				for (int i = 0; i < 4; i++) {
					int xTemp = current2.x + xValues[i];
					int yTemp = current2.y + yValues[i];
					if (xTemp >= 0 && xTemp < r && yTemp >= 0 && yTemp < c && mark[xTemp][yTemp] == 0
							&& input[xTemp][yTemp] == '.') {
						q2.push(new Point(xTemp, yTemp));
						mark[xTemp][yTemp] = mark[current2.x][current2.y] + 1;
					}
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(mark[i][j] + " ");
				}
				System.out.println();
			}
			// Tim res
			int res = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < r; j++) {
					if (res < mark[i][j]) {
						res = mark[i][j];
					}
				}
			}
			System.out.println("Maximum rope length is " + (res - 1) + ".");

		}

	}

}
