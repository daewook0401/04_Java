package encapsulation;


public class EncapsulationRun {
	public static void main(String[] args) {
		Person person1 = new Person();
		person1.setName("홍길동");
		person1.setHeight(180.5);
		Person person2 = new Person();
		person2.setName("김미영");
		person2.setHeight(-160.7);
		// 캡슐화 안했을 때 문제점 (1)
		// -> 잘못된 데이터가 대입될 수 있다.
		System.out.println(person1.getInfo());
		System.out.println(person2.getInfo());
	}
}
