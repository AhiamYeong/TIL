import 단일리스트.SinglyLinkedList;

public class LinkedList02_단일연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst("ㅇㅇㅇ");
		list.printList();
		list.addFirst("ㅇㅇㅇㄹㅇ");
		list.addLast("뿌뀨");
		list.printList();

	}
}
