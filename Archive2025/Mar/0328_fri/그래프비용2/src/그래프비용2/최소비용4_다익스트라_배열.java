package 그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 최소비용4_다익스트라_배열 {
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E; // 각 정점(0부터), 간선 개수
	static List<Edge>[] adj; // 인접리스트
	static int[] dist; // 거리 저장 
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();
			
			// 이번엔 유향그래프 ~
			adj[s].add(new Edge(e, cost));
			
		} // 간선 입력
		
		
		dijkstra(0); // 0번부터 시작
		System.out.println(Arrays.toString(dist));
		
	} // main
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		dist[start] = 0; // 시작 정점 거리값을 0으로 갱신
		
		// 3. 정점 수만큼 돌며 확인 
		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;
			
			// 3.1. 가장 작은 값 추출
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} // 가장 작은 값 뽑았음 & idx 갱신했음 & 방문 처리

			// 더 진행하는건 무의미 ~~ idx 갱신 다 했으면 더 갈 수 있는 곳 없음  
			if (idx == -1) break; 
			
			visited[idx] = true; 
			
			// 3.2. 갱신 작업 수행
			for (Edge e : adj[idx]) {
				// 방문하지 않았으며 & 나와 연결되며(e.to로 해결) & 갱신 가능하면
				// A > E OR A > B > E 중 최단거리 찾기 
				// E는 dist[e.to]에 저장됨 & B > E는 dist[idx] + e.cost 
				if (!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
					dist[e.to] = dist[idx] + e.cost;
				}
			}
		}
	}
	
	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12\r\n"
			+ "";
	
}
