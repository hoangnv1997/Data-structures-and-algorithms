package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ELEVTRBL {

	private static Scanner sc;

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
			if (front > rear || front < 0) {
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
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai ELEVTRBL"));
		sc = new Scanner(System.in);
		int nFloor = sc.nextInt();
		int s = sc.nextInt();
		int g = sc.nextInt();
		int u = sc.nextInt();
		int d = sc.nextInt();

		int[] mark = new int[nFloor + 1];
		Queue q = new Queue(nFloor + 1);
		q.push(s);
		while (!q.isEmpty()) {
			int v = q.peek();
			q.pop();
			if (v == g) {
				break;
			}
			int up = v + u;
			int down = v - d;
			if (up <= nFloor && mark[up] == 0) {
				q.push(up);
				mark[up] = mark[v] + 1;
			}
			if (down >= 1 && mark[down] == 0) {
				mark[down] = mark[v] + 1;
				q.push(down);
			}
		}
		if (mark[g] == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(mark[g]);
		}

	}

}
