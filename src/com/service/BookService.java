package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Book;
import com.bean.Page;
import com.dao.BookDao;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


import javax.transaction.Transactional;
@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public List<Book> selectAll(){
		 return bookDao.selectAll();
	}
	
	public boolean add(Book book) {
		return bookDao.add(book);
	}
	
	public boolean delete(int[] bookIds) {
		return bookDao.delete(bookIds);
	}
	public List<Book> deletelist(){
		 return bookDao.delectlist();
	}
	public List<Book> updatelist(){
		 return bookDao.updatelist();
	}
	public boolean update(Book book) {
		return bookDao.update(book);
	}
	public Book selectById(int id) {
		return bookDao.selectById(id);
	}
	public Book selectByName(String name) {
		return bookDao.selectByName(name);
	}
	public List<Book> selectBytype(int typeId) {
		return bookDao.selectByType(typeId);
	}
	public Page queryForPage(int currentPage,int pageSize) {
        Page page = new Page();       
        //总记录数
        int allRow = bookDao.getAllCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Book> list = bookDao.queryForPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);    
        return page;
    }
	public Page queryTypeForPage(int currentPage,int pageSize,int typeid) {
		Page page = new Page();
		//类别的记录数
		int allRow = bookDao.getTypeCount(typeid);
		//当前页开始记录
		int offset = page.countOffset(currentPage,pageSize);  
	    //分页查询结果集
		List<Book> list = bookDao.queryTypeForPage(offset, pageSize,typeid); 
	    page.setPageNo(currentPage);
	    page.setPageSize(pageSize);
	    page.setTotalRecords(allRow);
	    page.setList(list);    
	        return page;
	}
	public int getAllCount() {
		return bookDao.getAllCount();
	}
	public int getTypeAllCount(int typeid) {
		return bookDao.getTypeCount(typeid);
	}
	public Book newBook() {
		return bookDao.newBook();
	}
	public Book hotBook() {
		return bookDao.hotBook();
	}
	public Set<Book> searchBookByIds(Set<Integer> bookIds) {
		Set<Book> bSet = new HashSet<>();
		Iterator iterator = bookIds.iterator();
		Integer bookId = null;
		while(iterator.hasNext()) {
			bookId = (Integer)iterator.next();
			bSet.add(bookDao.selectById(bookId));
		}
		
		return bSet;
	}

	public Set<Book> searchBookByIds(Integer[] bookIds) {
		Set<Book> bSet = new HashSet<>();
		for(int i =0;i < bookIds.length;i++) {
			bSet.add(bookDao.selectById(bookIds[i]));
		}
		return bSet;
		
	}

	

	
}
