import java.util.*;

public class BOJ2606 {
	public static void main(String[] args) {
		// 연결 정보 있음
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 컴퓨터 수
		
		int M = sc.nextInt(); // 연결된 쌍 
		
		// 인접리스트 방식 & 인접행렬 방식
		
		// 전체 node의 정보 담을 list > 채워주기
//		1-based index 사용, 1번에 1번 정보 저장???
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		// 1-based index 사용하기 위해 N+1로 생성
		for (int i = 0; i < N+1; i++) {
			// 새 list 넣기 ~ 객체를 생성해서 넣어줘야 함 (클래스X, 객체O)
			list.add(new ArrayList<Integer>());
		}
		
		// 인덱스는 어떻게 다루는?? 
		// 저장 순서대로 1 - N번 // 어차피 N개까지 만들었으니까
		for (int i = 0; i < M; i++) {
			// 인접리스트 채택 > node별로 연결정보 포함된 list 만들기. 
			// list에 들어가는 건 또다른 arraylist 형태
			// input받는 건 2개의 노드 (대상, 연결대상)
			// 무방향 > 양측 모두 추가
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			list.get(n1).add(n2);
			list.get(n2).add(n1);
			
		} // input - 인접리스트 생성완료
		
		// 1번 바이러스 걸림 > 1번 통해 바이러스 걸릴려면 >> dfs 사용 (이제부터)
		boolean[] visited = new boolean[N+1]; // node수 만큼의 배열
		int cnt = 0;
		
		// dfs 수행 > 최대한 깊이 (함수로 분리)
		int res = startdfs(1, list, visited);
		
		System.out.println(res);
		sc.close();
	}
	
	// 재귀로 dfs 구현 
	public static int startdfs(int index, List<ArrayList<Integer>> list, boolean[] visited) {
		// list 내에서 index부터 dfs 시작하기
		// 초기값
		visited[index] = true; // 방문 조건 걸기
//		System.out.println(index + " ");
		int cnt = 0; 
		
		// index 내 list에서 확인
		for (int a : list.get(index)) {
			// a 방문 안 했으면
			// 여기도 계속 누적되니까
			if (!visited[a]) {
				cnt += 1 + startdfs(a, list, visited);
			}
		}
		return cnt;
	}	// dfs 수행 (재귀 형태)
}
