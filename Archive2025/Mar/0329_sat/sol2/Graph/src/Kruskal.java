import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 간선 중심: 객체배열 > 가중치 오름차순 > 사이클 생기지 않게
 * 루트 다르면 통합하기 */

public class Kruskal {
	
	static class Edge implements Comparable<Edge>{
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			super();
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}
		
		// 간선 객체들을 가중치 기준으로 정렬하기 위함 
		// 내 cost와 다른 cost를 비교해서
		// this.cost 전부 양수 가정 > 작은 것부터 나열 위함 
		@Override
		public int compareTo(Kruskal.Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] parent; // root 저장  
	
	public static void main(String[] args) {
		int n = 5; // 간선 개수
		int e = 3; // 엣지 개수 
		
		parent = new int[n+1];
		// 각자 루트로 초기화 
		for (int i = 0; i <= n; i++) parent[i] = i;
		
		Edge[] edges = new Edge[n+1];
		
		
		// 1 가중치 기준, 오름차순 정렬 
		Arrays.sort(edges);
		// 2 가중치 가장 낮은 간선부터 선택하며 트리에 넣기

		int ans = 0; // 누적 비용
		for (int i = 0; i < e; i++) {
			int s = edges[i].st;
			int e = edges[i].ed;
			int cost = edges[i].cost;
			
			// 가중치 가장 낮은 간선 이미 선택됨
			if (find(s) != find(e)) {
				union(s, e);
				ans += cost;
			}
		}
	}
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) parent[rootA] = rootB;
	}
}
