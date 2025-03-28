package 그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소비용2_프림_우선순위큐 {
	
	static final int INF = Integer.MAX_VALUE;
	
	// 간선 A -> B 사이 cost: 
	static class Edge implements Comparable<Edge>{
		int to, cost; // 어디에서 왔는지는 중요X, 어디에 연결되어 있는지가 중요
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		// 정점, 간선의 개수 
		int V = sc.nextInt(); // 0번부터 시작
		int E = sc.nextInt();
		
		// 인접리스트 생성
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		} 
		
		// 간선만큼 
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt(); 
			
			// 무향 그래프: 인접 리스트에 양방향 저장
			adj[s].add(new Edge(e, cost));
			adj[e].add(new Edge(s, cost));
			
		} // 간선 입력 끝
		
		// 트리 정점인지, 비트리 정점인지 확인할 배열
		boolean[] visited = new boolean[V]; // 트리 소속인지 아닌지 기록 위함
		int ans = 0; // 최소비용 (정답)
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
//		int pick = 1;  // 몇 번 골랐는지 저장할 변수
		// 방법 4.
		int pick = 0; 
		pq.add(new Edge(0, 0)); // 0, 0으로 시작하고, 내부로 넘기기 
		// 0번 고르고, 연결된 간선 모두 넣기
		visited[0] = true;

		// 방법1. 
//		for (int i = 0; i < adj[0].size(); i++) {
//			pq.add(adj[0].get(i));
//		}
		
//		방법2. for (Edge e: adj[0]) pq.add(e);
		
//		방법3. pq.addAll(adj[0]);
		
		while(pick < V) {
			Edge e = pq.poll(); // (2, 31)이 나오게 됨
			// 만약 현재 edge의 목표정점 방문했으면 넘기기
			if (visited[e.to]) continue;
			
			ans += e.cost;
			visited[e.to] = true;
			pick++;
			
			pq.addAll(adj[e.to]); // 모든 정점 추가
		}
		
		System.out.println(ans);
		
	} // main
	
	
	static String input = "7 11\r\n" + //
	        "0 1 32\r\n" + //
	        "0 2 31\r\n" + //
	        "0 5 60\r\n" + //
	        "0 6 51\r\n" + //
	        "1 2 21\r\n" + //
	        "2 4 46\r\n" + //
	        "2 6 25\r\n" + //
	        "3 4 34\r\n" + //
	        "3 5 18\r\n" + //
	        "4 5 40\r\n" + //
	        "4 6 51\r\n" + //
	        "";
	
	
}
