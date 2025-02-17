
/**
 * 도서 정보를 나타내는 클래스
 */
// 1. 클래스 생성
public class Book {
	String isbn;
	String title; 
	String author;
	String publisher;
	int price;
	String desc;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	// 2. 정보를 문자열로 리턴하는 메소드
	public String toString() {
		String str = "";
		str = String.format("%s | %-10s | %-5s | %-7s | %-15d | %s", isbn, title, author, publisher, price, desc);
		return str;	
	}
}

