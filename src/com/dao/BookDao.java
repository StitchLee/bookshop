package com.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.bean.Book;

@Repository 
public interface BookDao {
	public List<Book> selectAll();//查找图书列表
	public boolean add(Book book);//增加图书
	public boolean delete(int[] bookIds);//删除图书
	public boolean update(Book book);//更新图书
	public List<Book> delectlist();//删除图书的列表
	public List<Book> updatelist();//更新图书的列表
	public Book selectById(int id);//根据bookId进行查询
	public Book selectByName(String name);//根据bookName进行查询
	public List<Book> selectByType(int typeId);//根据booktypeId进行查询
	public int getAllCount();//查询记录总数
	public List<Book> queryForPage(int offset, int length);//查询指定范围的图书
	public List<Book> queryTypeForPage(int offset,int length,int typeid);//查询指定类别的图书
	public int getTypeCount(int typeid);//查询指定类别的总数
	public Book newBook();//查找最近加入的图书
	public Book hotBook();//查找热销图书
}
