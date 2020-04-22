package array;

import sort.ArrayQueue;
import sort.ArrayStack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayStack stack = new ArrayStack(5);
		stack.push(4);
		
		System.out.println(stack.isEmpty());
		System.out.print(stack.peek());
		
		ArrayQueue queue = new ArrayQueue(4);
		System.out.print(queue.isEmpty());
	}

}
