import java.util.PriorityQueue;

public class Heap02_PriorityQueue {
	public static void main(String[] args) {
		//최소힙이 기본이군...
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//비교기준 넣으면 최대힙으로 할수 있어 그런데 몰라!
		//서울9반 이솔빈 훌륭 그자체
		pq.add(-10);
		pq.add(-20);
		pq.add(-15);
		pq.add(-19);
		
		System.out.println(pq);
		System.out.println(-pq.poll());
		System.out.println(-pq.poll());
		System.out.println(-pq.poll());
		System.out.println(-pq.poll());
	}
}
