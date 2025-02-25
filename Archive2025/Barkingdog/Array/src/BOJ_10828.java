import java.util.Scanner;
import java.util.Stack;

public class BOJ_10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<Integer>();
		int N = sc.nextInt(); // 명령어 개수
		for (int i = 0; i < N; i++) {
			String cmd = sc.next();
			
			// 출력: pop, size, empty, top
			switch(cmd) {
			case "push":
				int val = sc.nextInt();
				stack.push(val);
				break;
				
			case "pop": // 가장 상단 정수 빼고 출력, 없는 경우는 -1
				if (stack.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.empty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if (stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
				break;
			}
			
		} // cmd
		
		sc.close();
	}
}
