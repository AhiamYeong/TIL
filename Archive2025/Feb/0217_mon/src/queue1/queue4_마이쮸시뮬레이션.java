package queue1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue4_마이쮸시뮬레이션 {
	// inner class 정의
	static class Person{
		int number; 
		int cnt; // 받을 마이쮸 개수
		// 전체생성자 하나 만들어두기!
		public Person(int number, int cnt) {
			super();
			this.number = number;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int pNum = 1; // 인간 넘버에 대한 지역변수 초기화
			// 큐가 담아야 하는 정보 -> 사람 번호, 내가 지금 받을 마이쮸 개수
			
			// 자료형이 int로 같기 때문에, [0]번호 [1]마이쮸 개수 약속하는 방법
			// Queue<int[]> queue = new LinkedList<>();
			
			// 더 직관적으로, 클래스 만드는 방법 사용
			// 레벨 올라가면 클래스 정의하는 경우 많을거임
			Queue<Person> queue = new LinkedList<>();
			
			queue.add(new Person(pNum++, 1)); // pNum이 마이쮸 1개 먹기
			// 나눠줄 마이쮸가 있을때까지 노나주기
			while(N > 0) {
				Person p = queue.poll(); // 큐에 있는 사람 뽑기
				N -= p.cnt; // 마이쮸 줬어
				if (N <= 0) {
					//마이쮸 다 줬어 -> 누가 마지막으로 가져간 p의 번호 출력
					ans = p.number;
//					break;
				} else { // 줄 마이쮸 남아있으면
					// p는 호다닥 가서 줄을 다시 서서 받는다
					p.cnt++; // 마이쮸 한 개 더 받아
					queue.add(p);
					// 다음 번호 사람/이 와서 줄을 선다
					queue.add(new Person(pNum++, 1));
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // tc
		
		sc.close();
	} // main
}
