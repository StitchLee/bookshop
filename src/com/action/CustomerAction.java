package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bean.Book;
import com.bean.Customer;
import com.bean.Page;
import com.service.BookService;
import com.service.CustomerService;

@Controller
public class CustomerAction {
	@Autowired
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//用户验证登录
	@RequestMapping("/clogin")
	public String login(Model model,Customer customer,RedirectAttributes attr) {
		
		Customer cus = customerService.login(customer);
		if(cus==null) {
			model.addAttribute("errormsg","登陆失败");
			return "shop/index";
		}else {		
			String name = cus.getCustomerName();
			attr.addFlashAttribute("name",name);			
			return "redirect:newbook.do";
		}
		
	}
	//根据name进行查询
		@RequestMapping("selectByName")
		public String selectByName(String name,RedirectAttributes attr) {
			Customer cus = customerService.selectByName(name);
			//model.addAttribute("customer",cus);
			attr.addFlashAttribute("customer",cus);
			return "redirect:goToXinXi.do";
		}
	//用户注册
	@RequestMapping("/register")
	public String register(Model model,Customer customer) {
		 Date day = new Date();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String nowTime = df.format(day);
		 customer.setCustomerTime(nowTime);
		boolean result = customerService.register(customer);
		if(result) {
			return "shop/success";
		}else {
			return "shop/error";
		}
	}
	//显示用户列表
	@RequestMapping("/selectCus")
	public String selectAll(Model model,String errormsg) {
		List<Customer> list = customerService.selectCus();
		model.addAttribute("cuslist",list);
		model.addAttribute("errormsg", errormsg);
		return "admin/cuslist";
	}
	//删除用户列表
	@RequestMapping("/deletecuslist")
//	public String deletelist(Model model,String errormsg) {
//		List<Customer> list = customerService.deletelist();
//		model.addAttribute("cuslist",list);
//		model.addAttribute("errormsg", errormsg);
//		return "admin/deletecuslist";
//	}
	public String deletelist(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        Page page = customerService.queryForPage(Integer.valueOf(pageNo), 5);
        request.setAttribute("page", page);
        List<Customer> list = page.getClist();
        modelMap.put("cuslist", list);
    return "admin/deletecuslist";
}
	//删除用户
	@RequestMapping("deleteCus")
	public String delete(Model model,int[] cusIds) {
		boolean result = customerService.delete(cusIds);			
		return "redirect:deletecuslist.do";
	}
	//更新用户信息
	@RequestMapping("updateCus")
	public String updateCus(Model model,Customer customer) {
		boolean result = customerService.update(customer);
		if(result) {
			model.addAttribute("success","修改信息成功");
			return "shop/updateXinXi";
		}else {
			model.addAttribute("error","修改信息失败");
			return "shop/updateXinXi";
		}
	}
	//返回需要更新的用户
	@RequestMapping("updateNeed")
	public String updateNeed(Model model,int id) {
		Customer customer = customerService.selectById(id);
		model.addAttribute("customer", customer);
		return "shop/updateXinXi";
	}

	//找到所有的记录并实现了分页
		@RequestMapping("/cpage")
		public String findAll(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
		        String pageNo = request.getParameter("pageNo");
		        if (pageNo == null) {
		            pageNo = "1";
		        }
		        Page page = customerService.queryForPage(Integer.valueOf(pageNo), 5);
		        request.setAttribute("page", page);
		        List<Customer> list = page.getClist();
		        modelMap.put("cuslist", list);
		    return "admin/cuslist";
		}
}
