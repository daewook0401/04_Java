package section01;

public class OuterClass1 {
	
	private int num = 10;
	
	private void test() {
		System.out.println("OuterClass1의 test() 메서드 입니다");
		System.out.println("num : " + num);
	}
	
	/* 외부 클래스 메서드를 이용해서 내부 클래스 객체 생성
	 * 
	 */
	public void displayMessage() {
		System.out.println("외부 클래스에서 내부 클래스 객체 생성");
		InstanceInnerClass inner = new InstanceInnerClass();
		inner.display();
	}
	
	/* 인스턴스 내부 클래스 정의 == OuterClass1의 멤버 */
	public class InstanceInnerClass{
		public void display() {
			System.out.println("InstanceInnerClass의 display() 메서드");
			num = 300;
			test();
		}
	}
}
