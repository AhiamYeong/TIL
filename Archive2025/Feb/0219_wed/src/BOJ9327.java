import java.util.ArrayList;
import java.util.Scanner;

public class BOJ9327 {
	static boolean[] visited; // 클래스멤버로 선언해서 빼기
	static void dfs(int nodeIndex, ArrayList<ArrayList<Integer>> list) {
		visited[nodeIndex] = true; // 현재 노드 방문 처리
		// dfs 진행
		for (int neighbor : list.get(nodeIndex)) {
			if (!visited[neighbor]) {
				dfs(neighbor, list); // 방문 안 한 노드로 dfs 진행
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 국가의 수, 비행기의 종류
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] edges = new int[M][2]; // 연결 쌍으로 표현하기
			int cnt = 0;
			visited = new boolean[N+1]; // 국가 수 + 1만큼 
			
			// edges 배열 저장 - 비행기 M개
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < 2; j++) {
					// a, b 왕복 비행기 -> 둘다 왔다갔다
					edges[i][j] = sc.nextInt();
				}
			}
			
			// dfs 적용해서 풀어보기
			// 인접리스트로 표현 (리스트+리스트)
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			
			// 각 arraylist 초기화 -> vertex 기준이므로 N개 + 1-based index
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			// 리스트에 추가하기
			for (int[] edge: edges) {
				// 양쪽 방향 연결
				list.get(edge[0]).add(edge[1]);
				list.get(edge[1]).add(edge[0]); 
			}
			
			// dfs -> 하나 쭉 타고가서 끝까지 돌아오기
			// 시작할 때 방문 처리
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i, list); // 방문 안 했으면 dfs 시작
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		} // tc
		
		sc.close();
	}
}
