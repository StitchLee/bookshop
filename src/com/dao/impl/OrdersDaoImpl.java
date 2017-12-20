package com.dao.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Book;
import com.bean.Customer;
import com.bean.OrderBook;
import com.bean.Orders;
import com.bean.Temporary;
import com.dao.OrdersDao;
@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired 
	private SessionFactory sessionFactory;
	
	public boolean add(int isPay, String orderTime, Customer customer, OrderBook orderBook) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Orders orders = new Orders();
		orders.setCustomer(customer);
		orders.setIsPay(isPay);
		orders.setOrderBook(orderBook);
		orders.setOrderTime(orderTime);
		session.save(orders);
		
		Temporary temp = new Temporary();
		temp.setIsPay(isPay);
		temp.setCustomerId(customer.getCustomerId());
		temp.setCustomerAddr(customer.getCustomerAddr());
		temp.setOrderTime(orderTime);
		temp.setBookAmonut(orderBook.getBookAmount());
		temp.setOrderId(orders.getOrderId());
		temp.setTotalMoney(orderBook.getTotalMoney());
		
		Set<Book> bookSet = new HashSet<Book>();
		bookSet = orderBook.getBookSet();
		Iterator<Book> it = bookSet.iterator();
		String str = "";
		while (it.hasNext()) {  
			   str = str + it.next().getBookName();
			   str = str + ",";
	//		   System.out.println("书名"+it.next().getBookName());
			   
			}  

		temp.setBookSet(str);
		session.save(temp);
		tx.commit();
		return true;
	}

	public List<Orders> selectAll() {
		Session session = sessionFactory.openSession();
		String hql = "from Orders";
		Query query = session.createQuery(hql);
		List<Orders> list = query.list();
		return list;
	}

	//查询记录总数
		public int getAllCount() {
			Session session = sessionFactory.openSession();
			int count=((Long) sessionFactory.openSession()
	                .createQuery( "select count(*) from Orders").iterate().next()).intValue();
	         return count;  
			
		}
	//查询指定记录数
		public int getCount(int id) {
			Session session = sessionFactory.openSession();
			String hql = "from Temporary where customerId=?";
			Query query = session.createQuery(hql);
	 		query.setLong(0, id); 
	 		List<Book> list = query.list();
	 		return list.size();
					
		}
	//查询指定范围的订单
		public List<Orders> queryForPage(int offset, int length) {
			//查询所有的记录数
		      Query query= (Query) sessionFactory.openSession().createQuery("from Orders");    
		      query.setFirstResult(offset);
		      query.setMaxResults(length);            
		      return query.list(); 
		}
	//查询指定范围的订单
		public List<Orders> queryForPage1(int offset, int length,int id) {
			//查询所有的记录数
				Query query= (Query) sessionFactory.openSession().createQuery("from Temporary where customerId=?");    
				query.setFirstResult(offset);
				query.setMaxResults(length); 
				query.setLong(0, id);
				return query.list(); 
		}
	//删除订单
		public boolean delete(int[] orderIds) {
			
			String hql = "";
			for(int i = 0;i < orderIds.length;i++) {
				if(i==0) {
					hql = "id="+orderIds[i];
				}else {
					hql = hql+"or id="+orderIds[i];
				}
			}
			Session session = sessionFactory.openSession();	 
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete from Orders where "+hql);
			query.executeUpdate();
			Query q = session.createQuery("delete from Temporary where "+hql);
			q.executeUpdate();
			tx.commit();
			return true;
			
		}
		public boolean delete1(int[] orderIds) {
			String hql = "";
			for(int i = 0;i < orderIds.length;i++) {
				if(i==0) {
					hql = "id="+orderIds[i];
				}else {
					hql = hql+"or id="+orderIds[i];
				}
			}
			Session session = sessionFactory.openSession();	 
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("delete from Temporary where "+hql);
			q.executeUpdate();
			tx.commit();
			return true;
		}
		//根据bookName进行查询
		public List<Orders> selectByName(String name) {
			Session session = sessionFactory.openSession();
			String hql = "select orders.* from orders,customer  where customerName=?";			
			Query query = session.createSQLQuery(hql).addEntity("${orders.*}",Orders.class);
			query.setString(0, name);
			List<Orders> list = (List<Orders>)query.list();
			return list;
		}

}
