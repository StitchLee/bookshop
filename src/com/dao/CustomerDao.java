package com.dao;

import java.util.List;

import com.bean.Customer;

public interface CustomerDao {
	public Customer login(Customer customer);//用户验证登录
	public boolean register(Customer customer);//用户注册
	public List<Customer> selectCus();//显示用户列表
	public List<Customer> deletelist();//删除用户列表
	public boolean delete(int[] cusIds);//删除用户
	public Customer selectByName(String name);//根据name进行查询
	public Customer selectById(int id);//根据ID进行查询
	public boolean update(Customer cus);//更新用户信息
	public int getAllCount();//查询记录总数
	public List<Customer> queryForPage(int offset, int length);//查询指定范围的用户
}
