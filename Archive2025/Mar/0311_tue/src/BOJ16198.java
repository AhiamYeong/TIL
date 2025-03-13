import java.util.*;

/* (1, ... ,N) 구슬1개 고르기 -> x번째 제거 -> x-1 * x+1 에너지 
 * -> 번호 다시 매기기
 * 막 바꿔 > linkedlist
 * */

public class BOJ16198 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 값 저장 
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		int max = 0; // 에너지 최댓값 
		
		// 2개 남을때까지 완탐 
//		while (list.size() > 2) {
//			// 1 첫번째&마지막 빼고 1번째부터 제거해보기
//			int sum = 0;
//			for (int idx = 1; idx < list.size()-1; idx++) {
//				sum += list.get(idx-1) * list.get(idx+1);
//				list.remove(idx);
//				System.out.println(sum);
//			}
//			
//		}
		
		for (int idx = 1; idx < list.size()-1; idx++) {
			while (list.size() > 2) {
				int sum = 0;
				sum += list.get(idx-1) * list.get(idx+1);
				list.remove(idx);
				System.out.println(sum);
			
			}
		
		}
		
		
		System.out.println(max);
		
		sc.close();
	}
}
