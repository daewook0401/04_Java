package section01;

import java.util.Objects;

public class Book {
	private long 		bookNumber;
	private String 	title;
	private String 	author;
	private int 		price;
	
	
	public Book() {
		super();
	}
	public Book(long bookNumber, String title, String author, int price) {
		super();
		this.bookNumber = bookNumber;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	public long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	/* equlas() 오버라이딩
	 * -> 비교하려는 두 객체의 필드 값이 같은지 비교
	 * 		(동등 비교)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		
		if(obj == null) return false;
		
//		if (!(obj instanceof Book)) return false;
		if (this.getClass() != obj.getClass()) return false;
		// 전달 받은 매개 변수를 Book으로 다운 캐스팅
		Book other = (Book)obj;
		
		if(this.bookNumber != other.bookNumber || !this.title.equals(other.title)
				|| !this.author.equals(other.author) || this.price != other.price) return false;
		return true;
	}
	
	/* hashCode() 오버라이딩
	 * - 동등한 객체는 같은 식별 번호를 가져야 한다
	 * 
	 * - A.equals(B) 가 true이면 A.hashCode() == B.hashCode() : true
	 * 
	 */
	
	
	@Override
	public int hashCode() {
		
		
		return Objects.hash(bookNumber, title, author, price);
//		int result = 1;
//		final int PRIME = 31;
//		
//		result *= (int)bookNumber * PRIME;
//		result *= title.hashCode() * PRIME;
//		result *= author.hashCode() * PRIME;
//		result *= price * PRIME;
//		return result;
	}
	
	
	
	
}
