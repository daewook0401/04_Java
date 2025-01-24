package staticmember;

public class StaticMamberRun {
	public static void main(String[] args) {
		
		System.out.println("korean.nationalCode : " + Korean.nationalCode);
		
		/* 아래있는 코드가 수행되기 전
		 * 이미 static이 붙은 멤버가 static 영역에 
		 * 클래스명.필드명 / 클래스명.메서드명()
		 * 형태로 할당되어 있음
		 */

		
		
		Korean kor1 = new Korean("김철수", "051212-3456789");
		Korean kor2 = new Korean("이미영", "050304-4567891");
		
		// 국가 코드 세팅
		
		System.out.println(kor1.toString());
		System.out.println(kor2.toString());
		
		// 만약 이미 생성된 모든 Korean 객체의
		// nationalCode를 수정 해야되는 경우
//		kor1.setNationalCode(1);
//		kor2.setNationalCode(1);
		
		Korean.nationalCode=1000;
		
		System.out.println(kor1.toString());
		System.out.println(kor2.toString());
		
		
		
		System.out.println("-".repeat(100));
		System.out.println("초기화 블럭 확인");
		
		Korean k3 = new Korean();
		Korean k4 = new Korean();
		System.out.println(k3.toString());
		System.out.println(k4.toString());
	}
}
