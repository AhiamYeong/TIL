// 간단한 369게임

import java.util.Scanner;

public class SWEA1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 숫자 1부터 N까지 차례대로 말하기
		for (int i = 1; i <= N; i++) {
			// 숫자 각 자릿수마다 char 배열로 저장해서 검사
			String str = Integer.toString(i); // i를 str로 저장
			
			char[] digit = new char[str.length()]; // str을 char로 분해
			// digit에 저장
			for (int j = 0; j < digit.length; j++) {
				digit[j] = str.charAt(j); // j번째 저장
			}
			
			// digit 배열 내에서 3, 6, 9몇 개 있나 검사
			int cnt = 0;
			for (int j = 0; j < digit.length; j++) {
				// 3, 6, 9 포함되는 경우 > cnt up
				if (digit[j] == '3' || digit[j] == '6' || digit[j] == '9') {
					cnt++;
				}
			}
//			System.out.print(i + "cnt: " + cnt + "\n");
			
			// 출력할 결과값으로 대체
			String res = "";

			if (cnt > 0) { // 박수가 1개 이상 있으면
				// 박수 횟수 저장
				for (int k = 0; k < cnt; k++) {
					res += "-"; // 박수갯수만큼 - 추가해서 리턴
				}
			} else {
				res = Integer.toString(i);
			}
			
			System.out.print(res + " ");

		} // N분석
		
		sc.close();
	}
}
