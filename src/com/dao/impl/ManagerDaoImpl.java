package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Manager;
import com.dao.ManagerDao;
@Repository 
public class ManagerDaoImpl  implements ManagerDao {

	@Autowired
	private SessionFactory sessionFactory;
	//管理员验证登录
	public Manager login(Manager manager) {
		Session session = sessionFactory.openSession();
		String hql = "from Manager where adminName=? and adminPwd=?";	
		Query query = session.createQuery(hql);
		String name = manager.getAdminName();
		String password = manager.getAdminPwd();
		query.setString(0, name);
		query.setString(1, password);
		List<Manager> list = query.list();
		return list.size()>0?list.get(0):null;
	}

}
