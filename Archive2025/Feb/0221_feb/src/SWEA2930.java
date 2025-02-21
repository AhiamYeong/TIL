import java.util.Arrays;
import java.util.Scanner;

public class SWEA2930 {
	// 마지막으로 동기화된 size return
	// 삽입 시마다 데이터 정렬
	static class Heap { // 인스턴스별로 배열, size 모두 관리하기 위해 이너클래스로 분리
		 private static int[] heap;
		 private static int size;
		 
		 // 생성자에서 heap size 조절
		 public Heap(int size) {
			heap = new int[size+1]; //1-based idx 사용 위함
			this.size = 0;
		 } // 생성자
		 
		 public void pushMaxHeap(int ele) {
			// 힙의 마지막에 새 원소 삽입
			heap[++size] = ele; 
			
			// heap 정렬 (교환)
			int child = size; // 새 원소 삽입한 위치를 idx로 저장
			int parent = child / 2; // idx 기반으로 부모 노드 위치 찾기 
			
			// 부모가 항상 커야 함 -> 자식이 더 크면 swap 
			// arr[1]부터 arr[size]까지 채워져 있음 / 1까지만 확인
			while (heap[child] > heap[parent] && parent > 0) {
				int tmp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = tmp;
				
				// 교환 이루어졌으면 idx 교체
				child = parent;
				parent = child / 2;
			}
		}
		 
		public int popMaxHeap() {
			// 이미 정렬됨 - root node 삭제
			if (size == 0) return -1;
			
			int maxVal = heap[1]; // root node가 최댓값
			// 정렬 수행 - (마지막 원소 -> root로)
			heap[1] = heap[size--]; // 마지막 원소 -> 1번 자리로 교체
//			size--; 
			int parent = 1; // 부모 & 자식 간 비교 
			// 자식 선택 
			int child = parent * 2;
			// 바꿀 자식 - 왼쪽 & 오른쪽 중 더 큰 값 선택
			// 오른쪽 자식이 있고 & 오른쪽 자식이 더 크다면 선택
			if (child+1 <= size && heap[child+1] > heap[child])
				child += 1;
			
			// size over하지 않으면서, 자식이 더 크다면 swap
			while (child <= size && heap[parent] < heap[child]) {
				int tmp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = tmp;
				parent = child; // idx 내리고 다시 세팅
				child = parent * 2;
				if (child + 1 <= size && heap[child+1] > heap[child]) child += 1;
			}
			
			return maxVal;
		}
	} // inner class
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // tc
		for (int tc=1; tc <= T; tc++) {
			// max heap이 비어있을 때 삽입 / 삭제 연산 수행
			int N = sc.nextInt(); // 수행할 연산 수 
			Heap h = new Heap(100); // 기본 heap 생성
			
			StringBuilder sb = new StringBuilder(); 
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			
			// 수행하는 연산 정보 - 1: 1개, 2: 2개 
			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt(); // 명령어
				if (cmd == 1) {
					// 입력 1개 더
					int ele = sc.nextInt(); // 삽입할 원소
					// 원소 삽입 수행 후 size 업데이트
					h.pushMaxHeap(ele);
				} else {
					int val = 0; 
					// 원소 삭제 수행 후 size 업데이트
					val = h.popMaxHeap();
					sb.append(val);
					sb.append(" ");
				}
			} // 연산

			System.out.println(sb);
			
		} // tc
		sc.close();
	} // main
	
}
