
package 이중연결리스트;

public class Node {
	public String data;
	public Node prev; //이전 주소
	public Node next; // 다음 주소
	
	public Node(String data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
