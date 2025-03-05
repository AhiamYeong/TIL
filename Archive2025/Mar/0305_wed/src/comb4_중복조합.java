import java.util.*;

public class comb4_중복조합 {
	static String[] 재료;
	static String[] sel; //햄버거 만들 재료 
	static int N, R; // N: 전체 재료의 수, R: 내가 뽑을 재료의 수
	static ArrayList<String[]> result;
	
	public static void main(String[] args) {
		// 선언 초기화는 매 테케마다 해야하는거~~ 사실은 입력 받아얗애~~
		N = 4;
		R = 2;
		재료 = new String[] {"상추", "패티", "토마토", "치즈"};
		result = new ArrayList<>();
		combcomb(0, new ArrayList<String>());
		
	} // main
	
	// current = 임시리스트
	public static void combcomb(int start, List<String> current ) {
		// 종료조건
		if (current.size() == R) {
			System.out.println(current);
			return;
		}
		// 재귀조건
		for (int i = start; i < N; i++) {
			current.add(재료[i]);
			combcomb(i, current); // 상추 뽑고도 다시 상추부터 고려해야 함
			// 상추 추가됐으면 다시 뽑기 
			current.remove(current.size()-1);
		}
		
	}
}
