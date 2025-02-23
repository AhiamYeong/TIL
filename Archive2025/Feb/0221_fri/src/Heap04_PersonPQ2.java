import java.util.Comparator;
import java.util.PriorityQueue;

//얘와 쟤
class Person {
	String name;
	int age;

	public Person() {
		this("김싸피", 13);
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}// Person

public class Heap04_PersonPQ2 {

	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>(new NameComparator());
//		PriorityQueue<Person> pq = new PriorityQueue<>(new AgeComparator());
		
		//익명 클래스의 정의도 가넝
//		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
//
//			//나이순
//			@Override
//			public int compare(Person o1, Person o2) {
//				//동명이인이라면.. 나이순으로 
//				//나이가 같다면 이름순으로..
//				return o2.age - o1.age;
//			}
//		});

		//람다표현식 :  함수를 간결하게 표현한것 
		//자바에서 함수는 독립적으로 존재할수는 없었음... 
		//문법 : (파라미터) ->  { body }
		//파라미터가 단일이면 () 생략 가능
		//body 단일 문장이면 {} 생략 가능
		PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2)->{
			if(o1.name.equals(o2.name)) {
				return o1.age - o2.age;
			}else {
				return o1.name.compareTo(o2.name);
			}
		});
		
		
		pq.add(new Person("정봉기", 25));
		pq.add(new Person("강건", 38));
		pq.add(new Person("김준영", 26));
		pq.add(new Person("최시영", 16));

		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}

}
