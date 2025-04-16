package day13_패턴매칭;

public class 패턴매칭1_kmp {
	public static void main(String[] args) {
		
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		KMP(text, pattern);
	
	}
	
	// t 본문 p 패턴
	public static void KMP(String t, String p) {
		// 실패함수 필요
		int[] pi = getPi(p); // 점프테이블 
		
		int j = 0; // 패턴 인덱스
		for (int i = 0; i < t.length(); i++) {
			// 1. 다를 때 
			while (j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j-1]; // 점프 (접두/접미사 일치했던 길이 같음??)  
			}
			
			// 2. 같을 때
			if (t.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					System.out.println((i - p.length() + 1) +"패턴 찾았당");
					j = pi[j];
				} else j++;
			}
		} // 본문 순회 반복문 
	}
	
	// pi[]: 패턴 P를 i 인덱스까지 잘라, 접두사/접미사 일치하는 최대길이 저장
	public static int[] getPi (String p) {
		int[] pi = new int[p.length()];
		
		int j = 0;
		// i: 0부터 i까지 부분 문자열 완성
		for (int i = 1; i < p.length(); i++) {
			// i, j가 가리키는 값 다르다면 
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			// 다르면 이전까지 값 확인하기 
			
			// i, j 가리키는 값 같다면
			if (p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
} 
