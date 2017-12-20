package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Book;
import com.bean.Customer;
import com.bean.OrderBook;
import com.bean.Orders;
import com.bean.Page;
import com.dao.OrdersDao;

@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersDao ordersDao;

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	public boolean add(int isPay, String orderTime, Customer customer, OrderBook orderBook) {
		return ordersDao.add(isPay, orderTime, customer, orderBook);
	}
	public List<Orders> selectAll(){
		return ordersDao.selectAll();
	}
	public boolean delete(int[] orderIds) {
		return ordersDao.delete(orderIds);
	}
	public boolean delete1(int[] orderIds) {
		return ordersDao.delete1(orderIds);
	}
	public Page queryForPage(int currentPage,int pageSize) {
        Page page = new Page();       
        //总记录数
        int allRow = ordersDao.getAllCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Orders> list = ordersDao.queryForPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setOlist(list);    
        return page;
    }
	public Page queryForPage1(int currentPage,int pageSize,int id) {
        Page page = new Page();       
        //总记录数
        int allRow = ordersDao.getCount(id);
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Orders> list = ordersDao.queryForPage1(offset, pageSize, id);
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setOlist(list);    
        return page;
    }
	public List<Orders> selectByName(String name){
		return ordersDao.selectByName(name);
	}
}
