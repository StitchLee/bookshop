package com.dao;

import java.util.List;


import com.bean.Customer;
import com.bean.OrderBook;
import com.bean.Orders;

public interface OrdersDao {
	public boolean add(int isPay,String orderTime,Customer customer,OrderBook orderBook);
	public List<Orders> selectAll();
	public int getAllCount();//��ѯ��¼����
	public int getCount(int id);//��ѯָ����¼��
	public List<Orders> queryForPage(int offset, int length);//��ѯָ����Χ�Ķ���
	public boolean delete(int[] orderIds);//ɾ������
	public boolean delete1(int[] orderIds);
	public List<Orders> selectByName(String name);//����bookName���в�ѯ
	public List<Orders> queryForPage1(int offset, int length,int id);
}
