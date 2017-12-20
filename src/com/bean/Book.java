package com.bean;

import java.util.HashSet;
import java.util.Set;

public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	private String bookPic;
	private String bookPress;
	private Booktype booktype;
	private Set<OrderBook> orderBookSet = new HashSet<OrderBook>();
	public Set<OrderBook> getOrderBookSet() {
		return orderBookSet;
	}
	public void setOrderBookSet(Set<OrderBook> orderBookSet) {
		this.orderBookSet = orderBookSet;
	}
	public Booktype getBooktype() {
		return booktype;
	}
	public void setBooktype(Booktype booktype) {
		this.booktype = booktype;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPic() {
		return bookPic;
	}
	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}
	
}
