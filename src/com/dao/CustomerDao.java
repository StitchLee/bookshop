package com.dao;

import java.util.List;

import com.bean.Customer;

public interface CustomerDao {
	public Customer login(Customer customer);//�û���֤��¼
	public boolean register(Customer customer);//�û�ע��
	public List<Customer> selectCus();//��ʾ�û��б�
	public List<Customer> deletelist();//ɾ���û��б�
	public boolean delete(int[] cusIds);//ɾ���û�
	public Customer selectByName(String name);//����name���в�ѯ
	public Customer selectById(int id);//����ID���в�ѯ
	public boolean update(Customer cus);//�����û���Ϣ
	public int getAllCount();//��ѯ��¼����
	public List<Customer> queryForPage(int offset, int length);//��ѯָ����Χ���û�
}
