package service;

import java.util.Scanner;

public class ArrayService1 {

	/* 배열
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * 
	 * - 생성 시 Heap 메모리 영역에 할당
	 * 
	 * - 주소를 참조해서 배열 요소 접근 가능
	 */
	
	/**
	 * Java에서 배열 선언, 할당, 초기화 하는 방법
	 */
	public void method1() {
		
		// (참고)
		int num;
		// int 자료형을 저장하기 위한 공간(변수)을 메모리에 할당하고
		// 해당 공간의 이름을 num 이라고 지정
		// -> 실제 정수 값을 저장
		//    (실제 값을 저장할 수 있는 자료형은 기본 자료형 밖에 없다.)
		// 배열 선언 : 배열을 참조할 변수 생성
		int[] arr;
		
		
		// int[] 자료형을 저장하기 위한 공간(변수)을 메모리에 할당하고
		// 해당 공간의 이름을 num 이라고 지정 
		// -> 배열이 존재하는 위치(주소) 저장 가능
		// (주소를 저장하는 변수를 "참조형 변수"라고 한다.
		
		
		/* 배열 할당 */
		arr = new int[4];
		// new : Heap 메모리 영역에 객체/배열을 생성(할당)하는 연산자
		// -> 생성 완료 후 생성된 객체/배열의 시작 주소를 반환
		
		// int[4] : int형 변수 4개 묶인 배열 할당
		// - Heap메모리 영역은 빈칸으로 존재 불가
		// -> JVAM이 자료형별 기본값으로 초기화함.
		
		// arr = new int[4];
		// -> Heap 메모리 영역에 생성된 int 4칸짜리 배열의
		//    시작 주소를 arr 참조형 변수에 대입
		
		/* 배열 요소 접근하기 */
		
		// 1) JVA이 기본값으로 초기화 했는지 확인]
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		
		//-------------------------------------------
		
		// 배열 모든 요소에 값 대입 
		
		// 1) 각각 접근 
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		System.out.println("-------------------------------------------");
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		
		// 2) for문 이용
		System.out.println("-------------------------------------------");
		for(int i=0;i<arr.length;i++) {
			arr[i]=(i+1)*100;
			
		}
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
	}
	/**
	 * 선언과 동시에 할당 + 초기화
	 */
	public void method2() {
		// JS -> const arr = [1,2,3];
		
		int[] arr = {10,20,30}; // Java는 {} 사용
		for(int num : arr) {
			System.out.println(num);
		}
	}
	
	/**
	 * 오늘의 점심 메뉴 뽑기
	 */
	public void method3() {
		String[] menus = {"순대국","닭갈비","마라탕","햄버거","짜장면","짬뽕","포케","샐러드"};
		
		//0 ~ 배열 길이 -1 사이의 난수 발생
		int randomNumber = (int)(Math.random()*menus.length);
		
		System.out.println("오늘의 점심 메뉴는 : " + menus[randomNumber]);
	}
	
	/**
	 * Java 배열 사용 시 주의할 점
	 */
	public void method4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[입력 받은 정수를 각 배열 요소에 저장, 출력]");
		
		long[] arr = new long[3];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d] 값 입력 : ", i);
			arr[i] = sc.nextLong();
		}
		for(long i : arr) {
			System.out.println(i);
		}
		
		/* 배열 실이 이상의 index에 접근하는 경우 */
		
		arr[3] = 3;
		// (배열 인덱스 범위 초과 예외)
		System.out.println(arr[3]);
		
		
	}
	
	/**
	 * 인원 수를 입력 받아 그 크기를 가지는 정수 배열을 선언, 할당하고 
	 * 
	 * 각 배열 요소에 점수를 입력 받아 저장.
	 * 
	 * 입력이 완료되면 합계, 평균, 최대값, 최소값 출력하기
	 */
	public void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 인원 수 : ");
		int size = sc.nextInt();
		
		int [] scoreArr = new int[size];
		int sum = 0;
		int min = 100;
		int max = 0;
		for(int i=0;i<size;i++) {
			System.out.printf("%d번째 인덱스 점수 입력 : ", i);
			scoreArr[i] = sc.nextInt();
			sum+=scoreArr[i];
			if (scoreArr[i]<min) {
				min = scoreArr[i];
			}
			if (scoreArr[i]>max) {
				max = scoreArr[i];
			}
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (double)sum/scoreArr.length);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
