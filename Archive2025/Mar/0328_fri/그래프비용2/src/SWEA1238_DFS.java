/* 거리 가중치 없으니까 걍 BFS가 나을듯 ㅎㅎ; */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SWEA1238_DFS {
	
	static boolean[] visited;
	static List<Integer> adj[];
	static int maxIdx;
//	static Map<Integer, Integer> verToIdx;
	
	static class Edge {
		int from, to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
		visited = new boolean[10000];
		adj = new ArrayList[10000];
		
		
		// 입력 받기
		int N = sc.nextInt();
		int start = sc.nextInt();
		
		// N개 입력 주어짐
//		List<Integer> tmplist = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		List<Edge> list = new ArrayList<>();
		
		for (int i = 0; i < N/2; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			Edge eg = new Edge(s, e);
			list.add(eg);
			set.add(s);
			set.add(e);
		}
		
		int E = N / 2; // 간선 개수
		
//		verToIdx = new HashMap<>();
//		int idx = 0;
//		for (int vertex: set) {
//			// key 없으면 저장하고 idx로 ㄱㄱ
//			if (!verToIdx.containsKey(vertex)) {
//				verToIdx.put(vertex, idx++);
//			}
////		} 
//		// 마지막까지 돈 인덱스가 정점 크기 될 것 
//		System.out.println(idx);
		int V = set.size(); // 정점의 개수
		
		// 인절미스트 초기화 - 정점개수만큼 
//		adj = new ArrayList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
//		
//		visited = new boolean[V+1];
		
//		// adj 저장
//		for (int i = 0; i < list.size(); i++) {
//			int s = list.get(i).from;
//			int e = list.get(i).to;
//			
//			// 입력 : idx 1:1 매칭 & 유향 그래프
//			adj[s].add(e);
//		}
		
		for (Edge e: list) {
			adj[e.from].add(e.to);
		}
		
		maxIdx = 0;
		
		bfs(start);
		
		System.out.println("#" + tc + " " + maxIdx);
		}
		
		sc.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList();
		
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
		    int size = q.size(); // 현재 depth의 노드 수
		    int depthMax = 0; // depth 전체에서 가장 큰 번호 저장

		    // 이번 depth 전체 노드 확인하고 최대값 갱신  
		    for (int i = 0; i < size; i++) {
		        int curr = q.poll();
		        // 이번 depth에서 가장 큰 값????
		        depthMax = Math.max(depthMax, curr);

		        for (int next : adj[curr]) {
		            if (!visited[next]) {
		                visited[next] = true;
		                q.offer(next);
		            }
		        }
		    }

		    // depth 다 돌았을 때만 max 갱신
		    maxIdx = depthMax;
		}
	} // bfs
}
