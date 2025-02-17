package queue1;

import java.util.LinkedList;
import java.util.Queue;

public class queue2_API {

	public static void main(String[] args) {
		// 큐는 인터페이스! 직접 만들어서 써줘야함
		// linkedlist, arraydeck 등...
		Queue<Integer> q = new LinkedList<>();
		// 보통은 linkedlist로 활용 -> 큐에 있는 것만 접근한다는 의미로 활용
		
		// 추가 -> 초과검사 후 사용하면 상관 X
		q.add(1);
		q.offer(2);
		
		// 삭제 -> 공백검사 후 사용하면 상관 X
		q.remove();
		q.poll();
		
		// 조회
		q.element();
		q.peek();
		
		// add, remove, element: 예외발생
		// offer, poll, peek: 그냥 값을 리턴 
	}

}
