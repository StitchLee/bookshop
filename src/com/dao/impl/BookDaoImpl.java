package com.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Book;

import com.dao.BookDao;
@Repository 
public class BookDaoImpl implements BookDao{

	@Autowired
	private SessionFactory sessionFactory;
	//����ͼ���б�
	public List<Book> selectAll() {
		Session session = sessionFactory.openSession();	
		String hql = "from Book ";	
		Query query = session.createQuery(hql);
		List<Book> list = query.list();
		return list;
		
	}
	//����ͼ��
	public boolean add(Book book) {	
		Session session = sessionFactory.openSession();	
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		return true;
		
	}
	//����ͼ��
	public boolean update(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	    session.clear(); 
		session.update(book);
		tx.commit();
		return true;
	}
	//ɾ��ͼ��
	public boolean delete(int[] bookIds) {
		
		String hql = "";
		for(int i = 0;i < bookIds.length;i++) {
			if(i==0) {
				hql = "id="+bookIds[i];
			}else {
				hql = hql+"or id="+bookIds[i];
			}
		}
		Session session = sessionFactory.openSession();	 
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Book where "+hql);
		query.executeUpdate();
		tx.commit();
		return true;
		
	}
	//ɾ��ͼ����б�
	public List<Book> delectlist() {
		Session session = sessionFactory.openSession();
		String hql = "from Book ";	
		Query query = session.createQuery(hql);
		List<Book> list = query.list();
		return list;
		
	}
	//����ͼ����б�
	public List<Book> updatelist() {
		Session session = sessionFactory.openSession();
		String hql = "from Book ";	
		Query query = session.createQuery(hql);
		List<Book> list = query.list();
		return list;
	}
	//����bookId���в�ѯ
	public Book selectById(int id) {
		Session session = sessionFactory.openSession();
		String hql = "from Book where bookId=?";
		Query query = session.createQuery(hql);
		query.setLong(0, id);
		List<Book> list = query.list();
		return list.get(0);
		
	}
	//����bookName���в�ѯ
	public Book selectByName(String name) {
		Session session = sessionFactory.openSession();
		String hql = "from Book where bookName=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		List<Book> list = query.list();
		return list.get(0);
	}
	//����booktypeId���в�ѯ
	public List<Book> selectByType(int typeId) {
		Session session = sessionFactory.openSession();
		String hql = "from Book where booktypeId=?";
		Query query = session.createQuery(hql);
		query.setLong(0, typeId);
		List<Book> list = query.list();
		return list;
	}
	//��ѯ��¼����
	public int getAllCount() {
		Session session = sessionFactory.openSession();
		int count=((Long) sessionFactory.openSession()
                .createQuery( "select count(*) from Book").iterate().next()).intValue();
         return count;  
		
	}
	//��ѯָ����������
	public int getTypeCount(int typeid) {
		Session session = sessionFactory.openSession();         
         String hql = "from Book where booktypeId=?";
 		Query query = session.createQuery(hql);
 		query.setLong(0, typeid); 
 		List<Book> list = query.list();
 		return list.size();
	}
	//��ѯָ����Χ��ͼ��
	public List<Book> queryForPage(int offset, int length) {
		//��ѯ���еļ�¼��
	      Query query= (Query) sessionFactory.openSession().createQuery("from Book");    
	      query.setFirstResult(offset);
	      query.setMaxResults(length);            
	      return query.list(); 
	}
	//��ѯָ������ͼ��
	public List<Book> queryTypeForPage(int offset, int length, int typeid) {
		//��ѯָ���ļ�¼���ļ�¼��
		Session session = sessionFactory.openSession();
		String hql = "from Book where booktypeId=?";
		Query query = session.createQuery(hql);
		query.setLong(0, typeid);  
	    query.setFirstResult(offset);
	    query.setMaxResults(length);            
	    return query.list();
	}
	//��ѯ��������ͼ��
	public Book newBook() {
		Session session = sessionFactory.openSession();
		String hql ="from Book where bookId=(select max(bookId) from Book) ";
		Query query = session.createQuery(hql);
		List<Book> list = query.list();
		return list.get(0);
	}
	//��ѯ����ͼ��
	public Book hotBook() {
		Session session = sessionFactory.openSession();
		String hql = "select b.*,count(o.BOOKID) as count from book b left join bookorder o on b.bookId=o.BOOKID group by o.BOOKID order by count desc limit 3";
		Query query = session.createSQLQuery(hql).addEntity("${book.*}",Book.class);
		List<Book> list =(List<Book>)query.list();
		return list.get(0);
	}
	
	
	}
	
	
	



