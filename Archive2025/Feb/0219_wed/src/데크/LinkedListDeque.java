package 데크;

// 제네릭으로만들어보쟈
public class LinkedListDeque<T> {
	// 내부에 Node를 정의해서 사용하장 뺴지말고
	private class Node{
		T data; // type
		Node prev;
		Node next;
		Node(T data){
			this.data = data;
		}
	} // Node class 정의
	
	//  양쪽방향에서 입출하므로 포인터 2개 필요
	private Node front; 
	private Node rear;
	private int size;
	
	// 공백 확인
	public boolean isEmpty(){
		return size == 0;
	}
	
	// 개수 반환
	public int size() {
		return size;
	}
	
	// 앞에 새 원소 ㅊ ㅜ가
	public void addFirst(T item) {
		Node node = new Node(item);
		if (isEmpty()) {
			// 공백상태면 front, rear 모두 node
			front = node;
			rear = node;
		} else { // 앞에다가 추가한거니까 - 앞뒤연결
			node.next = front;
			front.prev = node;
			front = node;
		}
		size++;
	}
	
	// 뒤에 새 원소 추가
	public void addLast(T item) {
		Node node = new Node(item);
		if (isEmpty()) {
			// addfirst 호출해도 ok
			front = node;
			rear = node;
		} else {
			rear.next = node;
			node.prev = rear;
			rear = node;
		}
		size++;
	}
	
	// 앞쪽 노드 삭제 
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		T data = front.data;
		if (size == 1) { // 1개 지우면 덱 비게 되므로
			front = null;
			rear = null; 
		} else {
			front = front.next; // front 포인터 다음으로 넘기기
			front.prev = null; // 이전 연결값 삭제하기
		}
		size--;
		return data;
	}
	
	public T removeLast() {
		if (isEmpty()) return null;
		
		T data = rear.data;
		if (size == 1) front = rear = null;
		else {
			// rear 연결 끊어주기 
			rear = rear.prev;
			rear.next = null;
		}
		size--;
		return data;
	}
	
	// peek
	public T peekFirst() {
		if (isEmpty()) return null;
		return front.data;
	}
	
	public T peekLast() {
		if (isEmpty()) return null;
		return rear.data;
	}
}
