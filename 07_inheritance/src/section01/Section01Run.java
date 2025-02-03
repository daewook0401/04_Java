package section01;

public class Section01Run {
	public static void main(String[] args) {
		
		// 부모 객체 생성
		Parent p1 = new Parent();
		System.out.println("Parent의 toString() : " + p1.toString());
		System.out.println("=====================================");
		
		// Child1 객체 생성
		Child1 c1 = new Child1();
		System.out.println("Child1의 toString() : " + c1.toString());
		System.out.println("Child1 막의 필드 laptop : " + c1.getLaptop());
		
		System.out.println("=====================================");
		Child2 c2 = new Child2();
		System.out.println("Child1의 toString() : " + c2.toString());
		System.out.println("Child2 막의 필드 Car : " + c2.getCar());
		System.out.println("=====================================");
		
		System.out.println("=====================================");
		Child3 c3 = new Child3();
		System.out.println("Child1의 toString() : " + c3.toString());
		System.out.println("Child3 막의 필드 bitCoin : " + c3.getBitCoin());
		
		
		
		
		
		
	}
}
