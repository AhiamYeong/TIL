/* 시작 노드에서 pq로 '가장 짧은 거리' 꺼내기 
 * 다익스트라는 지금까지 누적 거리 + 다음 간선 거리 < 기존 거리면 갱신
 *  */ 

import java.util.Arrays;
import java.util.PriorityQueue;


public class Dijkstra {
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] visited;
	
	static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Dijkstra.Edge o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) {
		int V = 5;
		int E = 3;
		
		// 1 거리 배열 초기화 (처음엔 무한대, 알게되면 갱신)
		dist = new int[V];
		visited = new boolean[V+1];
		
		Arrays.fill(dist, INF);
		Edge start = new Edge(0, 0);
		
		dist[start.to] = 0; // 시작 정점의 거리는 0
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(start); // 가장 빨리갈 수 있는 노드 찾자 
		
		// 3 큐에서 꺼내며 탐색 
		while(!pq.isEmpty()) {
			Edge curr = pq.poll(); // 가장 짧은 노드 꺼내줌 
			// 4 이미 방문한 노드라면 스킵(비용 알고있음)
			if (visited[curr.to]) continue;
			visited[curr.to] = true; //선택 
			
			//연결된 다음 노드 다 넣기
			for (Edge next: adjList[curr.to]) {
				int curCost = curr.cost + next.cost;
				
				// 처음에는 무한대, 다음까지 거리보다 현재 계산값이 작으면 변경 
				if (curCost < dist[next.to]) {
					// dist 변경하고, 새로 값 넣어주기
					dist[next.to] = curCost;
					pq.offer(new Edge(next.to, curCost));
				}
			}
			
		}
	}
}
