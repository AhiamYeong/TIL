import java.util.Arrays;
import java.util.Scanner;

public class Tree2_연습문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //노드의 총 개수 (0번부터? 1번부터? 파악)
		int[][] tree = new int[V+1][3];
		// 1-based index + 0 왼좌 & 1 오좌 & 2 부모
		String str = sc.next();
		
		for (int i = 0; i < V - 1; i++) {
			int p = sc.nextInt(); // 부모
			int c = sc.nextInt(); // 자식
			// 문제에서 부모 노드 번호 작은 것부터 줌
			// 왼쪽 자식부터 줌 -> 왼좌부터 채우기
			if (tree[p][0] == 0) { // 왼좌 안채워졌으면
				tree[p][0] = c;
			} else {
				tree[p][1] = c;
			}
			// 브모정보 저장
			tree[c][2] = p;
			
		} // 입력
		
		for (int i = 0; i < V + 1; i++) {
			System.out.println(i + Arrays.toString(tree[i]));
		}
		sc.close();
	}
}
