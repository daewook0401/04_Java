package loop.service;

import java.util.Scanner;

/**
 * 반복문 기능 제공 클래스1
 */
public class LoopService1 {
	Scanner sc = new Scanner(System.in);
	public void displayMenu() {
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
		case 5: methodTest5(); break;
		case 6: method6(); break;
		case 7: method7(); break;
		case 8: method8(); break;
		
		
		default: System.out.println("없는 번호 입력함");
		}
	}
	
	/**
	 * for문을 이용해서 1~10까지 세로로 출력하기
	 */
	public void method1() {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * 987654321 출력하기
	 */
	public void method2() {
		for(int i=9; i>0; i--) {
			System.out.print(i);
		}
		
		System.out.println("\n--------------------");
		
		for(int i=0; i<9; i++) {
			System.out.print(9-i);
		}
	}
	
	/**
	 * 두 정수를 입력 받아
	 * 두 정수 사이 모든 정수를 출력
	 * (무조건 첫 번째 입력이 작은 수)
	 */
	public void method3() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		for (int i=num1;i<=num2;i++) {
			System.out.printf("%d ", i);
		}
	}
	
	/**
	 * 입력된 두 정수 사이의 모든 정수 출력
	 * <ul>
	 * 	<li>입력 1이 입력 2보다 작거나 같은 경우 : 1234~증가하며 출력</li>
	 * 	<li>입력 1이 입력 2보다 큰 경우 : 9876~감소하며 출력</li>
	 * </ul>
	 */
	public void method4() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		if (num1<=num2) {
			for(int i=num1;i<=num2;i++) {
				System.out.print(i + " ");
			}
		} else{
			for(int i=num1;i>=num2;i--) {
				System.out.print(i+" ");
			}
		}
		
	}
	/**
	 * 두 정수를 입력 받아
	 * 작은 수 부터 큰 수까지 1씩 증가하면 출력
	 */
	public void method5() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		if(num1>num2) {
			int dump = num2;
			num2 = num1;
			num1 = dump;
		}
		for(int i=num1;i<=num2;i++) {
			System.out.print(i + " ");
		}
	}
	public void methodTest5() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		if (num1>num2) {
			int dump = num2;
			num2 = num1;
			num1 = dump;
		}
		while(num1<=num2) {
			System.out.print(num1 + " ");
			num1++;
		}
	}
	/**
	 * 1부터 100사이의 정수 중
	 * 입력 받은 정수의 배수가 몇개, 배수의 합 구하기
	 */
	public void method6() {
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		
		int set=1;
		
		int count=0;
		int sum=0;
		
		while(set<=100) {
			if(set%num1 == 0) {
				count++;
				sum+=set;
			}
			set++;
		}
		System.out.println("갯수 : " + count);
		System.out.println("합계 : " + sum);
		
	}
	
	/**
	 * 입력 받은 단 출력하기(구구단)
	 */
	public void method7() {
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%2d x %2d = %2d\n" , num1, i, num1*i);
		}
	}
	
	/**
	 * 입력 받은 두 정수 사이의 구구단을 모두 출력
	 * <pre>
	 * 시작 단 : 3
	 * 종료 단 : 
	 * </pre>
	 */
	public void method8() {
		System.out.print("시작 단 : ");
		int num1 = sc.nextInt()-1;
		System.out.print("종료 단 : ");
		int num2 = sc.nextInt();
		int check = 1;
		while(true) {
			if (check==1) {
				System.out.printf("\n[%d단]\n", num1);
			}
			System.out.printf("%d x %d = %d\n", num1,check,num1*check);
			check+=1;
			if (check==10 && num1==num2) {
				break;
			}
			if (check==10) {
				num1+=1;
				check=1;
			}

		}
	}
}
