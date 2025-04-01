/* 정점 중심: "key 저장할 dist 배열" & parent & visited 이용 
 * 정점 > 인접리스트 
 * 프림은 “방문한 정점 집합”에서 → “아직 방문 안 한 정점”으로 가장 저렴하게 연결하는 방식
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
	
	static boolean[] visited;
	
	static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Prim.Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static void main(String[] args) {
		int V = 5;
		int E = 3; // 정점, 간선의 개수
		
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt(); 
			
			// 무향 그래프: 인접 리스트에 양방향 저장
			adj[s].add(new Edge(e, cost));
			adj[e].add(new Edge(s, cost));
			
		} // 간선 입력 끝

		visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int ans = 0;
		visited[0] = true; // 0번부터 큐 start!
		// 0번과 연결된 간선 전부 넣기
		for (int i = 0; i < adj[0].size(); i++) {
			// pq에 들어가는 건 Edge(e=1, cost=3) Edge(e=2, cost=5)
			pq.offer(adj[0].get(i));
		}
		// 연결된 노드들 중 비교해서, 가장 적은 가중치 튀어나오게
		while(!pq.isEmpty()) {
			Edge e = pq.poll(); // pq이므로 꺼낸 값: 가장 작은 가중치
			
			// 방문한 정점이라면 패스
			if(visited[e.to]) continue;
			
			// 방문 처리 & 값 누적 
			ans += e.cost;
			visited[e.to] = true; 
			
			// e와 연결된 정점 싹 pq에 추가
			for (Edge next: adj[e.to]) {
				if (!visited[next.to]) pq.offer(next);
			}
		}
	
	}
}
