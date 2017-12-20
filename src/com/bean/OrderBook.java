package com.bean;

import java.util.HashSet;
import java.util.Set;
//∂©µ•œÍ«È
public class OrderBook {
	private int orderBookId;
	private int bookAmount;
	private Orders order;
	private int totalMoney;
	private Set<Book> bookSet = new HashSet<Book>();
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}	
	public Set<Book> getBookSet() {
		return bookSet;
	}
	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
	
	public int getOrderBookId() {
		return orderBookId;
	}
	public void setOrderBookId(int orderBookId) {
		this.orderBookId = orderBookId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getBookAmount() {
		return bookAmount;
	}
	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}
	
}
