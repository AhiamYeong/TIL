import java.util.Scanner;
import java.util.Stack;

public class BOJ_12789 {
	public static void main(String[] args) {
		// 가장 첫 번째 idx가 stack?
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 승환이 앞에 서있는 학생 수
		// 승환이는 n+1번째
		int[] nums = new int[N]; // 승환이 앞에 
		
		// 순서대로 간식 받을 수 있는가 
		// 번호 순서대로 저장되어야 nice
		// 줄 서있는 리스트,스택은 가장 앞에 있음 
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		// 1열 - stack
		Stack<Integer> stack = new Stack<>();
		// 번호표 순서대로만 통과 
		int[] goal = new int[N];
		
		boolean isOrdered = true;
		
		// stack에 역순으로 들어갈 수 있다면 ok
		
		String p = isOrdered? "Nice" : "Sad";
		System.out.println(p);
		sc.close();
	}
}
