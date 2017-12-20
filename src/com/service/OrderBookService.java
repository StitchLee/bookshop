package com.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Book;
import com.bean.OrderBook;
import com.dao.OrderBookDao;

@Service
@Transactional
public class OrderBookService {
	@Autowired
	private OrderBookDao orderBookDao;

	public OrderBookDao getOrderBookDao() {
		return orderBookDao;
	}

	public void setOrderBookDao(OrderBookDao orderBookDao) {
		this.orderBookDao = orderBookDao;
	}
	public boolean add(OrderBook orderBook,Set<Book> bookSet,int count,int sum) {
		return orderBookDao.add(orderBook,bookSet,count,sum);
	}
	public OrderBook selectById(int id) {
		return orderBookDao.selectById(id);
	}
}
