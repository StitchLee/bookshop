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
	//����ͼ���б�
	@RequestMapping("/selectAll")
	public String selectAll(Model model,String errormsg) {
		List<Book> list = bookService.selectAll();
		model.addAttribute("booklist",list);
		model.addAttribute("errormsg", errormsg);
		return "admin/booklist";		
	}
	//����ͼ��
	@RequestMapping("/selectBook")
	public String selectBook(Model model,Book book) {
		Book book1 = bookService.selectByName(book.getBookName());
		model.addAttribute("book", book1);
		return "admin/selectBookPage";
	}
	//����ͼ��
	@RequestMapping("add")
	public String add(Model model,Book book) {
		boolean result = bookService.add(book);
		if(result) {
			model.addAttribute("success","����ͼ��ɹ�");
			return "admin/addbooklist";
		}else {
			model.addAttribute("errormsg", "����ͼ��ʧ��");
			return "admin/addbooklist";
		}
	}
	//ɾ��ͼ����б�
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
	//ɾ��ͼ��
	@RequestMapping("delete")
	public String delete(Model model,int[] bookIds) {
		boolean result = bookService.delete(bookIds);
		
		return "redirect:deletelist.do";
	}
	//����ͼ����б�
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
	//���и���ͼ��
	@RequestMapping("/updatejsp")
	public String updatejsp(Model model,Integer id) {
		//�������ݿ�
		Book book = bookService.selectById(id);	
		model.addAttribute("book",book);
		return "admin/updatebooklist";
	}
	//����ͼ��
	@RequestMapping("update")
	public String update(Model model,Book book) {
		boolean result = bookService.update(book);
		if(result) {
			model.addAttribute("success","����ͼ��ɹ�");
			return "admin/updatebooklist";
		}else {
			model.addAttribute("errormsg", "����ͼ��ʧ��");
			return "admin/updatebooklist";
		}
	}
	//����booktypeId���в�ѯ
//	@RequestMapping("/typelist")
//	public String typelist(Model model,Integer typeId) {
//		//�������ݿ�
//		List<Book> list = bookService.selectBytype(typeId);
//		model.addAttribute("typelist",list);
//		return "admin/typelist";
//	}

	//�ҵ����еļ�¼��ʵ���˷�ҳ�����غ�̨����ҳ�棩
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
	//�ҵ�������ļ�¼��ʵ���˷�ҳ�����غ�̨������棩
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
			
	//�ҵ����еļ�¼��ʵ���˷�ҳ������ͼ���̳ǽ��棩
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
	//�ҵ�������ļ�¼��ʵ���˷�ҳ������ͼ���̳ǽ��棩
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
	
		
	//��¼��ת
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
	//������ҳ
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
	//��ת��xinxiҳ��
		@RequestMapping("/goToXinXi")
		public String giToXinxi(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@ModelAttribute("customer")Customer customer) {   
		    
		        Book newbook = bookService.newBook();
		        modelMap.put("newbook", newbook);
		        Book hotbook = bookService.hotBook();
		        modelMap.put("hotbook", hotbook);
		        
		    return "shop/xinxi";
		}
	//��ѯ��������ͼ��
		@RequestMapping("/newbook")
		public String newBook(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@ModelAttribute("name")String name,RedirectAttributes attr) {
			Book book = bookService.newBook();
			attr.addFlashAttribute("name", name);
			attr.addFlashAttribute("newbook", book);
			
			return "redirect:loginpage.do";
		}
	//������ҳ��
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
	//ɾ�����ﳵ��Ʒ
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
			System.out.println("ͼ���Id"+bookIds3);
			
			session.removeAttribute("bookSet");
			session.setAttribute("bookIds", bookIds3);
			session.setAttribute("bookSet", bookSet);
			model.addAttribute("bookSet",bookSet);
			model.addAttribute("bookIds",bookIds3);
			return "shop/bookcar";
		}
	
	//��ת�����ﳵ����
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
//			System.out.println("ͼ���id"+bookIds);
			
			session.removeAttribute("bookSet");
			session.setAttribute("bookSet", bookSet2);
			session.setAttribute("bookIds", bookIds);
			session.setAttribute("book2", book2);
			model.addAttribute("bookIds",bookIds);
			model.addAttribute("bookSet",bookSet2);
			return "shop/bookcar";
		}
	//��תȷ������ҳ��
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
			
//			System.out.println("�ܼ�Ϊ"+sum);
//			System.out.println("������Ϊ"+count);
			System.out.println("��������"+orderBook.getBookAmount());
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
