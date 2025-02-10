package section02;

import java.io.IOException;

public class ThrowsRun {
	public static void main(String[] args) {
		ThrowsTest tt = new ThrowsTest();
		
		try {
//			tt.method1();
			//tt.test1(); //CheckedException 확인
			// -> IOException 전달됨
			
			tt.test2(); // UncheckedException 확인
			// -> ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println("0으로 못나눔");
			e.printStackTrace();
		}
//		catch (IOException e) {
//			System.out.println("IO");
//			e.printStackTrace();
//		}	
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("종료");
		}
	}
}
