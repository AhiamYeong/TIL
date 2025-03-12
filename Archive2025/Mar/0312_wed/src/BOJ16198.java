import java.util.*;

/* 순열 문제: 원소 n개라면 0번째, n-1번쨰 제외 -> 선택할 수 있는 수는 1 - n-1까지
 * 제거 순서O, 중복 허용 X -> 순열
 * value 직접 arr에서 제거하지 말고 visited로만 표현 -> -1, +1 잡기 어려울 거 같아
 * 근데 지우게 되면 다음 순서는 어떻게 구현?? 
 * 안지우고 visited 두고, visited = false인 인접 원소만 탐색하는 방식은?ㅇ
 * 1 arr & visited로 인접 원소만 탐색해보기
 * */

public class BOJ16198 {
	
	static int[] arr;
	static int N;
	static boolean[] visited;
	static int[] sel; // 선택할 수 있는 개수는 N-2
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 초기화 
		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N]; // 0, 마지막 원소도 함께 고려
		sel = new int[N-2]; // 0, 마지막 원소 고려X
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} // input
		
		// 제거할 순서 -> idx 기반으로 돌리기 
		perm(0);
		System.out.println("max: " + max);
		
		sc.close();
	}
	
	// 제거할 것 > idx로 생각하기
	static void perm(int sidx) {
		// 종료 > 수열 완성 
		if (sidx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			calc();
			// 완성시 값 계산 넘기기 
			return;
		}
		
		// 순열 생성할 수 있는 범위는 arr idx 1부터 N-2까지 고려 가능
		for (int i = 1; i < N-1; i++) {
			if (!visited[i]) {
				// 사용 & 방문처리
				sel[sidx] = i; 
				visited[i] = true;
				
				// 다음 원소 선택
				perm(sidx+1);
				
				// 원상복구
				visited[i] = false;
			}
		}
	} // 제거할 idx 순서 잡기
	
	// 에너지 계산 함수
	// visited 재사용, 순서가 있으니까 값 직접 제거하지 않기
	static void calc() {
		int sum = 0;
		
		for (int sidx = 0; sidx < sel.length; sidx++) {
			// sel은 어차피 인덱스 저장했음 
			
			// visited 재사용: 사용 체크
			
			visited[sidx] = true;
			int center = sidx;
			int left = sidx - 1;
			int right = sidx + 1;
			
			// 이미 사용한 변수면 더 땡기기
			while (visited[left]) {
				left--;
			}
			while (visited[right]) {
				right++;
			}
			
//			while (visited[left] && left >= 0) left--;
//			while (visited[right] && right < N) right++;

		///////////// 여기를 고치면 될 것 같은데 ////////////
			sum += arr[left] * arr[right];
			
			System.out.println(sum);
		} // sidx 전체 돌기 
		if (sum > max) max = sum;
	} // 에너지 합 계산 
}
