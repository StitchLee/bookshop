package com.dao;

import java.util.List;


import com.bean.Booktype;

public interface BooktypeDao {
	public List<Booktype> selectType();//����ͼ�������б�
	public boolean addType(Booktype type);//����ͼ������
}
