package com.bean;


//¶©µ¥
public class Orders {
	private int orderId;
	private int isPay;
	private String orderTime;
	private Customer customer;
	private OrderBook orderBook;
	public OrderBook getOrderBook() {
		return orderBook;
	}
	public void setOrderBook(OrderBook orderBook) {
		this.orderBook = orderBook;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	
}
