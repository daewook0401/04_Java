package encapsulation;

// 클래스 : 객체의 속성과 기능을 정의한 문서(설계도)
public class Person {
	/* private 접근 제어자를 이용해 필드 직접 접근 제한 */
//	private String name; //이름
	private String personName; //이름
	private double height; //키
	
	
	/* private으로 접근이 제한된 필드를 간접 접근할 수 있는 public 메서드 */
	public void setName(String name) {
		this.personName = name;
	}
	
	public void setHeight(double height) {
		
		if(height>=0) {
			this.height = height;
		} else {
			this.height = height * -1;
		}
	}
	
	/* Person의 객체 정보를 하나의 문자열로 반환하는 메서드 */
	public String getInfo() {
		return "이름 : " + personName + " / 키 : " + height;
		
	}
	
}
