import java.util.ArrayList;
import java.util.Arrays;

public class comb3_recursion_and_iterator {
	static String[] 재료;
	static String[] sel; //햄버거 만들 재료 
	static int N, R; // N: 전체 재료의 수, R: 내가 뽑을 재료의 수
	static ArrayList<String[]> result;
	
	public static void main(String[] args) {
		// 선언 초기화는 매 테케마다 해야하는거~~ 사실은 입력 받아얗애~~
		N = 4;
		R = 2;
		재료 = new String[] {"상추", "패티", "토마토", "치즈"};
		sel = new String[R]; // null로 구성된 임시배열 
		// 참조값 넣는데 맨날 새 배열 넣는게 아니니까 ~ 
		// 깊복 해야 하는데 얕복 이슈 생길 수 있음 
		result = new ArrayList<>();
		comb(0, 0);
		
		for (String[] arr: result) {
			System.out.println(Arrays.toString(arr));
		}
	} // main
	
	// idx; 내가 고려할 재료, sidx: 임시배열 
	public static void comb(int idx, int sidx) {
		// 종료조건
		if (sidx == R) {
//			System.out.println(Arrays.toString(sel));
			result.add(sel);
			return;
		}
		
		// 재귀조건 > 여기 반복문 작성 
		// 이번 코드에서는 고려할 범위가 고정되어 있음 > 반 
		for(int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = 재료[i];
			comb(i+1, sidx+1);
		}
	}
}
