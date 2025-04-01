package day11_위상정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_큐 {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점 개수 (1번부터 시작)
		int E = sc.nextInt(); // 간선 개수
		
		int[][] adj = new int[V+1][V+1]; // 인접 행렬
		int[] degree = new int[V+1]; // indegree 저장
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			adj[s][e] = 1; // 가중치 없으므로 걍 1로 저장, 유향그래프  
		
			// 도착지점의 진입차수 올리기
			degree[e]++; 
			
		}// 간선 입력
		
		// 정점 번호만 관리즁
		Queue<Integer> q = new LinkedList<>();
		
		
		// 1. 진입차수 0인 정점 전부 큐에 넣기
		// 반복문 순서에 따라 뭐 먼저할수도~~
		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0) q.offer(i);
		}
		
		// 2. 큐가 빌 때까지 반복
		// 꺼내서 간선 제거 (진입차수 깍기) -> 0 되면 새로 넣기
		while(!q.isEmpty()) {
			int curr = q.poll(); 
			// 2.1. curr은 indegree 0인 노드들 
			System.out.println(cook[curr]);
			
			// 2.1. curr과 연결된 간선들 제거하기 (indegree 깎기)
			// 인접행렬로 저장 -> curr과 연결된 간선이 먼지 몰라! 확인해야해!
			// 인접리스트였다면 연결된게 무엇인지 알수 있겠지만
			for (int to = 1; to <= V; to++) {
				// 2.2. 연결된 간선이 있다면 (유향그래프) 
				if (adj[curr][to] == 1) {
					// 도착지 degree 감소
					degree[to]--;
					
					// 2.3. 감소시킨 값이 0이라면 큐에 넣기 
					if (degree[to] == 0) q.add(to);
				}
			}
		}
		
		
		sc.close();
	}
	
	static public String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7\r\n";
}
