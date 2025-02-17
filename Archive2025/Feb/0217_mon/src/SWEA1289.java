import java.util.Scanner;

public class SWEA1289 {
	public static void main(String[] args) {
		// 원재의 메모리 복구하기
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // tc
		
		for (int tc = 1; tc <= T; tc++) {
			// 메모리 길이 바로 받음 > str로 받아서 int로 변경
			String str = sc.next();
			
			int cnt = 0; // 변경 횟수
			int[] initArr = new int[str.length()]; // 초기화 배열 (수정용)
			
			// 초기화 배열과 str 비교하며, 다른 부분의 idx 찾아내기
			for (int i = 0; i < str.length(); i++) {
				// i번째 
				char ch = str.charAt(i);
				int num = ch - '0'; //문자열 0을 빼서 num에 ascii값 저장
				
				// 앞에서부터 값 하나씩 비교해서 다른 값 찾아내기
				if (initArr[i] != num) {
					// 값이 다르면 맨 뒤까지 싹 뒤집기
					for(int j = i; j < str.length(); j++) {
						initArr[j] = num;
					} // initArr 돌리기
					cnt++; // 돌릴 때마다 cnt up
				}
			}

			System.out.println("#" + tc + " " + cnt);

		} // tc
		
		sc.close();
	}
}
