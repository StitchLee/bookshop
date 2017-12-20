package com.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Book;
import com.bean.Customer;
import com.dao.CustomerDao;
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	//用户验证登录
	public Customer login(Customer customer) {
		Session session = sessionFactory.openSession();		
		String hql = "from Customer where customerName=? and customerPwd=?";
		Query query = session.createQuery(hql);		
		String name = customer.getCustomerName();
		String password = customer.getCustomerPwd();
		query.setString(0, name);
		query.setString(1,password);
		List<Customer> list = query.list();
		return list.size()>0?list.get(0):null;
	}
	//显示用户列表
	public List<Customer> selectCus() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}
	//用户注册
	public boolean register(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		return true;		
	}
	//删除用户列表
	public List<Customer> deletelist() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}
	//删除用户
	public boolean delete(int[] cusIds) {
		String hql = "";
		for(int i = 0;i < cusIds.length;i++) {
			if(i==0) {
				hql = "id="+cusIds[i];
			}else {
				hql = hql+"or id="+cusIds[i];
			}
		}
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Customer where "+hql);
		query.executeUpdate();
		tx.commit();
		return true;
	}
	//根据name进行查询
	public Customer selectByName(String name) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where customerName=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		List<Customer> list = query.list();
		return list.get(0);
	}
	//更新用户信息
	public boolean update(Customer cus) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cus);
		tx.commit();
		return true;
	}
	//根据ID进行查询
	public Customer selectById(int id) {
		Session session = sessionFactory.openSession();
		String hql ="from Customer where customerId=?";
		Query query = session.createQuery(hql);
		query.setLong(0, id);
		List<Customer> list = query.list();
		return list.get(0);
	}
	//查询记录总数
		public int getAllCount() {
			
			int count=((Long) sessionFactory.openSession()
	                .createQuery( "select count(*) from Customer").iterate().next()).intValue();
	         return count;  
			
		}
	//查询指定范围的用户
		public List<Customer> queryForPage(int offset, int length) {
			//查询所有的记录数
		      Query query= (Query) sessionFactory.openSession().createQuery("from Customer");    
		      query.setFirstResult(offset);
		      query.setMaxResults(length);            
		      return query.list(); 
		}



	}
