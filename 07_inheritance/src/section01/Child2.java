package section01;

public class Child2 extends Parent {
	
	private String car; // Child2만의 필드
	
	public Child2() {
		System.out.println("*** Child2 객체 생성됨 ***");
		
		setFirstName("바다");
		setAddress("경기도 용인시");
		setMoney(7000);
		car = "아반떼";
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	
}
