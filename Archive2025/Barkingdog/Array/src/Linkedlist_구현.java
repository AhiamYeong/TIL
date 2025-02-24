import java.util.Arrays;

public class Linkedlist_구현 {
	static class Node{
		// NODE가 또 들어감 
		Node prev, next;
		int data;
	}
	
	public static void main(String[] args) {
		// 야매 연결리스트
		final int MX = 10005; // 배열
		int[] dat = new int[MX]; // 데이터 저장
		int[] pre = new int[MX]; // 이전 노드 인덱스
		int[] nxt = new int[MX]; // 다음 노드 인덱스
		
		int unused = 1;
		// 배열 전체를 -1로 초기화
		Arrays.fill(pre, -1);
		Arrays.fill(nxt, -1);
	}
	
	public static void traverse(int[] nxt, int[] dat) {
		int cur = nxt[0];
		while (cur != -1) {
			System.out.println(dat[cur]);
			cur = nxt[cur];
		}
	}
	
	public static void insert(int[] arr, int idx) {
		// idx가 추가할 원소 
	}
	
	
}

