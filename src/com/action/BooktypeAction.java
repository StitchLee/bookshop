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
	//查找图书类型列表
	@RequestMapping("/selectType")
	public String selectType(Model model,String errormsg) {
		List<Booktype> list = booktypeService.selectType();
		model.addAttribute("booktypelist",list);
		model.addAttribute("errormsg", errormsg);
		return "admin/booklist";
	}
	//增加图书类型
	@RequestMapping("addtype")
	public String addType(Model model,Booktype type) {
		boolean result = booktypeService.addType(type);
		if(result) {
			model.addAttribute("success","插入图书成功");
			return "admin/addtype";
		}else {
			model.addAttribute("errormsg", "插入图书失败");
			return "admin/addtype";
		}
	}
}
