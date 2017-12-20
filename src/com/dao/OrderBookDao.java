package com.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.bean.Book;
import com.bean.OrderBook;

@Repository
public interface OrderBookDao {
	public boolean add(OrderBook orderBook,Set<Book> bookSet,int count,int sum);
	public OrderBook selectById(int id);//根据bookId进行查询
}
