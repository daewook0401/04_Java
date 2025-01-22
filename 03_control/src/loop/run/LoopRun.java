package loop.run;
import loop.service.LoopService1;
import loop.service.LoopService2;

public class LoopRun {
	public static void main(String[] args) {
//		LoopService1 service = new LoopService1();
//		service.displayMenu();
		LoopService2 service = new LoopService2();
		service.displayMenu();
	}
}
