package 이중연결리스트;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	// 첫 원소를 가리키는 head idx,
	// 마지막 원소를 가리키는 tail idx -> 꼭 필요한가?  tail 옆에 붙이면 되니까...

	// 조회 
	public Node get(int idx) {
		if (idx < 0 || idx >= size) {
			// 예외처리 
			return null;
		}
		Node curr; // 지역변수 -> 무조건 초기화 1회는 해야 사용가능 
		
		// 앞부터 찾기 -> 사이즈 반보다 작을때는 앞부터 찾는게 빠름 
		if (idx < size/2) {
			curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.next;
			}
		}
		
		// 뒤부터 찾기
		else {
			curr = tail;
			// 조건식 계산 - 0부터 00회 돌리기?
			for (int i = size-1; i > idx; i--) {
				curr = curr.prev;
			}
		}
		return curr;

	}
	
	// 첫 번째 위치 삽입
	public void addFirst(String data) {
		Node node = new Node(data);
		node.next = head; // 새로 만든 노드를 head로 연결
		if (head != null) { // 첫 번째가 아님
			head.prev = node;
		}
		head = node; // pointer 옮기기 
		size++; // 추가했으니까 
		
		// 사이즈가 1개뿐이라면
		if(head.next == null) {
			tail = head; // tail에 대한 관리 -> 안 쓰면 꼬인당
		}
	}
	
	// 마지막 위치에 삽입
	public void addLast(String data) {
		Node node = new Node(data);
		// 사이즈가 0이라면 걍 새로 만드는거니까
		if (size == 0) {
			addFirst(data);
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		size++;
	}
	
	// 중간위치 삽입
	public void add(int idx, String data) {
		if (idx < 0 || idx > size) return;
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		} 
		Node prev = get(idx - 1); // 삽입할 이전 위치 가져오기
		Node next = prev.next; // idx로 가져오면 2번 순회해야 하므로
		Node node = new Node(data);
		
		prev.next = node;
		node.prev = prev;
		
		node.next = next;
		next.prev = node;
		size++;
	}
	
	// 첫 번째 위치 삭제
	public String remove() {
		if (head == null) { // size == 0
			return null;
		}
		
		String data = head.data;
		Node nextNode = head.next;
		if (nextNode != null) { // size가 1아님
			nextNode.prev = null; // head와의 연결 끊기 
		}
		head = nextNode; // head 위치 변경 
		size--;
		
		if(size == 0) { // 빈 리스트 - tail 역시도 관리해줘야 함
			tail = null; 
		}
		return data;
	}
	
	// 중간노드 삭제
	public String remove(int idx) {
		// 등호 생김!!! 
		if (idx >= size || idx < 0) return null; //예외
		if (idx == 0) return remove();
		Node prevNode = get(idx - 1);
//		Node rmNode = prevNode.next;
		Node nextNode = prevNode.next.next;
		// 이전, 이후 알고있으면 편함
		
		String data = prevNode.next.data;
		if (nextNode != null) { 
			nextNode.prev = prevNode;
			prevNode.next = nextNode;
		} else { // next가 null이라면? 마지막 idx를 지운다는 뜻?
			prevNode.next = null;
			tail = prevNode;
		}
		size--;
		return data;
	}
	
	// 출력
	public void printList() {
		Node curr = head;
		if (head == null) {
			System.out.println("공백");
			return;
		}
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();
	}
}
