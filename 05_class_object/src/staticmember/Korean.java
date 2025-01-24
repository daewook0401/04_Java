package staticmember;

public class Korean {
	/* static (정적인, 고정된)
	 * - 고정된 영역(static 메모리 영역)에
	 * 	 모든 객체가 공유할 멤버(필드/메서드)를 생성해서 공유
	 * 
	 * - static이 붙은 멤버는
	 *  [프로그램 실행 시] static 영역에 할당되고
	 *  [프로그램 종료 시] 사라지게 된다
	 */
	
	/* 필드 == 멤버 변수 */
	/* 클래스 변수
	 * - 클래스명.변수명 으로 접근하기 때문에 클래스 변수라고 함
	 * 
	 * - 생성 시기 : 프로그램 실행 시 static 영역에 생성
	 * - 소멸 시기 : 프로그램 종료 시
	 */
	public static int nationalCode=82; //국가코드
	
	/* 인스턴스 변수 
	 * - 생성 시기 : 객체 생성 시
	 * - 소멸 시기 : 객체 소멸 시
	 *   (어떤 변수도 객체를 참조하지 않을 경우
	 *    Heap 메모리 영역의 GC(Garbage Collection)가 메모리 반환)
	 * */
	private String name;// 이름
	private String id; // 주민등록번호
	
	/* 인스턴스 초기화 블럭 : 인스턴스 변수 초기화 목적 */
	{
		System.out.println("객체 생성 시 마다 수행");
		name = "홍길동";
		id = "900101-1234567";
	}
	
	/* 클래스 초기화 블럭 : 클래스 변수 초기화 목적 */
	static {
		System.out.println("프로그램 실행 시 수행");
		nationalCode = 999;
		// 인스턴스 변수는 초기화 불가능
	}
	

	
	
	
	
	/* 기본 생성자 */
	public Korean() {

	}
	
	public Korean(String name, String id) {
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public int getNationalCode() {
		return nationalCode;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setNationalCode(int nationalCode) {
		this.nationalCode=nationalCode;
	}
	
	
	public String toString() {

		return String.format("이름 : %s / 주민등록번호 : %s / 국가코드 : %d", name, id, nationalCode);
	}
}
