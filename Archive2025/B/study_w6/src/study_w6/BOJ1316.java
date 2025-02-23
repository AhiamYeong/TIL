package study_w6;

import java.util.Scanner;

public class BOJ1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0; 
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			char[] strArr = new char[str.length()];
			for(int st = 0; st < str.length(); st++) {
				strArr[st] = str.charAt(st);
			} // input
			
			// 각 문자가 연속해서 나타나는 경우
			// 기존에 등장한 단어가 연속하지 않고 등장하면 false
			boolean isGroupNum = true; 
			for (int k = 0; i < strArr.length; i++) {
				
			}
			
			if (isGroupNum) cnt++;
			
		} // case
		
		System.out.println(cnt);
		
		sc.close();
	}
}
