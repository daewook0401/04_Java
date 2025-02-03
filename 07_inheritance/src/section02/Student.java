package section02;

/**
 * Person 클래스를 상속 받은 Student 클래스
 */
public class Student extends Person {
	
	private String schoolName;
	
	/* super() 생성자
	 * - super : 극상의, 상위의, 위쪽
	 * 
	 * - 현재 클래스의 상위 클래스(부모) 생성자를 호출하는 구문
	 * 
	 * - super() 생성자는 반드시 자식 생성자의 첫 번째 줄에 작성 되어야 한다.
	 * 	 (미작성 시 컴파일러 자동 추가)
	 */
	public Student() {
		super(); // 부모 기본 생성자
		System.out.println("[Student 기본 생성자로 생성됨]");
	}
	
	//매개 변수가 있는 생성자
	// -> Student가 가지고 있는 모든 필드(shcoolName, name, age) 초기화
	public Student(String name, int age, String schoolName) {
		// setName(name);
		// setAge(age);
		super(name, age);
		System.out.println("[Student 매개 변수가 있는 생성자로 생성됨]");
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String toString() {
		return String.format("name : %s / age : %d / schoolName : %s", getName(), getAge(), schoolName);
	}
}
