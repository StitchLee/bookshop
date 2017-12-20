package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Book;
import com.bean.Customer;
import com.bean.Page;
import com.dao.CustomerDao;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer login(Customer customer) {
		return customerDao.login(customer);
	}
	
	public boolean register(Customer customer) {
		return customerDao.register(customer);
	}
	
	public  List<Customer> selectCus(){
		 return customerDao.selectCus();
	}
	public List<Customer> deletelist(){
		return customerDao.deletelist();
	}
	public boolean delete(int[] cusIds) {
		return customerDao.delete(cusIds);
	}
	public Customer selectByName(String name) {
		return customerDao.selectByName(name);
	}
	public boolean update(Customer customer) {
		return customerDao.update(customer);
	}
	public Customer selectById(int id) {
		return customerDao.selectById(id);
	}
	public Page queryForPage(int currentPage,int pageSize) {
        Page page = new Page();       
        //总记录数
        int allRow = customerDao.getAllCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Customer> list = customerDao.queryForPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setClist(list);    
        return page;
    }
	public int getAllCount() {
		return customerDao.getAllCount();
	}
	
}
