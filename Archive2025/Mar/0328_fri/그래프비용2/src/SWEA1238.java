/* 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람 > 비용이랑은 상관없지 않나?
 * 유향그래프 > 더 갈 수 있는 idx가 없으면 끝 
 * 시작 당번 정해짐: 가장 나중에 연락 받는 사람 중 번호가 가장 큰 사람 > 번호 큰 건 나중에 갱신
 * 다익스트라로 선택 > 왜 꼭 다익스트라?
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SWEA1238 {
	
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Edge>[] adj; // 인접 리스트
	static int[] dist; // 거리 저장 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
		
			// from, to 쌍 반복 개수 
			int N = sc.nextInt();
			E = N / 2; // 간선 개수가 12개

			// 정점의 시작점
			int start = sc.nextInt();
			
			Set<Integer> set = new HashSet<>();
			List<Integer> tmpList = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
			    set.add(tmpList.get(i)); // 중복 제거
			}
			
			List<Integer> vertexList = new ArrayList<>(set);
			Collections.sort(vertexList); // 정점 번호 오름차순 정렬

			Map<Integer, Integer> vertexToIndex = new HashMap<>();
			for (int i = 0; i < vertexList.size(); i++) {
			    vertexToIndex.put(vertexList.get(i), i);
			}

			
			// 인접리스트 초기화
			adj = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			
			dist = new int[V]; // 거리 저장할 배열 > 이 문제에도 필요 
			Arrays.fill(dist, INF);
			
			// 인접리스트에 저장
			int cnt = 0;
			int idx = 0;
			while(cnt < N) {
				int s = tmpList.get(cnt++);
				int e = tmpList.get(cnt++);
				// 유향그래프, 가중치 없음 
				adj[idx++].add(new Edge(e, 1));
				
			} // 간선 입력받기

			dijkstra(start);
			System.out.println(Arrays.toString(dist)); // dist가 정점 V까지의 거리?
			// 그럼 거리 가장 큰 사람 중 가장 번호 큰 거 선택하면? 
			int max = 0;
			int maxIdx = 0; 
			for (int i = 0; i < V; i++) {
				if (dist[i] == Integer.MAX_VALUE) continue;
				if (max < dist[i]) {
					maxIdx = i;
					max = dist[i];
				}
			}
			System.out.println(list.get(maxIdx));

		} // tc
		
		sc.close();
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		dist[start] = 0; 
		
		// 정점 돌며 확인 -> 가장 작은 값 추출 -> 다음 값 갱신 
		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;
			
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} // 가장 작은 값 뽑기
			
			if (idx == -1) return;
			visited[idx] = true;
			
			// 갱신
			for (Edge e: adj[idx]) {
				if(!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
					dist[e.to] = dist[idx] + e.cost;
				}
			}
		}
	}
}
