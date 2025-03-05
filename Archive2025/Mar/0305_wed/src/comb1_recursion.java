import java.util.Arrays;

public class comb1_recursion {
	static String[] 재료;
	static String[] sel; //햄버거 만들 재료 
	static int N, R; // N: 전체 재료의 수, R: 내가 뽑을 재료의 수
	
	public static void main(String[] args) {
		// 선언 초기화는 매 테케마다 해야하는거~~ 사실은 입력 받아얗애~~
		N = 4;
		R = 2;
		재료 = new String[] {"상추", "패티", "토마토", "치즈"};
		sel = new String[R]; // null로 구성된 임시배열 
		
		comb(0, 0);
	} // main
	
	// idx: 내가 이번에 고려할 재료들의 인덱스 
	// sidx: 뽑은 재료의 인덱스
	public static void comb (int idx, int sidx) {
		
		// 종료조건 
		// R개에 도달 > 내가 R개를 뽑았다는 것.
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		// N개에 도달 > N개 전체 재료를 다 봤다는 것. (더 고려할 재료 X)
		if (idx == N) return; 
		// 재귀조건 
		// idx번째 재료 뽑았음
		sel[sidx] = 재료[idx]; // 햄버거에 재료 하나 쌓기
		comb(idx+1, sidx+1); // 다음 재료 판단하기
		
		// idx번째 재료 안뽑았음 
//		sel[sidx] = null; // 안 뽑은 걸로 하자 > 결국 덮어씌우기 됨 
		comb(idx+1, sidx); // 다시 고려해죠 
		
	}
}
