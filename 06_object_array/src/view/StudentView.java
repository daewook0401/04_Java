package view;

import java.util.Arrays;
import java.util.Scanner;

import dto.StudentDTO;
import service.StudentService;

/* View
 * - 보여지는 용도의 기능(입력/출력)을 담당하는 클래스
 */
public class StudentView {
	// 입력용 객체 생성
	private Scanner sc = new Scanner(System.in);
	
	// 기능 제공용 객체 생성
	private StudentService service = new StudentService();
	
	/**
	 * 학생 관리 프로그램의 메인 메뉴 출력용 메서드
	 */
	public void mainMenu() {
		int input = 0; // 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");	
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 내용 모두 제거
			
			System.out.println();
			
			switch(input) {
			case 1: break;
			case 2: allStudent(); break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
			case 0: System.out.println("*** 프로그램 종료 ***");break;
			default : System.out.println("*** 잘못된 메뉴 번호 입력 ***");
			}
		} while(input !=0);
	}
	/**
	 * 학생 전체 조회
	 */
	private void allStudent() {
		System.out.println("\n---- 학생 전체 조회 ----\n");
		
		// StudentService 객체에서 모든 학생을 저장한 객체 배열을 얻어와
		// 화면에 출력
		
		StudentDTO[] students = service.getStudents();
		System.out.println("3");
		// 향상된 for문
		for(StudentDTO std : students) {
			if (std == null) {
				continue;
			}
			
			/* 참조 변수를
			 * 문자열 만들 때
			 * 또는 print() 관련 메서드에 사용될 때
			 *
			 * 참조 변수에 저장된 주소가 출력되면 이상하니까
			 * 컴파일러가 자동으로 참조변수.toString()을 호출하도록 변경
			 * 
			 */
			System.out.println(std.toString());
			// toString 생략 가능
			// 참조형이 print와 같은 함수에 들어가서 실행되면 자동으로 
			// toString을 찾아서 실행함.
		}
	}
	
}
