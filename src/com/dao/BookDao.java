package com.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.bean.Book;

@Repository 
public interface BookDao {
	public List<Book> selectAll();//����ͼ���б�
	public boolean add(Book book);//����ͼ��
	public boolean delete(int[] bookIds);//ɾ��ͼ��
	public boolean update(Book book);//����ͼ��
	public List<Book> delectlist();//ɾ��ͼ����б�
	public List<Book> updatelist();//����ͼ����б�
	public Book selectById(int id);//����bookId���в�ѯ
	public Book selectByName(String name);//����bookName���в�ѯ
	public List<Book> selectByType(int typeId);//����booktypeId���в�ѯ
	public int getAllCount();//��ѯ��¼����
	public List<Book> queryForPage(int offset, int length);//��ѯָ����Χ��ͼ��
	public List<Book> queryTypeForPage(int offset,int length,int typeid);//��ѯָ������ͼ��
	public int getTypeCount(int typeid);//��ѯָ����������
	public Book newBook();//������������ͼ��
	public Book hotBook();//��������ͼ��
}
