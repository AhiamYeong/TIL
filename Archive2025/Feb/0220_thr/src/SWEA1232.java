import java.util.Scanner;

public class SWEA1232 {
	public static boolean isOperator(String value) {
		return (value == "+" || value == "-" || value == "*" || value == "/" || value == "%");
	}
	
	// 중위탐색 들어가면 안됨 
	public static int inOrder(String[][] tree, int v) {
		// v는 찾기 시작할 idx
		int N = tree.length; 
		int res = 0;
		// 정점 개수 N+1개, 0 data, 1 피연산자idx1, 2 피연산자idx2

		 // L -> 왼쪽 자식으로 ㄱㄱ
		if (tree[v][1] != null)
			inOrder(tree, Integer.parseInt(tree[v][1])); 
		
		// V 연산자 - 만날 때마다 결과값 저장쓰
		// A - B를 만드는 법??? 연산식 ??? 다 따로 해줘?? ㅇ
		// leaf node가 피연산자일 경우 있고 연산자일 경우 있음 
		if (tree[v][0] != null) {
			// 연산자인 경우
			if (isOperator(tree[v][0])) {
				// node가 연산자인 경우 좌/우측하단은 무조건 피연산자
				String key = tree[v][0];
				int left = Integer.parseInt(tree[v][1]);
				int right = Integer.parseInt(tree[v][2]);
				
				if (key == "+") {
					res += left + right;
				} else if (key  == "-") {
					res += left - right;
				} else if (key  == "*") {
					res += left * right;
				} else if (key  == "/") {
					res += left / right;
				} else if (key  == "%") {
					res += left - right;
				}
			} // if isoperator
		// R -> 오른쪽으로 ㄱㄱ 
		if (tree[v][2] != null)
			inOrder(tree, Integer.parseInt(tree[v][2]));
		// 순회 끝날 때마다 결과값 저장해야 함
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// tc 10개
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 정점 개수
			String[][] tree = new String[N+1][3];
			// 정점 개수 N+1개, 0 data, 1 피연산자idx1, 2 피연산자idx2
			sc.nextLine(); // 공백 처리
			for (int i = 0; i < N; i++) {
				// N번 정점
				String str = sc.nextLine(); // 한 줄 입력받기
				String[] splits = str.split(" "); // 공백 기준 자름
				
				int idx = Integer.parseInt(splits[0]);
				// 연산자일 경우: 피연산자 2개 모두 주어짐
				tree[idx][0] = splits[1];
				// 4개 들어올 경우 피연산자 2개 추가로 받기
				if (splits.length > 2) { 
					tree[idx][1] = splits[2];
					tree[idx][2] = splits[3];
				}
			} // 정점 정보 입력
			int res = inOrder(tree, 1); //root idx부터 중위탐색
			System.out.println("#" + tc + " " + res);
			
		} // tc
		
		sc.close();
	}
}
