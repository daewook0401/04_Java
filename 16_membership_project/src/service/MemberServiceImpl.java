
package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }

    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
    		for(Member m : dao.getMemberList()) {
    			if(m.getPhone().equals(phone)) {
    				return false;
    			}
    		}
    		if(name == null || phone == null) return false;
    		Member member = new Member(name,phone,0,0);
    		if(!dao.addMember(member)) return false;
        return true;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
        return dao.getMemberList();
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
    		List<Member> memberList = dao.getMemberList();
    		List<Member> memberName = memberList.stream().filter(m -> m.getName().equals(searchName)).collect(Collectors.toList());
        return memberName;
    }


    // 금액 누적
    @Override
    public String updateAmount(Member target, int acc) throws IOException {
    		
    		int temp = target.getAmount();
    		int tempGrade = target.getGrade();
    		int checked = 0;
    		if(temp+acc >=100000) {
    			checked = Member.GOLD;
    		}
    		if (temp+acc>=1000000) {
    			checked = Member.DIAMOND;
    		}
    		target.setAmount(temp+acc);
    		if (checked != tempGrade) {
    			target.setGrade(checked);
    			dao.saveFile();
    			return String.format("%d -> %d\n"
    					+ "* %s * 등급으로 변경 되셨습니다", temp,temp+acc,gradeArr[checked]);
    		}
    		dao.saveFile();
    		return String.format("%d -> %d\n", temp,temp+acc);
  		 // 결과 문자열 반환
        
        //ex)
        // 2000 -> 100000
        // * 골드 * 등급으로 변경 되셨습니다
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {
    		String temp = target.getPhone();
    		target.setPhone(phone);
    		dao.saveFile();
        return String.format("%s님의 전화번호가 변경 되었습니다\n"
        		+"%s	->	%s", target.getName(),temp,phone); // 결과 문자열 반환
        
        
        // ex)
        // 홍길동님의 전화번호가 변경 되었습니다
        // 01012341234 -> 01044445555
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {
    		String temp = target.getName();
    		dao.getMemberList().remove(target);
    		dao.saveFile();
        return String.format("%s 회원이 탈퇴 처리 되었습니다", temp); // 결과 문자열 반환
        // ex)
        // "홍길동 회원이 탈퇴 처리 되었습니다"
    }

}
