package section01;

public class OuterClass1 {
	
	private int num = 10;
	
	private void test() {
		System.out.println("OuterClass1의 test() 메서드 입니다");
	}
	
	public class InstanceInnerClass{
		public void display() {
			System.out.println("InstanceInnerClass의 display() 메서드");
		}
	}
}
