package section01.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {

	private Scanner sc = new Scanner(System.in);

	/*
	 * Exception(예외) : 코드로 해결 가능한 에러 (if, try-catch, throws)
	 * 
	 * Exception Handling(예외 처리) : 발생된 예외를 처리하는 구문(try-catch, throws
	 * 
	 * 
	 */

	/**
	 * try-catch 작성법
	 * 
	 * <pre>
	 * 
	 * try { 예외가 발생할 것 같은 구문 }
	 * - 예외가 발생할 가능성이 있는 코드를 시도하는 구문{}
	 * 
	 * catch(예외 참조 변수){}
	 * - try에서 던져진 예외를
	 * 	 () 예외 참조 변수가 잡아서 처리하는 구문
	 * 	 -> 잡아서 처리하면 예외가 사라짐
	 * 	 프로그램이 종료되지 않고 계속 정상수행
	 * 
	 * </pre>
	 */
	public void test1() {

		// 입력 받은 두 정수를 나눈 몫 계산하기
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v1");

		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		try {
			System.out.println("몫 : " + num1 / num2);
			// : / by zero
			// -> 산술적 예외 발생시 비정상 종료
		} catch (ArithmeticException e) {
			// try에서 ArithmeticException 객체가 던져지면
			// 매개 변수 e를 이용해서 잡음
			// -> 잡아서 처리 -> 예외 사라짐 - 프로그램 정 운영
			System.out.println("0으로 나눌 수 없습니다.");
		} finally {
			System.out.println("---프로그램 종료---");
		}
	}

	public void test2() {

		// 입력 받은 두 정수를 나눈 몫 계산하기
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v2");

		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();

		try {
			System.out.println("몫 : " + num1 / num2);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (InputMismatchException e) {
			// catch는 여러 번 작성 가능
			// -> try에서 예외 발생시 던져진 예외를 잡아서 처리할 수 있는 catch문을 위에서 부터 순서대로 탐색
		}
	}

	public void test3() {
		// 입력 받은 두 정수를 나눈 몫 계산하기
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v3");

		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();

		try {
			System.out.println("몫 : " + num1 / num2);
		} catch (RuntimeException e) {
			// ArithmeticException과 InputMismatchEception의
			// 공통 부모 타입을 매개 변수로 선언

			// try에서 예외 발생 시 예외 "객체 참조 주소"가 던져짐

			// - 업 캐스팅 : 부모 타입 참조변수 = 자식 객체 참조 주소;

			// * 결론 : 부모 타입 예외 참조 변수로 던져지는 모든 자식 예외를 잡겠다

			System.out.println("프로그램 실행 중 예외 발생");
		}
		System.out.println("--- 프로그램 종료 ---");
	}

	/**
	 * 예외처리(try-catch) + 다형성(업 캐스팅) + catch 작성 순서
	 * 
	 * - catch문은 하위 타입 부터 작성 - 서로 상속 관계가 아닌 Exception에 대한 캐치 순서는 관계 없음
	 */
	public void test4() {
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v4");
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		try {
			System.out.println("몫 : " + num1 / num2);

			// 강제 예외 발생
			int[] arr = new int[3];
			arr[10] = 100;

		}

	
		 catch (InputMismatchException e) { System.out.println("정수만 입력해주세요"); } catch
		 (ArithmeticException e) { System.out.println("0으로 나눌 수 없습니다."); }
		 
			// 부모 타입 예외 처리 구문을 먼저 작성하면
		// 자식 타입 예외까지 모두 잡기 때문에 뒤에있는 자식 catch문이 절대로 실행될 수 없다.
		catch (RuntimeException e) {
			System.out.println("실행 중 예외 발생 ");
		}
		System.out.println("--- 프로그램 종료 ---");
	}
	
	
	/** catch문에 다형성 업캐스팅 적용 + 예외 강제 발생(예외를 만들어 더미)
	 * 
	 * - 예외도 클래스다 -> 객체로 만들 수 있다 -> new 연산자 사용
	 * 
	 * - 예외 강제 발생 구문 : throw new 예외클래스();
	 * 
	 */
	public void test5() {
		
		int input = 0;
		do {
			System.out.println("강제로 발생시켜 던질 예외 선택---");
			System.out.println("1. ArithmeticException");
			System.out.println("2. ArrayIndexOutofBoundsException");
			System.out.println("3. RuntimeException");
			System.out.println("4. IOException");
			System.out.println("5. Exception");
			
			try {
				System.out.print("예외 선택 >> ");
				input = sc.nextInt(); // InputMismatchException
				
				switch(input) {
				case 1: throw new ArithmeticException();
				case 2: throw new ArrayIndexOutOfBoundsException();
				case 3: throw new RuntimeException();
				case 4: throw new IOException();
				case 5: throw new Exception();
				case 0: System.out.println("종료 선택");
				}
			} catch (InputMismatchException e) {
        System.out.println("정수만 입력해주세요");
        sc.nextLine(); // 버퍼 비우기
        input = -1;  // 잘못된 입력을 처리하기 위해 재입력
    } catch (ArithmeticException e) {
        System.out.println("ArithmeticException() 처리 완료");
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("ArrayIndexOutOfBoundsException() 처리 완료");
    } catch (RuntimeException e) {
        System.out.println("RuntimeException() 처리 완료");
    } catch (IOException e) {
        System.out.println("IOException() 처리 완료");
    } catch (Exception e) {
        System.out.println("예외 최상위 부모 Exception으로");
        System.out.println("나머지 모든 예외 잡아서 처리");
    }
			

		}while(input != 0);
		
		System.out.println("--- 프로그램 정상 종료---");
		
	}
	
	/* finally{}
	 * - 뜻 : 마침내, 마지막으로
	 * - try 구문에서 예외 발생 여부 관계 없이
	 * 	 마지막에 무조건 실행되어야 하는 코드를 작성하는 구문
	 * 
	 * - 중간에 프로그램이 종료되거나 메서드 리턴되어도 무조건 실행된다
	 * 
	 * - 외부 프로그램/장치와의 연결을 끊어낼 때 주로 사용
	 */
	public void test6() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("1. 정상수행 2/ 예외 강제 발생");
			int input = sc.nextInt();
			
			if(input == 1) System.out.println("예외 없이 정상 수행");
			else {
				System.out.println("[예외 강제 발생]"); 
				throw new Exception("강제로 던져진 예외");
			}
		} catch (Exception e) {
			// 예외 객체 참조 변수 e
			// - 예외와 관련된 기능 제공
			
			System.err.println(e.getMessage());
		}
		finally {
			System.out.println("실행");
			sc.close();
		}
	}
}
