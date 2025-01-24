package abstraction;

public class AbstractionRun {

	public static void main(String[] args) {
		Student std = new Student();
		
		// std 참조형 변수가 참조하는 객체의 필드 값 세팅
		std.setName("철수");
		std.setStudentNumber("20250001");
		std.setHtml(100);
		std.setCss(70);
		std.setJs(80);
		std.setJava(30);
		
		// 합계 출력하기
		System.out.println(std.getName() + "의 점수 합계 : " + std.getSum());
		
		Student std2 = new Student();
		std2.setName("훈이");
		std2.setStudentNumber("20250003");
		std2.setHtml(60);
		std2.setCss(60);
		std2.setJs(65);
		std2.setJava(70);
		
		String result2 = std2.toString();
		System.out.println(result2);
	}
}
