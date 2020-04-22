package sort;

public class ArrayQueue {

	private int size;
	private int front;
	private int rear;
	private int[] queue;

	public ArrayQueue(int leng) {
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

	public boolean isFull() {
		if (rear == size - 1) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int item) {
		if (!isFull()) {
			rear++;
			queue[rear] = item;
		} else {
			System.out.print("Queue is full");
		}
	}

	public void pop() {
		if (!isEmpty()) {
			queue[front] = 0;
			front++;
		} else {
			System.out.print("Queue is empty");
		}
	}

	public int peek() {
		return queue[front];
	}
}
