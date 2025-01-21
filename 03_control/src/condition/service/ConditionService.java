package condition.service;

import java.util.Scanner;
/**
 * 기능(예제, 연습문제) 제공용 서비스
 */
public class ConditionService {
	
	// 필드(field) == 멤버 변수 == 인스턴스 변수
	// 해당 클래스(객체) 내에서 언제, 어디서든지 사용 가능한 변수 
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 1 ~ 10 사이 난수(정수)가
	 * 짝수인지 홀수인지 검사
	 */
	public void method1() {
		
		// Math.random() : 0.0 이상 1.0 미만 난수 발생
		int randomNumber = (int)(Math.random() * 10 + 1);
		
		// 2로 나눴을 때 나머지가 0인지 아닌지 결과를 저장
		// == 0 이면 짝수(true), 1 이면 홀수(false)
		boolean result = randomNumber % 2 == 0;
		
		System.out.println("randomNumber : "+randomNumber);
		// 조건식 : 결과가 true 또는 false가 되는 식
		if(result) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");
		}
	}
	
	/**
	 * 나이를 입력 받아 "어린이", "청소년", "성인" 구분
	 * <pre>
	 * 13세 이하 "어린이"
	 * 14세 이상 19세 이하 "청소년"
	 * 20세 이상 "성인"
	 * </pre>
	 */
	public void method2() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		// if -else if - else 이용
		if(age >= 20) {
			System.out.println("성인");
		} else if(age>=14) {
			System.out.println("청소년");
		} else {
			System.out.println("어린이");
		}
	}
	
	/**
	 * 나이를 입력 받아 구분하기
	 * <pre>
	 * 13세 이하 "어린이"
	 * 14세 이상 19세 이하 "청소년"
	 *  - 14 ~ 16세 : 청소년(중)
	 *  - 17 ~ 19세 : 청소년(고)
	 * 20세 이상 "성인"
	 * 0 미만 100 이상 : "잘못 입력하셨습니다."
	 * </pre>
	 */
	public void method3() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		boolean col = (age<0 || age>=100);
		String result = (col ? "잘못 입력하셨습니다." : (age>=20 ? "성인" : (age>=17 ? "청소년(고)" : (age>=14 ? "청소년(중)" : "어린이")))) ;
		System.out.println(result);
	}
	
	/**
	 * ConditionService에 작성된 메서드를 골라서 실행하는 메서드
	 */
	public void displayMenu() {
		
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		
		System.out.print("메뉴 번호 입력 >> ");
		int input = sc.nextInt();
		
		// (중요) 같은 클래스 내 필드, 메서드는 이름만 부르면 호출 가능
		switch(input) {
		case 1: method1(); break;	
		case 2: method2(); break;	
		case 3: method3(); break;	
		default : System.out.println("없는 메뉴 번호 입니다.");
		}
	}
	
	/** [성적 판별기]
	 * <pre>
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * 
	 * - 중간고사 (40%), 기말고사(50%), 과제(10%)
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95점 이상 : A+
	 * 90점 이상 : A
	 * 85점 이상 : B+
	 * 80점 이상 : B
	 * 75점 이상 : C+
	 * 70점 이상 : C
	 * 65점 이상 : D+
	 * 60점 이상 : D
	 * 나머지    : F
	 * 
	 * 
	 * [실행 화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제 점수(10%) : 50
	 * 
	 * 홍길동의 최종 점수 : 85.0점
	 * 성적 : B+
	 *</pre>
	 */
	public void testScore() {
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("중간고사 점수(40%) : ");
		double middleTerm = sc.nextDouble();
		
		System.out.print("기말고사 점수(50%) : ");
		double finalTerm = sc.nextDouble();
		
		System.out.print("과제 점수(10%) : ");
		double assignScore = sc.nextDouble();
		
		System.out.println();
		
		double resultScore = (middleTerm * 0.4) + (finalTerm * 0.5) + (assignScore * 0.1);
//		String result = resultScore <60.0 ? "F" : resultScore<65.0 ? "D" : resultScore<70.0 ? "D+" : resultScore<75.0 ? "C" : 
//			resultScore<80.0 ? "C+" : resultScore<85.0 ? "B" : resultScore<90.0 ? "B+" : resultScore<95.0 ? "A" : "A+";
		String result;

		
		switch((int)resultScore/5) {
		case 20, 19:result = "A+"; break;
		case 18 : result = "A"; break;
		case 17 : result = "B+"; break;
		case 16 : result = "B"; break;
		case 15 : result = "C+"; break;
		case 14 : result = "C"; break;
		case 13 : result = "D+"; break;
		case 12 : result = "D"; break;
		default : result = "F";
		}
		System.out.printf("%s의 최종 점수 : %.1f \n", name, resultScore);
		System.out.printf("성적 : %s", result);
	}
}
