package com.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bean.Book;
import com.bean.Customer;
import com.bean.OrderBook;
import com.bean.Page;
import com.service.BookService;

@Controller
public class BookAction {
	@Autowired
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	//查找图书列表
	@RequestMapping("/selectAll")
	public String selectAll(Model model,String errormsg) {
		List<Book> list = bookService.selectAll();
		model.addAttribute("booklist",list);
		model.addAttribute("errormsg", errormsg);
		return "admin/booklist";		
	}
	//查找图书
	@RequestMapping("/selectBook")
	public String selectBook(Model model,Book book) {
		Book book1 = bookService.selectByName(book.getBookName());
		model.addAttribute("book", book1);
		return "admin/selectBookPage";
	}
	//增加图书
	@RequestMapping("add")
	public String add(Model model,Book book) {
		boolean result = bookService.add(book);
		if(result) {
			model.addAttribute("success","插入图书成功");
			return "admin/addbooklist";
		}else {
			model.addAttribute("errormsg", "插入图书失败");
			return "admin/addbooklist";
		}
	}
	//删除图书的列表
	@RequestMapping("/deletelist")
//	public String deletelist(Model model,String errormsg) {
//		List<Book> list = bookService.deletelist();
//		model.addAttribute("booklist",list);
//		model.addAttribute("errormsg", errormsg);
//		return "admin/deletebooklist";
//	}
	public String deletelist(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 3);
        request.setAttribute("page", page);
        List<Book> list = page.getList();
        modelMap.put("booklist", list);
        return "admin/deletebooklist";
}
	//删除图书
	@RequestMapping("delete")
	public String delete(Model model,int[] bookIds) {
		boolean result = bookService.delete(bookIds);
		
		return "redirect:deletelist.do";
	}
	//更新图书的列表
	@RequestMapping("/updatelist")
//	public String updatelist(Model model,String errormsg) {
//		List<Book> list = bookService.updatelist();
//		model.addAttribute("booklist",list);
//		model.addAttribute("errormsg", errormsg);
//		return "admin/update";
//	}
	public String updatelist(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 3);
        request.setAttribute("page", page);
        List<Book> list = page.getList();
        modelMap.put("booklist", list);
    return "admin/update";
}
	//进行更新图书
	@RequestMapping("/updatejsp")
	public String updatejsp(Model model,Integer id) {
		//访问数据库
		Book book = bookService.selectById(id);	
		model.addAttribute("book",book);
		return "admin/updatebooklist";
	}
	//更新图书
	@RequestMapping("update")
	public String update(Model model,Book book) {
		boolean result = bookService.update(book);
		if(result) {
			model.addAttribute("success","插入图书成功");
			return "admin/updatebooklist";
		}else {
			model.addAttribute("errormsg", "插入图书失败");
			return "admin/updatebooklist";
		}
	}
	//根据booktypeId进行查询
//	@RequestMapping("/typelist")
//	public String typelist(Model model,Integer typeId) {
//		//访问数据库
//		List<Book> list = bookService.selectBytype(typeId);
//		model.addAttribute("typelist",list);
//		return "admin/typelist";
//	}

	//找到所有的记录并实现了分页（返回后台管理页面）
	@RequestMapping("/page")
	public String findAll(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
	        String pageNo = request.getParameter("pageNo");
	        if (pageNo == null) {
	            pageNo = "1";
	        }
	        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 5);
	        request.setAttribute("page", page);
	        List<Book> list = page.getList();
	        modelMap.put("booklist", list);
	    return "admin/booklist";
	}
	//找到各分类的记录并实现了分页（返回后台管理界面）
			@RequestMapping("/typepage")
			public String findType(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,int typeId) {   
			        String pageNo = request.getParameter("pageNo");
			        if (pageNo == null) {
			            pageNo = "1";
			        }
			        Page page = bookService.queryTypeForPage(Integer.valueOf(pageNo), 5,typeId);
			        request.setAttribute("page", page);
			        List<Book> list = page.getList();
			        modelMap.put("booklist", list);
			        modelMap.put("typeId", typeId);
			    
			    return "admin/typelist";
			}
			@RequestMapping("/typepagetwo")
			public String findTypetwo(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String typeId) {   
			        String pageNo = request.getParameter("pageNo");
			        if (pageNo == null) {
			            pageNo = "1";
			        }
			        int id = Integer.parseInt(typeId);
			        Page page = bookService.queryTypeForPage(Integer.valueOf(pageNo), 5,id);
			        request.setAttribute("page", page);
			        List<Book> list = page.getList();
			        modelMap.put("booklist", list);
			        modelMap.put("typeId", id);
			    return "admin/typelist";
			}
			
	//找到所有的记录并实现了分页（返回图书商城界面）
	@RequestMapping("/bookpage")
	public String findAllbook(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String name) {   
	        String pageNo = request.getParameter("pageNo");
	        if (pageNo == null) {
	            pageNo = "1";
	        }
	        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 6);
	        request.setAttribute("page", page);
	        List<Book> list = page.getList();
	        modelMap.put("booklist", list);
	        modelMap.put("name", name);
	        Book newbook = bookService.newBook();
	        
	        Book hotbook = bookService.hotBook();
	        modelMap.put("newbook", newbook);
	        modelMap.put("hotbook", hotbook);
	    return "shop/classify";
	}
	//找到各分类的记录并实现了分页（返回图书商城界面）
		@RequestMapping("/booktypepage")
		public String findTypebook(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,int typeid,String name,int id) {   
		        String pageNo = request.getParameter("pageNo");
		        if (pageNo == null) {
		            pageNo = "1";
		        }
		        Page page = bookService.queryTypeForPage(Integer.valueOf(pageNo), 6,typeid);
		        request.setAttribute("page", page);
		        List<Book> list = page.getList();
		        modelMap.put("booklist", list);
		        modelMap.put("name",name);
		        Book newbook = bookService.selectById(id);
		        Book hotbook = bookService.hotBook();
		        modelMap.put("newbook",newbook);
		        modelMap.put("hotbook", hotbook);
		        modelMap.put("typeid", typeid);
		    return "shop/booktype";
		}
		@RequestMapping("/booktypepagetwo")
		public String findTypebooktwo(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String typeid,String name) {   
		        String pageNo = request.getParameter("pageNo");
		        if (pageNo == null) {
		            pageNo = "1";
		        }
		        int bid = Integer.parseInt(typeid);
		        Page page = bookService.queryTypeForPage(Integer.valueOf(pageNo), 6,bid);
		        request.setAttribute("page", page);
		        List<Book> list = page.getList();
		        modelMap.put("booklist", list);
		        modelMap.put("name",name);
		        Book newbook = bookService.newBook();
		        Book hotbook = bookService.hotBook();
		        modelMap.put("newbook",newbook);
		        modelMap.put("hotbook", hotbook);
		        modelMap.put("typeid", bid);
		    return "shop/booktype";
		}
	
		
	//登录跳转
		@RequestMapping("/loginpage")
		public String loginPage(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@ModelAttribute("name")String name,@ModelAttribute("newbook")Book newbook) {   
		        String pageNo = request.getParameter("pageNo");
		        if (pageNo == null) {
		            pageNo = "1";
		        }
		        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 6);
		        request.setAttribute("page", page);
		        List<Book> list = page.getList();
		        modelMap.put("booklist", list);
		       Book hotbook = bookService.hotBook();
		       modelMap.put("hotbook", hotbook);
		    return "shop/main";
		}
	//返回主页
		@RequestMapping("/goToMain")
		public String giToMain(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String name) {   
		        String pageNo = request.getParameter("pageNo");
		        if (pageNo == null) {
		            pageNo = "1";
		        }
		        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 6);
		        request.setAttribute("page", page);
		        List<Book> list = page.getList();
		        modelMap.put("booklist", list);
		        modelMap.put("name", name);
		        Book newbook = bookService.newBook();
		        modelMap.put("newbook", newbook);
		        Book hotbook = bookService.hotBook();
		        modelMap.put("hotbook", hotbook);
		        
		    return "shop/main";
		}
	//跳转到xinxi页面
		@RequestMapping("/goToXinXi")
		public String giToXinxi(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@ModelAttribute("customer")Customer customer) {   
		    
		        Book newbook = bookService.newBook();
		        modelMap.put("newbook", newbook);
		        Book hotbook = bookService.hotBook();
		        modelMap.put("hotbook", hotbook);
		        
		    return "shop/xinxi";
		}
	//查询最近加入的图书
		@RequestMapping("/newbook")
		public String newBook(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@ModelAttribute("name")String name,RedirectAttributes attr) {
			Book book = bookService.newBook();
			attr.addFlashAttribute("name", name);
			attr.addFlashAttribute("newbook", book);
			
			return "redirect:loginpage.do";
		}
	//加载首页面
		@RequestMapping("/indexPag")
		public String idenxPage(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {
			Book book = bookService.newBook();
			Book hotbook = bookService.hotBook();
			modelMap.put("newbook", book);
			modelMap.put("hotbook", hotbook);
			String pageNo = request.getParameter("pageNo");
	        if (pageNo == null) {
	            pageNo = "1";
	        }
	        Page page = bookService.queryForPage(Integer.valueOf(pageNo), 6);
	        request.setAttribute("page", page);
	        List<Book> list = page.getList();
	        modelMap.put("booklist", list);
			return "shop/index";
			}
	//删除购物车商品
		@RequestMapping("carDelete")
		public String carDelete(HttpServletRequest request,HttpSession session,Model model,String bookIds1,String name,int bookId) {			
			model.addAttribute("name",name);
			Book newbook = bookService.newBook();
			model.addAttribute("newbook", newbook);
			Book hotbook = bookService.hotBook();
		    model.addAttribute("hotbook", hotbook);
			
			Set<Book> bookSet = new HashSet<Book>();
			bookIds1 = bookIds1.substring(1, bookIds1.length()-1);
			String[] bookIds2 = bookIds1.split(", ");
			Integer[] bookIds = new Integer[bookIds2.length];
			for(int i =0;i<bookIds2.length;i++) {
				bookIds[i] = Integer.parseInt(bookIds2[i]);				
			}
			for(int i = 0;i < bookIds.length;i++) {
				if(Integer.valueOf(bookIds[i]) == bookId) {
					bookIds[i] = bookIds[bookIds.length-1];					
				}
			}
			bookIds = Arrays.copyOf(bookIds, bookIds.length-1);
			bookSet = bookService.searchBookByIds(bookIds);
			
			Set<Integer> bookIds3 = new HashSet<Integer>(Arrays.asList(bookIds));
			System.out.println("图书的Id"+bookIds3);
			
			session.removeAttribute("bookSet");
			session.setAttribute("bookIds", bookIds3);
			session.setAttribute("bookSet", bookSet);
			model.addAttribute("bookSet",bookSet);
			model.addAttribute("bookIds",bookIds3);
			return "shop/bookcar";
		}
	
	//跳转到购物车界面
		@RequestMapping("/bookcar")
		public String bookCar(HttpServletRequest request,HttpSession session,Model model,int bookid,String name) {
			model.addAttribute("name", name);
			Book newbook = bookService.newBook();
			model.addAttribute("newbook", newbook);
			Book hotbook = bookService.hotBook();
		    model.addAttribute("hotbook", hotbook);
			
			Set<Integer> bookIds = new HashSet<Integer>();
			Set<Book> bookSet = new HashSet<Book>();
			if(session.getAttribute("bookSet") == null) {
				session.setAttribute("bookSet", bookSet);
			}else {
				bookSet= (Set<Book>)session.getAttribute("bookSet");
			}
			Book book = bookService.selectById(bookid);
			bookSet.add(book);

			Iterator iterator = bookSet.iterator();
			Book book2 = null;
			while(iterator.hasNext()) {
				book2 = (Book)iterator.next();
				bookIds.add(book2.getBookId());
			}
			
			Set<Book> bookSet2 = new HashSet<Book>();			
			bookSet2 = bookService.searchBookByIds(bookIds);
//			System.out.println("图书的id"+bookIds);
			
			session.removeAttribute("bookSet");
			session.setAttribute("bookSet", bookSet2);
			session.setAttribute("bookIds", bookIds);
			session.setAttribute("book2", book2);
			model.addAttribute("bookIds",bookIds);
			model.addAttribute("bookSet",bookSet2);
			return "shop/bookcar";
		}
	//跳转确定订单页面
		@RequestMapping("/isOrder")
		public String isOrder(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,OrderBook orderBook,String bookIds1,String name,@RequestParam String[] bookAmount,RedirectAttributes attr) {
			Book newbook = bookService.newBook();
			
			Integer[] amount = new Integer[bookAmount.length];
			for(int i =0;i<bookAmount.length;i++) {
				amount[i] = Integer.parseInt(bookAmount[i]);				
			}
		
			Set<Book> bookSet = new HashSet<Book>();
			bookIds1 = bookIds1.substring(1, bookIds1.length()-1);
			String[] bookIds2 = bookIds1.split(", ");
			Integer[] bookIds = new Integer[bookIds2.length];
			for(int i =0;i<bookIds2.length;i++) {
				bookIds[i] = Integer.parseInt(bookIds2[i]);				
			}
			bookSet = bookService.searchBookByIds(bookIds);
			
			int sum = 0;
			for(int i = 0;i < amount.length; i++) {
				sum += amount[i] * bookService.selectById(bookIds[i]).getBookPrice();
			}
			
			int count = 0;
			for(int i = 0;i < amount.length;i++) {
				count += amount[i];
			}
			
//			System.out.println("总价为"+sum);
//			System.out.println("总数量为"+count);
			System.out.println("订单详情"+orderBook.getBookAmount());
		    session.removeAttribute("bookSet");
			
			attr.addFlashAttribute("name",name);
			attr.addFlashAttribute("newbook",newbook);
			attr.addFlashAttribute("bookSet",bookSet);
			attr.addFlashAttribute("sum",sum);
			attr.addFlashAttribute("count",count);
			attr.addFlashAttribute("amount", amount);
			attr.addFlashAttribute("orderBook",orderBook);
			return "redirect:addOrderDetail.do";
			
		}
		
	
		
}
