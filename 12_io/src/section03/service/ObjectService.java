package section03.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import section03.dto.Member;

public class ObjectService {
	
	/** Member 객체 하나를 파일로 출력하기
	 * 
	 */
	public void outputMember() {
		
		// 출력용 스트림 참조 변수 선언
		FileOutputStream fos = null; // 기반 스트림
		ObjectOutputStream oos = null; // 객체 출력 보조 스트림
		
		try {
			Member member = new Member("member11223344", "1q2w3e4r!", "짱구");
			
			
			fos = new FileOutputStream("io_test/byte/Member.bin");
			
			//객체 출력 보조 스트림 객체 생성
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(member);
			System.out.println("출력완료");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 파일에서 Member 객체 입력 받기(읽어오기)*/
	public void inputMember() {
		// 스트림 참조 변수 선언
		FileInputStream fis = null; // 기반 스트림
		ObjectInputStream ois = null; // 객체 출력 보조 스트림
		
		try{
			// 입력 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/Member.bin");
			
			// 객체 입력 보조 스트림 생성 
			ois = new ObjectInputStream(fis);
			
			// 연결된 파일로 부터 Member 객체 읽어오기
			// -> 파일에 존재하는 Member 객체는 직렬화된 상태
			// -> readObject() 호출 시 자동으로 "역직렬화" 수행
			// 	-> JVM이 객체를 인식 가능한 상태로 변경
			Member member = (Member)ois.readObject();
			
			System.out.println("읽어온 Member");
			System.out.println(member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//--------------------------------------------
	
	public void outputMemberList() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			List<Member> memberList = new ArrayList<Member>();
			
			memberList.add(new Member("member01", "pass01", "짱구"));
			memberList.add(new Member("member02", "pass02", "맹구"));
			memberList.add(new Member("member03", "pass03", "훈이"));
			
			fos = new FileOutputStream("io_test/byte/MemberList.bin");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(memberList);
			
			System.out.println("회원 목록 출력 완료");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * MemberList.bin 내용 읽어오기
	 */
	public void inputMemberList() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("io_test/byte/MemberList.bin");
			ois = new ObjectInputStream(fis);
			
			// 직렬화된 상태로 저장된 List<Member> 객체를 읽어와
			// 역직렬화해서 저장
			List<Member> memberList = (List<Member>)ois.readObject();
			
			for(Member member : memberList) {
				System.out.println(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
