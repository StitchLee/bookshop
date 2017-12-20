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
	//�û���֤��¼
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
	//��ʾ�û��б�
	public List<Customer> selectCus() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}
	//�û�ע��
	public boolean register(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		return true;		
	}
	//ɾ���û��б�
	public List<Customer> deletelist() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}
	//ɾ���û�
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
	//����name���в�ѯ
	public Customer selectByName(String name) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where customerName=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		List<Customer> list = query.list();
		return list.get(0);
	}
	//�����û���Ϣ
	public boolean update(Customer cus) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cus);
		tx.commit();
		return true;
	}
	//����ID���в�ѯ
	public Customer selectById(int id) {
		Session session = sessionFactory.openSession();
		String hql ="from Customer where customerId=?";
		Query query = session.createQuery(hql);
		query.setLong(0, id);
		List<Customer> list = query.list();
		return list.get(0);
	}
	//��ѯ��¼����
		public int getAllCount() {
			
			int count=((Long) sessionFactory.openSession()
	                .createQuery( "select count(*) from Customer").iterate().next()).intValue();
	         return count;  
			
		}
	//��ѯָ����Χ���û�
		public List<Customer> queryForPage(int offset, int length) {
			//��ѯ���еļ�¼��
		      Query query= (Query) sessionFactory.openSession().createQuery("from Customer");    
		      query.setFirstResult(offset);
		      query.setMaxResults(length);            
		      return query.list(); 
		}



	}
