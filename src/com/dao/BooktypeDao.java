package com.dao;

import java.util.List;


import com.bean.Booktype;

public interface BooktypeDao {
	public List<Booktype> selectType();//查找图书类型列表
	public boolean addType(Booktype type);//增加图书类型
}
