package 단일리스트;

public class SinglyLinkedList {
	// head 외부공개할 필요X
	private Node head; // 연결리스트의 시작점
	private int size; 
	
	public SinglyLinkedList(){
		this.head = null;
		this.size = 0;
	}
	
	// 조회 메소드
	public Node get(int idx) {
		// 몇 번째? -> idx가 정상적인지 판단 / 음수 or size보다 큰 경우 올 수 있으므로
		if (idx < 0 || idx >= size) {
			// or, idx < 0이면 그냥 0번인덱스, idx>=size면 마지막인덱스로 판단할 수도 있음 -> 커스텀으로 만들 수 있삼 
			return null; // or 예외 발생 가능 
		}
		Node curr = head; // 얕은복사? curr가 0을 가리키게 되어있음.
		// curr라는 head를 idx번 만큼 타고 넘어가야 하므로 
		for (int i = 0 ; i < idx; i++) {
			curr = curr.link;
			// current (head)가 가리키는 link는 1 (반복문 1회)
			// 1이 가리키는 링크는 2. (반복문 2회)
		}
		return curr; 
	}
	
	// 노드 추가 (첫번째 위치, 마지막 위치, 중간 위치)
	// node를 파라미터로 가지고 있어도 가능 
	public void addFirst(String data) {
		// 1. 새 node 생성
		Node node = new Node(data); 
		// 2. 노드의 링크는 head 
		node.link = head; 
		// 3. head를 새 node에 옮기기 
	}
	
	public void addLast(String data) {
		if (size == 0) {
			// 처음에 넣기 
			addFirst(data);
			return; // 그냥 끝낸다는 의미 / break처럼 
		}
		Node node = new Node(data); 
		// 마지막 link가 null일 때까지 찾아야 함 -> 몇 번 돌릴지 몰라서 while 사용
		Node curr = head; // 마지막 노드 찾을 변수
		
		// size아니까 for문 돌려도 됨 
		while (curr.link != null) {
			curr = curr.link; // 마지막 node 찾을 때까지 링크 타고 넘어가기
		}
		
		curr.link = node;
		size++;
		
	}
	
	public void add(int idx, String data) {
		if (idx < 0 || idx > size) {
			// or 첫 번째 / 마지막에 알아서 추가할 수 있긴 함 
			return; //너무 벗어나면 등록 안할꺼얌
			
		}
		if (idx == size) {
			addLast(data);
			return;
		}
		
		// 삽입하고 싶은 위치의 이전 노드 가져와야 함
//		for (int i = 0; i < idx - 1; i++) {
//			
//		}
		Node prev = get(idx-1); // get함수 이미 만들어놨으니까~
		
		Node node = new Node(data);
		
		// 순서 중요!
		node.link = prev.link; // 중간 노드 손실하지 않기 위해
		// 이전 노드랑 새로 만든 노드랑 같이 가리키게 해야 함
		prev.link = node; // 이전 노드의 다음 노드를 현재 노드로 변경 
		size++;
	}
	
	// 삭제 (1번째 위치, 마지막 위치, 중간 위치)
	public String remove() {
		if (head == null) { // 맨 뒤 노드임 
			// 예외 발생 - 암것도 없으니까
			return null;
		} 
		String data = head.data; // head도 node이니까 - 
		head = head.link;
		size--;
		
		return data;
	}
	// 중간요소 삭제
	public String remove(int idx) {
		if (idx == 0) return remove();
		// 범위 벗어나면 예외처리?
		if (idx < 0 || idx >= size) return null;
		// 삭제 전 요소를 가져와서 삭제 후 요소랑 연결시켜야 하므로
		Node prev = get(idx-1);
		// 지우고 싶은 노드
//		Node rm = get(idx);
		// 근데 생각해보면 또 get 쓰는건 비효율적임!
		Node rm = prev.link;
		
//		String data = rm.data;
		String data = prev.link.data;
		
		prev.link = rm.link;
		prev.link = prev.link.link;
		size--;
		return data;
	}
	
	public void printList() {
		Node curr = head;
		
		if (head == null) {
			System.out.println("공백임 ㅈㅅ");
			return;
		}
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		}
		System.out.println();
	}
}
