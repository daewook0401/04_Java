package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;
/**
 * 도서 관리 프로그램 입/출력 담당 클래스(UI)
 */
public class BookView {
	
	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();
	private Object selectTitle;
	
	/**
	 * 프로그램 메인 메뉴 
	 */
	public void displayMenu() {
		int input = 0; // 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기(index)");
			// 추가 메뉴 
			System.out.println("6. 제목이 일치하는 책 1개 조회하기");
			System.out.println("7. 제목이 일치하는 책 제거하기");
			
			System.out.println("8. 출판사가 일치하는 책 모두 조회");
			System.out.println("9. 저자가 일치하는 책 모두 조회하기");
			
			System.out.println("10. 검색어가 제목, 저자에 포함된 모든 책 조회하기");
			System.out.println("11. bookList 제목 오름차순으로 정렬시키기");
			System.out.println("0. 종료");
			System.out.println();
			
			System.out.print("메뉴 번호 입력 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거(오류 방지)
			System.out.println("----------------------------------");
			
			switch(input) {
			case 1: selectAll(); break;
			case 2: selectIndex(); break;
			case 3: addBook();break;
			case 4: modifyBookPrice();break;
			case 5: removeBook();break;
			case 6: selectTitle();break;
			case 7: removeBookTitle();break;
			case 8: selectPublisherAll();break;
			case 9: selectAuthorAll();break;
			case 10: searchBook();break;
			case 11: bookListSorting();break;
			case 0: System.out.println("프로그램이 종료됩니다. ");break;
			default: System.out.println("메뉴 번호 잘못 입력");
			}
		} while (input != 0);
	}

	private void bookListSorting() {
		System.out.println("\n### 제목 오름차순 정렬 시키기 ###\n");
		
		service.bookListSorting();
		
		System.out.println("정렬 되었습니다.");
	}

	private void searchBook() {
		System.out.println("\n### 제목, 저자 이름으로 찾기 ###\n");
		System.out.print("검색어 입력 : ");
		String searchWord = sc.nextLine();
		List<BookDTO> books = service.searchBook(searchWord);
		if (books == null) return;
		for(BookDTO book : books) {
			System.out.println(book);
		}
	}

	private void selectAuthorAll() {
		System.out.println("\n### 저자 이름으로 찾기 ###\n");
		
		System.out.print("저자 이름 입력 : ");
		String Author = sc.nextLine();
		
		List<BookDTO> books = service.selectAuthorAll(Author);
		if (books == null) return;
		for(BookDTO book : books) {
			System.out.println(book);
		}
	}


	private void selectPublisherAll() {
		// TODO Auto-generated method stub
		System.out.println("\n### 출판사 이름으로 찾기 ###\n");
		
		System.out.print("출판사 이름 입력 : ");
		String publisher = sc.nextLine();
		
		List<BookDTO> books = service.selectPublisherAll(publisher);
		if (books == null) return;
		for(BookDTO book : books) {
			System.out.println(book);
		}
	}




	private void addBook() {
		System.out.println("\n### 책 추가하기 ###\n");
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		boolean result = service.addBook(new BookDTO(title, author, price, publisher));
		
		if (result) {
			System.out.println(title + " 책이 추가되었습니다.");
		}
		else {
			System.out.println(title + " 책이 이미 존재합니다");
		}
	}

	/**
	 * - BookService로 부터 index 번째 BookDTO 반환 받기
	 * 
	 * - 
	 */
	private void selectIndex() {
		System.out.println("\n### index 번호로 조회 ###\n");
		
		System.out.print("조회할 책 index 번호 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		BookDTO book = service.selectIndex(index);
		if (book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("가격 : " + book.getPrice());
		System.out.println("출판사 : " + book.getPublisher());

	}

	/**
	 * 전체 조회
	 * - BookService의 필드 bookList를 얻어와
	 * 	일반 for문을 이용하여 모든 요소 정보 출력
	 * 
	 * 단, bookList에 저장된 정보가 없으면
	 * "저장된 책이 존재하지 않습니다." 출력
	 */
	private void selectAll() {
		System.out.println("\n### 전체 조회 ###\n");
		
		List<BookDTO> list = service.getBookList();
		
		// 전달 받은 list에 데이터가 있는지 확인
		// boolean isEmpty() : 저장된 객체가 없으면 true 반환
		if(list.isEmpty()) {
			System.out.println("저장된 책이 존재하지 않습니다.");
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + ") " + list.get(i));
		}
		
	}
	
	/** 인덱스 번호를 입력 받아
	 * - 해당 인덱스에 책이 없다면
	 * 	-> "해당 인덱스에 책이 존재하지 않습니다"
	 * 
	 * - 책이 있다면
	 * 	1) "수정할 가격 입력 : " 출력 
	 *  2) 스캐너로 가격 입력 받기
	 *  3) 입력 받은 index 번째 요소의 가격 수정
	 *  4) "[책제목] 가격이 [이전 가격] -> [수정된 가격]으로 수정되었습니다." 출력
	 * 
	 */
	private void modifyBookPrice() {
		System.out.println("\n### 책 가격 수정하기 ###\n");
		
		System.out.print("수정할 인덱스 번호 : ");
		int index = sc.nextInt();

		if(service.checkIndex(index) == false) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		
		System.out.print("수정할 가격 입력 : ");
		int newprice = sc.nextInt();


	
		String result = service.modifyBookPrice(newprice, index);
		
		System.out.println(result);
	
	}
	
	/** index번호를 입력 받아 책 제거
	 * 
	 * 단, 해당 index에 책이 없으면
	 * "해당 인덱스에 책이 존재하지 않습니다" 출력
	 * 
	 * 있으면 
	 * "[책제목] 책이 제거되었습니다." 출력
	 */
	private void removeBook() {
		System.out.println("\n### 책 제거하기 ###\n");
		
		System.out.print("삭제 할 인덱스 번호 : ");
		int index = sc.nextInt();
		BookDTO target = service.removeBook(index);
		
		if(target==null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
		} else {
			System.out.printf("[%s] 책이 제거 되었습니다.\n", target.getTitle());
		}
	
	}
	private void selectTitle() {
		System.out.println("\n### 책제목 선택 ###\n");
		
		System.out.print("선택할 책 제목 : ");
		String title = sc.nextLine();
		BookDTO book = service.selectTitle(title);
		if (book == null) {
			System.out.println("잘못됨.");
			return;
		}
		System.out.println(book);
	}
	
	private void removeBookTitle() {
		System.out.println("\n### 책제목 선택 ###\n");
		
		System.out.print("선택할 책 제목 : ");
		String title = sc.nextLine();
		
		boolean check = service.removeBookTitle(title);
		if (!check) {
			System.out.println("잘못됨.");
			return;
		}
		System.out.println("삭제 성공");
	}
	
	
	
}
