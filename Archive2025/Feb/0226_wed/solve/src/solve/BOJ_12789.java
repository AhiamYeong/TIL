package solve;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_12789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 앞에 서있는 학생 수
		int N = sc.nextInt();
		// 번호표 순서대로
		Stack<Integer> nums = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			nums.add(sc.nextInt()); 
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
		
		// stack 2개있고, 이 2개 뺐을 떄 1 - N 순서대로 들어가면 ok
		while(true) {
//			// 일단 tmp에 하나 넣고 시작하기
//			tmp.add(nums.pop());
			if (!nums.isEmpty()) {
				int numsTop = nums.peek();
				// 값 못 찾으면 tmp로 넘기기
				if (numsTop != num) {
					tmp.add(nums.pop());
				} else { // 값 찾으면 추가
					goal[idx++] = nums.pop();
					num++;
				}
			}
			
			if (!tmp.isEmpty()) {
				int tmpTop = tmp.peek();
				if (tmpTop != num) {
					isOk = false;
					break;
				} else { // 값 일치하면
					goal[idx++] = tmp.pop();
					num++;
				}
			}

			
			System.out.println("nums: " + nums);
			System.out.println("tmp: " + tmp);
			// 다 확인했는데 없으면 탈출
			if (nums.isEmpty() && tmp.isEmpty()) {
				isOk = false;
				break;
			}
		}
		
		System.out.println(Arrays.toString(goal));
		
		// 1-N까지 순서대로 안나오면 sad

		String res = isOk? "Nice" : "Sad";
		System.out.println(res);
		sc.close();
	}
}