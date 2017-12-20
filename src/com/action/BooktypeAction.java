package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Book;
import com.bean.Booktype;
import com.service.BooktypeService;

@Controller
public class BooktypeAction {
	@Autowired
	private BooktypeService booktypeService;

	public BooktypeService getBooktypeService() {
		return booktypeService;
	}

	public void setBooktypeService(BooktypeService booktypeService) {
		this.booktypeService = booktypeService;
	}
	//����ͼ�������б�
	@RequestMapping("/selectType")
	public String selectType(Model model,String errormsg) {
		List<Booktype> list = booktypeService.selectType();
		model.addAttribute("booktypelist",list);
		model.addAttribute("errormsg", errormsg);
		return "admin/booklist";
	}
	//����ͼ������
	@RequestMapping("addtype")
	public String addType(Model model,Booktype type) {
		boolean result = booktypeService.addType(type);
		if(result) {
			model.addAttribute("success","����ͼ��ɹ�");
			return "admin/addtype";
		}else {
			model.addAttribute("errormsg", "����ͼ��ʧ��");
			return "admin/addtype";
		}
	}
}
