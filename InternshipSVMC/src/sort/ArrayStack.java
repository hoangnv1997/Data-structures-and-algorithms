package sort;

public class ArrayStack {

	private int top;
	private int[] stack;
	private int size;

	public ArrayStack(int leng) {
		size = leng;
		stack = new int[size];
		top = -1;
	}

	//Kiem tra stack rong
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	//Kiem tra stack day
	public boolean isFull() {
		if (top >= size - 1) {
			return true;
		} else {
			return false;
		}
	}

	//Lay gia tri phan tu o dinh stack
	public int peek() {
		return stack[top];
	}

	//Them phan tu vao dinh stack
	public void push(int item) {
		if (!isFull()) {
			top++;
			stack[top] = item;
		} else {
			System.out.print("Stack is full");
		}
	}

	//Xoa phan tu khoi dinh stack
	public void pop() {
		if (!isEmpty()) {
			stack[top] = 0;
			top--;
		} else {
			System.out.print("Stack is empty");
		}
	}

}
