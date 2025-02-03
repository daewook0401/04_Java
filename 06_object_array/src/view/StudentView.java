package view;

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
			System.out.println("8. 학생 삭제");
			System.out.println("9. 전체 삭제");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");	
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 내용 모두 제거
			
			System.out.println();
			
			switch(input) {
			case 1: addStudent(); break;
			case 2: allStudent(); break;
			case 3: selectIndex(); break;
			case 4: selectName(); break;
			case 5: updateIndex(); break;
			case 6: selectScore();break;
			case 7: selectMaxMin();break;
			case 8: deleteStudent();break;
			case 9: deleteAll(); break;
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
	
	/** 학생 추가 view 메서드
	 * <pre>
	 * 	학번, 이름, 성별을 입력 받아 
	 * 	StudentDto 객체로 만들어서 
	 * 	StudentService.addStudent() 메서드에 전달
	 * 	-> 추가 성공 시 true, 실패 시 false 반환 받아
	 * 		 결과 출력
	 * </pre>
	 */
	private void addStudent() {
		
		System.out.println("\n----학생추가----\n");
		
		// 학번, 이름, 성별 입력 받기
		System.out.print("학번 : ");
		String studentNumber = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		// StudentDTO 객체 생성하기
		StudentDTO student = new StudentDTO(studentNumber, name, gender);
		
		// 생성된 StudentDTO 객체를
		// StudentService.addStudent() 메서드에 전달
		// -> true/false 결과 반환 예정
		boolean result = service.addStudent(student);
		if(result) {
			System.out.println(name + "학생이 추가 되었습니다.\n");
		} else {
			System.out.println("더 이상 학생을 추가할 수 없습니다. \n");
		}
	}
	
	/** 학생 1명 정보 조회(인덱스) view 메서드
	 * <pre>
	 * - 인덱스를 입력 받아 
	 * StudentService.selectIndex()로 전달 
	 * 
	 * - 학생 객체 배열에서 해당 index 번째 학생을 반환 받기
	 * 
	 * - 반환 받은 학생 정보를 출력 
	 * 	 단, 반환 받은 학생이 없을 경우(null)
	 * 	 "해당 인덱스에 학생이 존재하지 않습니다" 출력
	 * </pre>
	 */
	private void selectIndex() {
		System.out.println("\n----학생 1명 정보 조회(인덱스)----\n");
		
		System.out.print("조회 할 인덱스 입력 : ");
		int index = sc.nextInt();
		
		// StudentService.selectIndex()로 index 전달 
		// -> 학생 객체 배열에서 해당 index 번째 학생을 반환 받기 
		StudentDTO student = service.selectIndex(index);
		
		if(student == null) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
			
		} else {
			System.out.println(index + "번째 학생 정보");
			System.out.println(student.toString());
		}
	}
	
	private void selectName() {
		System.out.println("\n----학생 1명 정보 조회(이름)----\n");
		
		System.out.print("조회 할 이름 입력 : ");
		String targetName = sc.next();
		
		StudentDTO student = service.selectName(targetName);
		
		if(student == null) {
			System.out.println(targetName + "학생은 존재하지 않습니다");
			
		} else {
			System.out.println(targetName + " 학생 정보");
			System.out.println(student.toString());
		}
	}
	
	private void updateIndex() {
		System.out.println("\n----학생 정보 수정(인덱스)----\n");
		
		System.out.print("수정할 학생 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		switch(service.checkIndex(index)) {
		case 1 : System.out.println("인덱스 범위가 올바르지 않습니다."); return;
		case 2 : System.out.println("해당 인덱스에 학생이 존재하지 않습니다."); return;
		case 3 : 
			System.out.print("HTML, CSS, JS, Java 순서 점수 입력 : ");
			int HTML = sc.nextInt();
			int CSS = sc.nextInt();
			int JS = sc.nextInt();
			int Java = sc.nextInt();
			service.updateScore(index, HTML, CSS, JS, Java);
			
			System.out.println("***점수 수정 완료***");
		break;
		default : 
		}
	}
	
	private void selectScore() {
		System.out.println("\n----학생 점수 확인----\n");
		
		System.out.print("확인할 학생 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		switch(service.checkIndex(index)) {
		case 1 : System.out.println("인덱스 범위가 올바르지 않습니다."); return;
		case 2 : System.out.println("해당 인덱스에 학생이 존재하지 않습니다."); return;
		case 3 : 

			StudentDTO student = service.selectIndex(index);
			int sum = 0;
			double avg = 0;
			
			sum +=student.getHtml();
			sum +=student.getCss();
			sum +=student.getJs();
			sum +=student.getJava();
			avg = sum/4.0;
			
			System.out.println(student.toString());
			System.out.println("합계 : " + sum);
			System.out.printf("평균 : %.1f", avg);
			
			
		break;
		default : 
		}
	}
	
	/** 평균 최고점, 최저점 학생
	 * <pre>
	 * String StudentService.selectMaxMin() 메서드를 호출하여
	 * 아래와 같은 문자열을 반환 받아 출력하기
	 * 
	 * ----------------------
	 * 최고점 : 유리(85.4)
	 * 최저점 : 짱구(31.6)
	 * ----------------------
	 * </pre>
	 */
	private void selectMaxMin() {
		System.out.println("\n----평균 최고점, 최저점 학생----\n");
		String result = service.selectMaxMin();
		
		System.out.println("----------------------");
		System.out.println(result);
		System.out.println("----------------------");
	}
	
	private void deleteStudent() {
		System.out.println("\n----삭제할 학생 인덱스----\n");
		
		System.out.print("삭제할 학생 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		switch(service.checkIndex(index)) {
		case 1 : System.out.println("인덱스 범위가 올바르지 않습니다."); return;
		case 2 : System.out.println("해당 인덱스에 학생이 존재하지 않습니다."); return;
		case 3 : 
			System.out.print("정말로 삭제 하시겠습니까? 예 - y / n : ");
			String answer = sc.next();
			if (!answer.equalsIgnoreCase("y")) {
				break;
			}
			String studentName = service.deleteStudent(index);
			System.out.println(studentName + " 학생이 삭제 되었습니다.");
		break;
		default : 
		}
	}
	
	private void deleteAll() {
		service.deleteAll();
		System.out.println("전체 삭제 되었습니다.");
	}
	
}
