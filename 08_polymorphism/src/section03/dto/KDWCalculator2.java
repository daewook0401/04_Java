package section03.dto;


/** Calculator 인터페이스 구현체
 * - 모든 인터페이스 구현체는 같은 형태를 띄고 있다
 */
public class KDWCalculator2 implements Calculator {

	@Override
	public int plus(int a, int b) {	
		return checkNum(a+b);
	}

	@Override
	public int minus(int a, int b) {
		return checkNum(a-b);
	}

	@Override
	public int multi(int a, int b) {
		return checkNum(a*b);
	}

	@Override
	public double div(int a, int b) {
		return checkNum(a/b);
	}

	@Override
	public int mod(int a, int b) {
		return checkNum(a%b);
	}

	@Override
	public int pow(int a, int x) {
		return checkNum((int)Math.pow(a, x));
	}

	@Override
	public double areaOfCircle(double r) {
		return checkNum(r*r*3.14);
	}
}
