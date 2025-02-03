package service;

import java.util.Random;

import dto.StudentDTO;

/* Service
 * - 프로그램의 실질적인 기능(비즈니스 로직)을 제공하는 클래스
 */
public class StudentService {
	
	// StudentD TO 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5];
	// StudentDTO 참조형 변수 5칸짜리 배열 생성
	// - 인덱스 : 0 ~ 4
	// - 각 인덱스 요소의 초기값 : null (참조 객체 없음)
	
	/* 기본 생성자 */
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨...]\n");
		
		students[0] = new StudentDTO("202500001", "짱구", '남'); 
		students[1] = new StudentDTO("202500002", "유리", '여'); 
		students[2] = new StudentDTO("202500003", "훈이", '남'); 
	
		Random random = new Random();
		for(StudentDTO std : students)
		{
			if (std == null) {
				continue;
			}
			std.setHtml( random.nextInt(101) );
			std.setCss( random.nextInt(101) );
			std.setJs( random.nextInt(101) );
			std.setJava( random.nextInt(101) );
		}
	}
	
	
	/**
	 * students 객체 배열을 반환하는 메서드
	 * (students에 저장된 주소가 복사되서 반환됨 == 얕은 복사)
	 * @return
	 */
	public StudentDTO[] getStudents() {
		return students;
	}
	
	
	/** 
	 * <pre>
	 * students 객체 배열 요소 중
	 * 비어있는(null) 인덱스를 찾아 
	 * 전달 받은 StudentDTO 객체를 추가 -> true 반환
	 * 단, 비어있는 인덱스가 없으면 false 반환
	 * </pre>
	 * 
	 * @param student : 추가하려는 학생 객체 주소
	 * @return 추가 성공 : true / 추가 실패 : false
	 */
	public boolean addStudent(StudentDTO student) {

		
		// students 객체 배열에서 null인 인덱스 찾기
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				// i 번째 인덱스 요소가 참조하는게 없을 경우
				// 전달 받은 StudentDTO 객체 추가
				students[i] = student;
				return true;
			}
		}
		
		// sturents에 null이 존재하지 않을 경우 == 꽉참
		return false;
	}
	/** index번째 학생 반환 service 메서드
	 * @param index
	 * @return index 번째 학생 객체 참조 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		if(index>=students.length || index <0) {
			return null;
		}
		return students[index];
	}
	
	/** targetName과 이름이 일치하는 학생 객체 반환 service 메서드
	 * @param name
	 * @return
	 */
	public StudentDTO selectName(String targetName) {
		for (StudentDTO sdt : students) {
			if (sdt == null) {
				continue;
			}
			if (sdt.getName().equals(targetName)) {
				return sdt;
			}
		}
		return null;
	}
	
	/** 전달 받은 index가 students 범위 내 인덱스가 맞는지 
	 *  맞다면 index 번째에 참조하는 학생이 있는지 확인하는 메서드
	 * 
	 * @param index
	 * @return 1: 범위 초과 / 2 : null / 3 : 참조하는 학생 있음
	 */
	public int checkIndex(int index) {
		if(index < 0 || index >= students.length) {
			return 1;
		}
		
		if(students[index] == null) {
			return 2;
		}
		
		return 3;
	}
	
	public void updateScore(int index, int HTML, int CSS, int JS, int Java) {
		students[index].setHtml(HTML);
		students[index].setCss(CSS);
		students[index].setJs(JS);
		students[index].setJava(Java);
		return;
	}
	
	public String selectMaxMin() {
		double max=0;
		String maxName = "";
		double min=100;
		String minName = "";
		for(StudentDTO std : students) {
			if (std == null) {
				continue;
			}
			double avg = (std.getHtml() + std.getCss() + std.getJs() + std.getJava())/4.0;
			if (max < avg) {
				max=avg;
				maxName = std.getName();
			}
			if (min> avg) {
				min=avg;
				minName = std.getName();
			}
		}
		return String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)",maxName,max,minName,min);
	}
	
	public String deleteStudent(int index) {
		String name = students[index].getName();
		for(int i = index; i<students.length; i++) {
			if (index==4) {
				students[index] = null;
				break;
			}
			if (i+1 == 5) {
				break;
			}
			students[i]=students[i+1];
			students[i+1]=null;
			
		}
		return name;
	}
	
	public void deleteAll() {
		for(int i=0;i<students.length;i++) {
			if (students[i]==null) {
				continue;
			}
			students[i] = null;
		}
		return;
	}
}
