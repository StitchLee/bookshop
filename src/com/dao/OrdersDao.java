package com.dao;

import java.util.List;


import com.bean.Customer;
import com.bean.OrderBook;
import com.bean.Orders;

public interface OrdersDao {
	public boolean add(int isPay,String orderTime,Customer customer,OrderBook orderBook);
	public List<Orders> selectAll();
	public int getAllCount();//查询记录总数
	public int getCount(int id);//查询指定记录数
	public List<Orders> queryForPage(int offset, int length);//查询指定范围的订单
	public boolean delete(int[] orderIds);//删除订单
	public boolean delete1(int[] orderIds);
	public List<Orders> selectByName(String name);//根据bookName进行查询
	public List<Orders> queryForPage1(int offset, int length,int id);
}
