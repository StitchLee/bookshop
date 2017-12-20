package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Book;
import com.bean.Booktype;
import com.dao.BooktypeDao;

@Service
@Transactional
public class BooktypeService {
	@Autowired
	private BooktypeDao booktypeDao;

	public BooktypeDao getBooktypeDao() {
		return booktypeDao;
	}

	public void setBooktypeDao(BooktypeDao booktypeDao) {
		this.booktypeDao = booktypeDao;
	}
	
	public List<Booktype> selectType(){
		 return booktypeDao.selectType();
	}
	
	public boolean addType(Booktype type) {
		return booktypeDao.addType(type);
	}
	
}
