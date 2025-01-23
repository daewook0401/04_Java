package service;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayService2 {
	/**
	 * 얕은 복사, 깊은 복사 확인하기
	 */
	public void method1() {
		int[] arr1 = {10,20,30,40,50};
		
		// arr1에 저장된 주소를 copyArr1에 대입 == 얕은 복사
		int[] copyArr1 = arr1;
		
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1));
		
		//copyArr1을 이용해서 값 수정
		copyArr1[0] = 999;
		
		System.out.println("------------------------------");
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1));
		
		// hashCode() : 주소를 이용해서 만든 해시함수 결과 값
		System.out.println(arr1.hashCode());
		System.out.println(copyArr1.hashCode());
		
		System.out.println("--------------");
		
		int[] arr2 = {5,6,7,8};
		int[] copyArr2 = new int[4];
		int[] copyArr3 = new int[4];
		
		for(int i = 0;i<4;i++) {
			copyArr2[i] = arr2[i];
		}
		
		System.out.println("arr2 : " + Arrays.toString(arr2));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		
		copyArr2[0] = 999;
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		
		
		// 3) System.arraycopy(A,B,C,D,E)
		// A : 원본 배열에서 복사를 시작할 인덱스 번호
		// B : 원본 배열에서 복사를 시작할 인덱스 번호
		// C : 복사된 배열 요소 값이 저장될 배열명
		// D : 복사하려는 배열에 값을 저장하기 시작할 인덱스 번호
		// E : 원본 배열에 복사할 요소 개수(길이)
		
		System.arraycopy(arr2, 0, copyArr3, 0, arr2.length);
		System.out.println(Arrays.toString(copyArr3));
	}
	
	public void method2() {
		
		// 자바에서 배열 기호 []는 한 개당 1차원을 의미함.
		
		int[][] arr = new int[2][3];
		
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		// check
		System.out.println("arr[0] : "+arr[0]);
		
		for(int row = 0; row <arr.length; row++) {
			for(int col=0; col < arr[row].length;col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		// 1차원 배열 선언 및 초기화
		int[] arr1 = {30,40,50,60};
		int[] arr2 = {15,25,35,45};
		
		// 2차원 배열 선언 및 초기화
		int[][] arr = {arr1,arr2,{99,88,77,66}};
		
		System.out.print("검색할 숫자 입력 : ");
		int input = sc.nextInt();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if (input==arr[i][j]) {
					System.out.printf("%d행 %d열에 있습니다.\n",i,j);
					return;
				}
			}
		}
		
		System.out.println("존재하지 않습니다.");
	}
}
