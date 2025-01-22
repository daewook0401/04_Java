package loop.service;

import java.util.Scanner;

public class LoopService2 {
	Scanner sc = new Scanner(System.in);
	public void displayMenu() {
		System.out.println("[LoopService2 DisplayMenu]");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		System.out.println("6. method6()");
		System.out.println("7. method7()");
		System.out.println("8. method8()");
		
		System.out.print("실행할 메서드 번호 입력 >> ");
		int input = sc.nextInt();
		
		System.out.println("\n-------------------------\n");
		switch(input) {
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		case 4: method4(); break;
		case 5: method5(); break;
		
		default: System.out.println("없는 번호 입력함");
		}
	}
	/**
	 * 다음 모양 출력하기
	 * <pre>
	 * (0, 0) (0, 1) (0, 2)
	 * (1, 0) (1, 1) (1, 2)
	 * (2, 0) (2, 1) (2, 2)
	 * (3, 0) (3, 1) (3, 2)
	 * </pre>
	 */
	public void method1() {
		for(int i=0; i<4;i++) {
			for (int j=0;j<3;j++) {
				System.out.printf("(%d, %d) ",i,j);
			}
			System.out.println();
		}
	}
	
	public void method2() {
		System.out.print("stop number : ");
		int stop = sc.nextInt();
		
		for(int i=1; i<=20 ; i++) {
			System.out.print(i + " ");
			if (i==stop) {
				break;
			}
		}
		
	}
	
	/**
	 * 입력 받은 수의 배수는 출력 X
	 */
	public void method3() {
		System.out.print("continue number : ");
		int con = sc.nextInt();
		for(int i=1; i<=20 ; i++) {
			if (i % con == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 0이 입력 될 때 까지
	 * 입력된 모든 숫자 합계 구하기
	 */
	public void method4() {
		int sum = 0;
		while(true) {
			System.out.print("수 입력 : ");
			int num = sc.nextInt();
			if (num == 0 ) {
				break;
			}
			sum+=num;
		}
		System.out.print(sum);
	}
	
	/**
	 * do ~ while문
	 * 
	 * - while문의 조건식이 시작이 아닌 마지막 부분으로 이동한 반복문
	 * - 최소 1회 이상의 반복 보장
	 * 
	 * [작성법]
	 * do{
	 * 
	 * }while(조건식);
	 * 
	 */
	public void method5() {
		int sum = 0;
		int input = 0;
		do {
			System.out.print("수 입력 : ");
			input = sc.nextInt();
			sum+=input;
		}
		while(input !=0);
		System.out.print(sum);
	}
}
