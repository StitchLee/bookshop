package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Booktype;
import com.dao.BooktypeDao;
@Repository 
public class BooktypeDaoImpl implements BooktypeDao{

	@Autowired
	private SessionFactory sessionFactory;
	//查找图书类型列表
	public List<Booktype> selectType() {
		
		Session session = sessionFactory.openSession();
		String hql = "from Booktype";
		Query query = session.createQuery(hql);
		List<Booktype> list = query.list();
		return list;
	}
	//增加图书类型
	public boolean addType(Booktype type) {
		Session session = sessionFactory.openSession();	
		Transaction tx = session.beginTransaction();
		session.save(type);
		tx.commit();
		return true;
	}

}
