package LinkedStack;

public class LinkedStack {
	public Node top;  // pointer 변수가 1개 필요 -> 기존 stack의 top처럼
	// 삽입, 삭제, 조회 연산 구현
	public void push(int data) {
		Node node = new Node(data); // 새 노드 생성
		// 데이터 눌러야 됨 
		node.link = top; // top이 가리키는 주소 넣기 
		top = node;
	}
	
	public LinkedStack() {
		// TODO Auto-generated constructor stub
	}
	
	// 삭제
	public int pop() {
		if (top == null) {
			// 공백스택임
			return -1; // 문제 범위 고려해서 쓰기 ㅑ
		}
		int data = top.data; //데이터 건지긔
		top = top.link; // 내려가라~ 하면 데이터 못 건지고 버리느,ㄴ거야
		return data; //반환
	}
	
	public int peek() {
		if (top == null) return -1;
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
