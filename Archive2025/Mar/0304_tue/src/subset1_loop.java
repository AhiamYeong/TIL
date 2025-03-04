import java.util.Arrays;

public class subset1_loop {
	static String[] 재료 = {"단무지", "햄", "오이", "계란"};
	static int N = 4; // 김밥 재료 개수
	
	// 해당 재료 사용하는지 유무 // 썼니 안썼니를 boolean으로 저장
	static int[] sel = new int[N]; 
	public static void main(String[] args) {
		// 반복문 4중 for문으로 구성 (재료 개수만큼 필요) 
		for (int i = 0; i <= 1; i++) {
			sel[0] = i; // 단무지 채워져 있는 상태 확인
			for (int j = 0; j <= 1; j++) {
				sel[1] = j;
				for (int k = 0; k <= 1; k++) {
					sel[2] = k;
					for (int l = 0; l <= 1; l++) {
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					} // 계란 
				} // 오이
			} // 햄
		} // 단무지 
	}
}
