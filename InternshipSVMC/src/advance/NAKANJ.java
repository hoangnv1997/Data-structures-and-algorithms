package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NAKANJ {

	static int[] xValues = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] yValues = { -1, 1, -2, 2, -2, 2, -1, 1 };
	private static Scanner sc;

	static class Point {
		private int x;
		private int y;
		private int step;

		public Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	static class Queue {
		private Point queue[];
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

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai NAKANJ"));
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int[][] board = new int[8][8];
			String start = sc.next();
			String end = sc.next();

			int startX = start.charAt(0) - 'a';
			int startY = Integer.parseInt(start.substring(1)) - 1;
			// board[startX][startY] = 1;

			int endX = end.charAt(0) - 'a';
			int endY = Integer.parseInt(end.substring(1)) - 1;
			// board[endX][endY] = 100;

			Queue q = new Queue(100);
			Point current = null;
			q.push(new Point(startX, startY, 0));
			while (!q.isEmpty()) {
				current = q.peek();
				q.pop();
				if (current.x == endX && current.y == endY) {
					break;
				}

				for (int j = 0; j < 8; j++) {
					int x = current.x + xValues[j];
					int y = current.y + yValues[j];

					if (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == 0) {
						board[x][y] = 1;
						q.push(new Point(x, y, current.step + 1));
					}
				}
			}
			System.out.println(current.step);

		}

	}

}
