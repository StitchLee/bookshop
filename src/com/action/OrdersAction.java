package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bean.Book;
import com.bean.Customer;
import com.bean.OrderBook;
import com.bean.Orders;
import com.bean.Page;
import com.service.BookService;
import com.service.CustomerService;
import com.service.OrderBookService;
import com.service.OrdersService;

@Controller
public class OrdersAction {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderBookService orderBookService;
	@Autowired
	private BookService bookService;
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public OrderBookService getOrderBookService() {
		return orderBookService;
	}

	public void setOrderBookService(OrderBookService orderBookService) {
		this.orderBookService = orderBookService;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	//添加订单页
	@RequestMapping("/addOrders")
	public String addOrders(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,String name,int detailId,int isPay) {
		
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = df.format(day);
		
		Customer cus = customerService.selectByName(name);
		
		OrderBook orderBook = orderBookService.selectById(detailId);
		
		Book newbook = bookService.newBook();
		Book hotbook = bookService.hotBook();
		
		boolean result = ordersService.add(isPay, nowTime, cus, orderBook);
		
		model.addAttribute("name", name);
		model.addAttribute("newbook", newbook);
		model.addAttribute("hotbook", hotbook);
	
		if(isPay==1) {
			return "shop/yOrder";
		}else {
			return "shop/nOrder";
		}
		
	}
	//查找所有订单返回后台管理
	@RequestMapping("/selectAllOrders")
	public String findAll(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
	        String pageNo = request.getParameter("pageNo");
	        if (pageNo == null) {
	            pageNo = "1";
	        }
	        Page page = ordersService.queryForPage(Integer.valueOf(pageNo), 5);
	        request.setAttribute("page", page);
	        List<Orders> list = page.getOlist();
	        modelMap.put("orderslist", list);
	    return "admin/OrderList";
	}
	//查找指定订单返回图书商城
		@RequestMapping("/selectOrdersToShop")
		public String selectOrdersToShop(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String name) {   
		        String pageNo = request.getParameter("pageNo");
		        if (pageNo == null) {
		            pageNo = "1";
		        }
		        int id = customerService.selectByName(name).getCustomerId();
		        Page page = ordersService.queryForPage1(Integer.valueOf(pageNo), 3, id);
		        request.setAttribute("page", page);
		        List<Orders> list = page.getOlist();
		        modelMap.put("orderslist", list);
		        modelMap.put("name", name);
		    return "shop/OrderList";
		}
	//删除订单列表
	@RequestMapping("/deleteOrderList")
	public String deleteOrderList(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        Page page = ordersService.queryForPage(Integer.valueOf(pageNo), 5);
        request.setAttribute("page", page);
        List<Orders> list = page.getOlist();
        modelMap.put("orderslist", list);
        return "admin/DeleteOrdersList";
	}
	//删除订单
	@RequestMapping("/deleteOrders")
	public String delete(Model model,int[] orderIds) {
		boolean result = ordersService.delete(orderIds);
		
		return "redirect:deleteOrderList.do";
	}
	//删除订单返回图书商城
	@RequestMapping("/delete1")
	public String delete1(Model model,int[] orderIds,RedirectAttributes attr,String name) {
		boolean result = ordersService.delete1(orderIds);
		attr.addFlashAttribute("name", name);
		return "redirect:selectOrdersToShop1.do";
	}
	@RequestMapping("/selectOrdersToShop1")
	public String selectOrdersToShop1(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@ModelAttribute("name")String name) {   
	        String pageNo = request.getParameter("pageNo");
	        if (pageNo == null) {
	            pageNo = "1";
	        }
	        int id = customerService.selectByName(name).getCustomerId();
	        Page page = ordersService.queryForPage1(Integer.valueOf(pageNo), 3, id);
	        request.setAttribute("page", page);
	        List<Orders> list = page.getOlist();
	        modelMap.put("orderslist", list);
	    return "shop/OrderList";
	}
	//查找订单
	@RequestMapping("/selectOrders")
	public String selectOrders(Model model,Customer cus) {
		List<Orders> orderslist = ordersService.selectByName(cus.getCustomerName());
		model.addAttribute("orderslist",orderslist );
		return "admin/SelectOrdersPage";
	}
}
