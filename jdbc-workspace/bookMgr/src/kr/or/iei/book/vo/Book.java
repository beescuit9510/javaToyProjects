package kr.or.iei.book.vo;

public class Book {

	private int book_no;
	private String genre;
	private String title;
	private String intro;
	private String author;
	private int stock;
	public Book(int book_no, String genre, String title, String intro, String author, int stock) {
		super();
		this.book_no = book_no;
		this.genre = genre;
		this.title = title;
		this.intro = intro;
		this.author = author;
		this.stock = stock;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return book_no + "\t" + genre + "\t" + title + "\t" + intro + "\t"
				+ author + "\t" + stock;
	}
	
	
	
	

}
