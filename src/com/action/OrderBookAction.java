package com.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Book;
import com.bean.OrderBook;
import com.service.BookService;
import com.service.OrderBookService;

@Controller
public class OrderBookAction {
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

	public OrderBookService getOrderBookService() {
		return orderBookService;
	}

	public void setOrderBookService(OrderBookService orderBookService) {
		this.orderBookService = orderBookService;
	}
	//添加信息详细页
	@RequestMapping("/addOrderDetail")
	public String addOrderDetail(HttpServletRequest request,HttpServletResponse response,Model model,@ModelAttribute("name")String name,@ModelAttribute("amount")int[] amount,@ModelAttribute("orderBook")OrderBook orderBook,@ModelAttribute("newbook")Book newbook,@ModelAttribute("sum")int sum,@ModelAttribute("count")int count,@ModelAttribute("bookSet")Set<Book> bookSet) {
		
//		System.out.println(name);
//		System.out.println(newbook.getBookName());
//		System.out.println(count);
//		System.out.println(sum);
//		System.out.println("图书列表"+bookSet.size());
				
		orderBook.setTotalMoney(sum);
		orderBook.setBookAmount(count);	
		orderBook.setBookSet(bookSet);
		
		boolean result = orderBookService.add(orderBook,bookSet,count,sum);
		int id = orderBook.getOrderBookId();
		
//		for(int i = 0;i < amount.length;i++) {
//			System.out.println("数量："+amount[i]);
//		}
		Book hotbook = bookService.hotBook();
		

		model.addAttribute("name", name);
		model.addAttribute("newbook", newbook);
		model.addAttribute("amount", amount);
		model.addAttribute("sum", sum);
		model.addAttribute("bookSet", bookSet);
		model.addAttribute("detailId",id);
		model.addAttribute("hotbook", hotbook);
		return "shop/isOrder";
	}
	
	
}
