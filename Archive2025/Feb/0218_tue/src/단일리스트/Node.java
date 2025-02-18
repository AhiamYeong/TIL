package 단일리스트;

// 데이터 필드, 링크(다음)필드
public class Node {
	// 데이터 필드를 String으로 고정헀지만 generic으로 처리해도 됨 
	public String data;
	public Node link; 
	// class가 node인데, 여기에도 node가 온다? 
	// 그냥 이게 와야해~ 라고 명시해둔 것. 
	
	// 기본생성자는 습관적으로 만들기 
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(String data) {
		this.data = data;
//		this.link = null; // 이거 필요한 라인? 
		// 참조자료형은 기본적으로 null로 초기화됨 - 굳이 작성하지 않아도 됨
	}
}
