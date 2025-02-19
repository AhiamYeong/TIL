import java.util.LinkedList;
import java.util.Scanner;

public class SWEA1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// tc 10개
		for (int tc = 1; tc <= 10; tc++) {
			// 암호문 N개 -> N개만큼 가지는 linked list
			int N = sc.nextInt(); // 암호문 총 개수
			
			// 원본 암호문 뭉치
			LinkedList<Integer> list = new LinkedList<>();
			// N개만큼의 원소 추가 - 앞부터 
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt()); // 이거 됨??
			}
			
			// 명령어 3개별로 인자 다름 
			// I - x(삽입 idx) y(삽입 개수) s (덧붙일 암호문 y개)
			// D - x(삭제 idx) y(삭제 개수)
			// A - 맨 뒤, y(삽입 개수) s (덧붙일 암호문들)
			int cmdNum = sc.nextInt();
			for (int i = 0; i < cmdNum; i++) {
				// 명령어 - str로 공백 전까지 1개만 입력받기
				char cmd = sc.next().charAt(0);
				// x, y를 반복문의 앞으로 빼도 되나?
				int x = sc.nextInt();
				
				if (cmd == 'I') { // 입력 3개 연속해서 사용
					int y = sc.nextInt();
					// x번째 idx 뒤에 y개 삽입
					// y회 덧붙이기
					for (int j = 0; j < y; j++) {
						list.add(x, sc.nextInt()); // x+1 idx에 넣기?
						x++;
					}
				} else if (cmd == 'D') { // 입력 2개 연속해서 사용
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.remove(x);
						x++;
					}
					
				} else { // 입력 2개 연속해서 사용
					for (int j = 0; j < x; j++) { // x가 먼저 들어오니까
						list.addLast(sc.nextInt());
					}
				}
			} // cmd
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			
		} // tc
		sc.close();
	}
}
