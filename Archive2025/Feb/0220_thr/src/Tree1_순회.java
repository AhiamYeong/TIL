
public class Tree1_순회 {

	// 1-based idx 사용하기 위해 가장 앞은 버리기
	public static char[] tree = new char[] {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I'};
	public static int N = tree.length;
	public static void main(String[] args) {
		System.out.println("전위 순회: ");
		preOrder(1); // 1번 노드 (루트)부터 시작
		System.out.println("\n중위 순회: ");
		inOrder(1); // subtree의 root 넣어도 돌아감.
		System.out.println("\n후위 순회: ");
		postOrder(1);
	}
	
	// 전위 순회 -> 트리 구현은 배열로 인자 받기
	// v는 노드의 번호 - 전위 순회
	public static void preOrder(int v) {
		// 노드 번호가 유효한지 확인
		// 탈출문 없는 재귀? -> 이미 v < N 조건을 걸어두었으므로 
		// 무한루프 빠지지 않고 언젠간 종료되게 됨
		if (v < N) { // 범위 안에 있음
			// 방문 처리
			if (tree[v] != ' ') {
				System.out.print(tree[v] + " ");	
			}
			
			// 왼쪽 자식 탐색
			preOrder(v * 2);
			// 오른쪽 자식 탐색
			preOrder(v * 2 + 1);
		}
	}
	
	public static void inOrder(int v) {
		if (v < N) { // 범위 안에 있음
			// 방문 처리
			// 왼쪽 자식 탐색
			inOrder(v * 2);
			if (tree[v] != ' ') {
				System.out.print(tree[v] + " ");	
			}
			// 오른쪽 자식 탐색
			inOrder(v * 2 + 1);
		}
	}
	
	public static void postOrder(int v) {
		if (v < N) { // 범위 안에 있음
			// 방문 처리
			// 왼쪽 자식 탐색
			postOrder(v * 2);
			// 오른쪽 자식 탐색
			postOrder(v * 2 + 1);
			if (tree[v] != ' ') {
				System.out.print(tree[v] + " ");	
			}
		}
	}
}
