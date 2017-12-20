package com.service;

import org.springframework.stereotype.Service;

import com.bean.Manager;
import com.dao.ManagerDao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	@Transactional
	public Manager login(Manager manager) {
		 return managerDao.login(manager);
	}
}
