package com.dao.impl;



import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bean.Book;
import com.bean.OrderBook;
import com.dao.OrderBookDao;

@Repository
public class OrderBookDaoImpl implements OrderBookDao {

	@Autowired 
	private SessionFactory sessionFactory;
	
	public boolean add(OrderBook orderBook,Set<Book> bookSet,int count,int sum) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		orderBook.setBookAmount(count);
		orderBook.setBookSet(bookSet);
		orderBook.setTotalMoney(sum);
		session.save(orderBook);
		tx.commit();
		return true;
	}

	
	public OrderBook selectById(int id) {
		Session session = sessionFactory.openSession();
		String hql = "from OrderBook where orderBookId=?";
		Query query = session.createQuery(hql);
		query.setLong(0, id);
		List<OrderBook> list = query.list();
		return list.get(0);
	}

}
