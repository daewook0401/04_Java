package loop.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public void startMenu() {
		System.out.print("실행할 프랙티스 번호 : ");
		int choice = sc.nextInt();
		System.out.println("-------------------\n");
		switch(choice) {
		case 1: practice1(); break;
		case 2: practice2(); break;
		case 3: practice3(); break;
		case 4: practice4(); break;
		case 5: practice5(); break;
		case 6: practice6(); break;
		case 7: practice7(); break;
		case 8: practice8(); break;
		case 9: practice9(); break;
		case 10: practice10(); break;
		case 11: practice11(); break;
		case 12: practice12(); break;
		case 13: practice13(); break;
		case 14: practice14(); break;
		case 15: practice15(); break;
		case 16: practice16(); break;
		default : System.out.println("잘못 입력함");
		}
	}
	
	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		for(int i=1;i<=num;i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice2() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		for(int i=num; i>=1;i--) {
			System.out.print(i + " ");
		}
	}
	
	public void practice3() {
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum=num;
		for(int i=1; i<num;i++) {
			System.out.print(i + " + ");
			sum+=i;
		}
		System.out.print(num + " ");
		System.out.print("= "+ sum);
	}
	
	public void practice4() {
		System.out.print("첫 번째 숫자 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int second = sc.nextInt();
		if (first<1 || second <1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		if (first>second) {
			int dump = second;
			second = first;
			first = dump;
		}
		for(int i=first;i<=second;i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice5() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		System.out.printf("===== %d단 =====\n", num);
		for(int i=1;i<10;i++) {
			System.out.printf("%d * %d = %d\n",num,i,num*i);
		}
	}
	
	public void practice6() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		if(num<2 || num>9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
			return;
		}
		for(int j=num;j<10;j++) {
			System.out.printf("\n===== %d단 =====\n", j);
			for(int i=1;i<10;i++) {
				System.out.printf("%d * %d = %d\n",j,i,j*i);
			}
		}
	}
	
	public void practice7() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println("*".repeat(i));
		}
	}
	public void practice8() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i=num;i>=1;i--) {
			System.out.println("*".repeat(i));
		}
	}
	public void practice9() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println(" ".repeat(num-i) + "*".repeat(i));
		}
	}
	public void practice10() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println("*".repeat(i));
		}
		for(int i=num-1;i>=1;i--) {
			System.out.println("*".repeat(i));
		}
	}
	public void practice11() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println(" ".repeat(num-i) + "*".repeat(2*i-1));
		}
	}
	public void practice12() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			if (i==1 || i==num) {
				System.out.println("*".repeat(num));
			}
			else {
				System.out.println("*" + " ".repeat(num-2) + "*");
			}
		}
	}
	
	public void practice13() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int count=0;
		for(int i=1; i<=num; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
			if (i % 2 == 0 && i % 3 == 0) {
				count+=1;
			}
		}
		System.out.print("\ncount : "+ count);
	}
	/*
	 *    *
	 *   **
	 *  ***
	 * ****
	 */
	public void practice14() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		int checkNum = num-1;
		if (num<2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		while(true) {
			if(num%checkNum==0 && checkNum!=1) {
				System.out.println("소수가 아닙니다.");
				break;
			}
			checkNum-=1;
			if (checkNum<=1) {
				System.out.println("소수입니다.");
				break;
			}
		}
	}
	
	public void practice15() {

		int num=1;
		int checkNum = 0;
		do {
			if (checkNum==0) {
				System.out.print("숫자 : ");
				num = sc.nextInt();
				checkNum = num-1;
			} 
			
			if (checkNum<1){
				System.out.println("잘못 입력하셨습니다.");
				checkNum=0;
				continue;
			}
			if(num%checkNum==0 && checkNum!= 1) {
				System.out.println("소수가 아닙니다.");
				break;
			}
			checkNum-=1;
			if (checkNum<=1) {
				System.out.println("소수입니다.");
				break;
			}
		} while(true);
	}
	
	public void practice16() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		int count=0;
		if (num<2) {
			System.out.println("잘못 입력하셨습니다.");
		}
		for(int i=2;i<=num;i++) {
			boolean checked=true;
			for(int j=i;j>=2;j--) {
				if (i%j==0 && i!=j) {
					checked=false;
					break;
				}
			}
			if (checked) {
				System.out.print(i +" ");
				count++;
			}
		}
		System.out.printf("\n2부터 %d까지 소수의 개수는 %d개 입니다.",num,count);
	}
}
