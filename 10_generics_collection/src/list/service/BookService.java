package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공 클래스
 */
public class BookService {
	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다", "한강", 15000, "창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800, "포레스트북스"));
		bookList.add(new BookDTO("채식주의자", "한강", 15000, "창비"));
		bookList.add(new BookDTO("작별하지 않는다", "한강", 16800, "창비"));
		bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
		
	}

	public List<BookDTO> getBookList() {
		return bookList;
	}

	public BookDTO selectIndex(int index) {
		if (!checkIndex(index)) return null;
		return bookList.get(index);
	}
	
	/**
	 * 전달 받은 index가 정상 범위인지 확인
	 * @param index
	 * @return 정상 true, 아니면 false
	 */
	public boolean checkIndex(int index) {
		if (index >= bookList.size() || index < 0) return false;
		
		return true; // 정상 범위 true
	}
	
	/**
	 * 전달 받은 book을 bookList에 추가
	 * 단, 책 정보가 모두 일치하는 책이 있다면 추가 X
	 * @param book
	 * @return
	 */
	public boolean addBook(BookDTO book) {
		// 책 정보 비교 방법 1) 필드 값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용
		
		
//		for(BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		// BookDTO의 equals()를 오버라이딩 했기 때문에
		// List가 제공하는 contains() (포함하는지 확인) 사용 가능
		if(bookList.contains(book)) return false;
		return bookList.add(book); 
		// 컬렉션은 크기 제한이 없어서 무조건 추가 성공(true 반환)
	}
	
	public String modifyBookPrice(int newPrice, int index) {
		BookDTO target = bookList.get(index);
		int oldPrice = target.getPrice();
		target.setPrice(newPrice);
		return String.format("[%s] 가격이 [%d] -> [%d]으로 수정되었습니다.", 
				target.getTitle(),
				oldPrice,
				newPrice);
	}
	
	public BookDTO removeBook(int index) {
		if(!checkIndex(index)) return null;
		BookDTO b = bookList.remove(index);
		return b;
	}
	
	public int checkTitle(String title) {
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public BookDTO selectTitle(String title) {
		
		for(BookDTO book : bookList) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean removeBookTitle(String title) {
		BookDTO book = selectTitle(title);
		if (book == null) return false;
		bookList.remove(book);
		return true;
	}
	
	
	public List<BookDTO> selectPublisherAll(String publisher) {
		List<BookDTO> box = new ArrayList<BookDTO>();
		for(BookDTO book : bookList) {
			if (book.getPublisher().equals(publisher)) {
				box.add(book);
			}
		}
		if (box.isEmpty()) return null;
		return box;
	}
	
	
	
	public List<BookDTO> selectAuthorAll(String Author) {
		List<BookDTO> box = new ArrayList<BookDTO>();
		for(BookDTO book : bookList) {
			if (book.getAuthor().equals(Author)) {
				box.add(book);
			}
		}
		if (box.isEmpty()) return null;
		return box;
	}
	
	public List<BookDTO> searchBook(String searchWord){
		List<BookDTO> box = new ArrayList<BookDTO>();
		for(BookDTO book : bookList) {
			if (book.getTitle().contains(searchWord) ||
					book.getAuthor().contains(searchWord) ||
					book.getPublisher().contains(searchWord) ||
					Integer.toString(book.getPrice()).contains(searchWord)) {
				box.add(book);
			}
		}
		
		return box;
	}

	/**
	 * 제목 오름차순 정렬
	 */
	public void bookListSorting() {
		Collections.sort(bookList);
	}
}
