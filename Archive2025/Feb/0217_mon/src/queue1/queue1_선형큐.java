package queue1;

public class queue1_선형큐 {

	public static int[] queue = new int[10]; // 10개 배열을 큐로 쓰기
	// 둘다 -1에서 시작 (front == rear면 큐 빈거)
	public static int front = -1, rear = -1; // 데이터 삭제 위치, 삽입 위치

	public static void main(String[] args) {
		
	}
	
	// 삽입
	public static void enQueue(int item) {
		// 포화인지 검사
		if (isFull()) {
			System.out.println("큐 다 찼다잉");
		}
		// 포화아니면 rear 증가시키고 거기에 값 넣기
		queue[++rear] = item;
	}
	
	// 삭제 - 반환타입은 필수인가? 무조건 있어야댐 // 없으면 peek 있으니까
	public static int deQueue() {
		// 공백인지 검사
		if (isEmpty()) {
			System.out.println("비어있다잉");
		}
		// 공백이면 front에 있는 값 제거하고 front 올리기
		return queue[front++];
	}
	
	// 공백
	public static boolean isEmpty() {
		return front == rear; 
	}
	
	// 포화
	public static boolean isFull() {
		return rear == queue.length - 1;
	}
}

