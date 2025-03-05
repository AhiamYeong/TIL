import java.util.*;

public class BOJ1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int V = sc.nextInt(); // 탐색 시작 번호
		
		// arraylist로 인접리스트 구현 
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		boolean[] visited = new boolean[N+1]; //1-based index
		// 인접리스트는 1개만 만들면 됨 (n+1개)
		
		// 인접리스트 초기화 (1-based idx)
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Integer>()); // arraylist 객체배열 초기화 
		} 
		
		// 인접리스트 값 추가
		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			// 양방향 리스트
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		} // input
		
		// input 들어오는건 마음대로, dfs/bfs 수행 전 인접리스트 정렬하기
		for (ArrayList<Integer> a: list) {
			Collections.sort(a);
		}
		
		
		// dfs 수행
		dfs(V, list, visited);
		
		// 같은 visited 부르면 안되지않나? 배열은 참조형이니까 동시에 바뀌자나
		// 다시 all false로 초기화
		
		// 정점 번호 작은 것 먼저 방문 >> 정렬 ?? 어디서 ? 
		for (int i = 0; i < N+1; i++) visited[i] = false;
		System.out.println();
		// bfs 수행
		bfs(V, list, visited);
		
		sc.close();
	}
	
	// dfs: 재귀로 구현
	public static void dfs(int idx, List<ArrayList<Integer>> list, boolean[] visited) {
		// 시작값: idx
		visited[idx] = true;
		// 방문 처리 
		System.out.print(idx + " ");
		
		for (int a : list.get(idx)) {
			// 방문 안 한 노드라면 다시 호출 
			if (!visited[a]) {
				dfs(a, list, visited);
			} 
		} // 인접한 리스트들 탐색하며
	}
	
	// bfs: 큐로 구현 
	public static void bfs(int start, List<ArrayList<Integer>> list, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 방문 처리
		visited[start] = true;
		// 방문한 노드 먼저 큐에 넣기 (초기화)
		queue.offer(start);
		
//		list.get(idx) > idx가 가지고 있는 배열 전부가 나오니까
		// 시작했으면 끝까지 돌아야 하니까 반복문 (~recursion in dfs)
		while (!queue.isEmpty()) {
			// '방문 처리' == 큐에서 빠지는 순간
			int node = queue.poll();
			System.out.print(node + " ");
			
			for (int next: list.get(node)) {
				// 다음 노드 방문하지 않았으면 
				if (!visited[next]) {
					// 큐에 노드 추가
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		// 방문하면 빼기 
	}
}
