package laptop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_12789_new {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 앞에 서있는 학생 수
		int N = sc.nextInt();
		// 번호표 순서대로 > 여기는 큐구나 
		Queue<Integer> nums = new LinkedList<>();
//		Stack<Integer> nums = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			nums.offer(sc.nextInt()); 
		}
		// 1-N 순서대로 들어갈 수 있으면 ok
		boolean isOk = true;
		int[] goal = new int[N];
		
		// 맨 앞 1열 공간
		Stack<Integer> tmp = new Stack<Integer>();
		
		// 대기열 > 간식 받기 or 스택에 들어가기 택1
		int num = 1; // 번호표 순서대로
//		int item = -1; 
		int idx = 0;
		int tmpTop = -1; // Nums의 head
		int numsTop = -1;  // tmp의 head 
		
		// stack 2개있고, 이 2개 뺐을 떄 1 - N 순서대로 들어가면 ok
		// 원소에서 1개씩 제외해보기 
		while(true) {
			// 그럼 종료조건은 언제?
			// nums <> tmp 왔다갔다하기 
			if (!tmp.isEmpty()) {
				tmpTop = tmp.peek();
			}
			if (!nums.isEmpty()){
				numsTop = nums.peek();				
			}
			
			// tmpTop, numsTop 비교 
			if (numsTop == num) {
				goal[idx++] = nums.poll();
				num++;				
			}
			if (tmpTop == num) {
				goal[idx++] = tmp.pop();
				num++;
			}
			// 일치하는 값 없으면 원소 이동
			// poll 전에 null check
			if (!nums.isEmpty()) tmp.add(nums.poll());
			
			// 위 분기에서 안 빠지면
			System.out.println("tmp: " + tmp);
			System.out.println("nums: " + nums);
			System.out.println("goal: " + Arrays.toString(goal));
			// 더 못감 > 뽑기 
			if (nums.isEmpty()) {
				while(!tmp.isEmpty()) {
					goal[idx++] = tmp.pop();
				}
				break;
			}
			
		} // 제거 
		
		System.out.println(Arrays.toString(goal));
		
		// 정답 집합
		for (int i = 0; i < N; i++) {
			if (goal[i] != (i+1)) {
				isOk = false;
				break;
			}
		}
		

		String res = isOk? "Nice" : "Sad";
		System.out.println(res);
		sc.close();

	}
}
