
public class subset3_recursion {

	static String[] 재료 = {"단무지", "햄", "오이", "계란"};
	static int N = 4; // 김밥 재료 개수
	static boolean[] sel = new boolean[N];
	
	public static void main(String[] args) {
		powerSet(0);
	
	}
	// idx: 단무지 판단할지 햄 판단할지 ... 
	// N은 static으로 선언 
	public static void powerSet (int idx) {
		// 1 종료 부분: 재료를 모두 고려한 경우.
		// N에 도달한 경우 -> idx 0, 1, 2, 3 전부 고려 -> N일 경우 첫 초과가 나기 때문.
		if (idx == N) {
			String tmp = "김밥: ";
			for (int i = 0; i < N; i++) {
				if (sel[i]) { // boolean 배열 
					tmp += 재료[i];
				}
			}
			System.out.println(tmp);
			return;
		}
		
		
		// 2 재귀 부분 
		sel[idx] = true; // idx자리 재료 넣기 
		powerSet(idx+1); // 다음 재료로
		// 한 번에 쓴다고 바뀌는거 아니고, 여기서 프레임 멈춘 채로 끝날때까지 시스템스택에 유지됨 ... 
		
		sel[idx] = false; // idx 자리 재료 넣지 않을것
		powerSet(idx+1); // 다음 재료로 
	}
}
