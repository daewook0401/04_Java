package abstraction;

public class ConstructorRun {
	public static void main(String[] args) {
		Student std1 = new Student();
		
		System.out.println(std1.toString());
		
		System.out.println("-".repeat(40));
		Student std2 = new Student("20250004", "맹구");
		System.out.println(std2.toString());
		
		System.out.println("-".repeat(40));
		
		// Student 객체의 필드를 모두 초기화 하는 생성자 이용
		Student std3 = new Student("20250005", "유리", 40, 70, 90, 100);
		System.out.println(std3.toString());
		Student std4 = new Student("20250006", "수지", 100, 100, 100, 100);
		System.out.println(std4.toString());
	}
}
