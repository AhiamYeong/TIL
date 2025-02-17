package queue1;

import java.util.Arrays;

public class queue3_원형큐 {
	public static String[] cQ = new String[5];
	public static int front = 0, rear = 0;
	public static void main(String[] args) {
		System.out.println(enQueue("애옹"));
		System.out.println(enQueue("낄낄"));
		System.out.println(enQueue("흐애애앵"));
		System.out.println(enQueue("뿍빡"));
		
		System.out.println(Arrays.toString(cQ));
		System.out.println(deQueue());
		
//		System.out.println(enQueue("크케케"));

		
		System.out.println(Arrays.toString(cQ));
	}
	
	// 삽입
	public static boolean enQueue(String item) {
		if (isFull()) {
			System.out.println("배불렁");
			return false;
		}
		// rear 증가시킨 후, 그 안에 넣기
		// 근데 회전이 필요하니까 -> 나눗셈 연산 포함
		rear = (rear + 1) % cQ.length;
		cQ[rear] = item;
		return true;
	}
	// 삭제
	public static String deQueue() {
		if (isEmpty()) {
			System.out.println("없엉");
			return null;
		}
		// front 1 증가시키고 값 꺼내야 하는데
		// 원형 배열이니까 5 -> 0으로 돌아가야 하기 때문에 나눗셈 연산 함께
		front = (front + 1) % cQ.length;
		return cQ[front];
	}
	
	// 공백확인 - 선형 큐와 동일 
	public static boolean isEmpty() {
		return front == rear;
	}
	
	// 포화확인 (한 칸 비워두기 -> front와 rear+1이 같은지 확인)
	public static boolean isFull() {
		return front == (rear + 1) % cQ.length;
	}
}
