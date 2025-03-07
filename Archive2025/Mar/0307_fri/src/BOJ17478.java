import java.util.*;

// 호출되어 출력될 때마다 underbar * 4씩 indent
public class BOJ17478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int N = sc.nextInt(); 
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur(3);
		
		sc.close();
	}
	
	static void recur (int N) {
		
		// 1 종료조건
		if (N == 0)
			return;
		if (N == 1) {
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		}
		// 2 기저조건
			
	}
}
