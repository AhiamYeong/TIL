import LinkedStack.LinkedStack;

public class LinkedList3_연결스택 {
	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
