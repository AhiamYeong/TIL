import java.util.*;
public class BOJ18126 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 1번 root 기준 가장 깊이 탐색 -> dfs인듯
		// 최대한 깊게 들어간 후
		// backtracking 하기 전까지의 값 누적해서 최대값 찾아내기
		
		// root: 1, 1 기준으로 얼마나 깊이 들어가건 최대값만 있으면 댐 
		// 인접리스트로 연결상태 확인
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		} // initialize (1-based idx)
		
		for (int i = 0; i < N-1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int length = sc.nextInt(); // node1, node2 사이 거리
			
			// 1 연결상태 확인 & 2 node 간 거리 확인 
			// 양방향 연결 > 근데 양방향이 의미가 있나?
			list.get(node1).add(node2);
			list.get(node2).add(node1);
		} // graph edge
		
		
		
		sc.close();
	}
}
