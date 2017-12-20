package com.bean;


import java.util.HashSet;
import java.util.Set;



public class Customer {
	private int customerId;
	private String customerName;	
	private String customerPwd;	
	private int customerTel;	
	private String customerEmail;
	private String customerAddr;
	private String customerTime;
	private Set<Orders> orderSet = new HashSet<Orders>();
	public Set<Orders> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public int getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(int customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public String getCustomerTime() {
		return customerTime;
	}
	public void setCustomerTime(String customerTime) {
		this.customerTime = customerTime;
	}
	
	
}