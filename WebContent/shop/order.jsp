<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%String path = request.getContextPath(); %>
<%@page import = "com.bean.Book" %>
<%@page import="java.util.List"%>
<%@page import = "com.dao.BookDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="<%=path%>/shop/templatemo_style.css" />
<link rel="stylesheet" href="<%=path%>/admin/assets/css/tab.css"/>


</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
            <li><a href="<%=path%>/goToMain.do?name=${name}" class="current">主页</a></li>
            <li><a href="<%=path%>/bookpage.do?name=${name}&id=${newbook.bookId}">商品分类</a></li>
            <li><a href="<%=path%>/selectOrdersToShop.do?name=${name}">订单详情</a></li>            
            <li><a href="#">资讯</a></li>  
            <li><a href="#">公司</a></li> 
            <li><a href="#">联系我们</a></li>
            <li><a href="<%=path%>/admin/login.jsp">管理员登录</a></li>
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p style=" font-size:30px;margin-left:35px;margin-top:10px">
                欢迎您：
        	</p>
			
        </div>       
        <div id="templatemo_new_books">
        	<p style="margin-left: 65px;margin-top:20px;font-size:20px">
				<a href="<%=path%>/selectByName.do?name=${name}">${name}</a>
        	</p>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	 	<div class="templatemo_content_left_section">
            	<h1 style="color:white">最新商品</h1>
                <div class="templatemo_product_box">
              	<h1>${newbook.bookName}</h1>
   	      <img src="${newbook.bookPic}" alt="image" />
                <div class="product_info">
                	<p>类别：${newbook.booktype.booktypeName}</p>
                		<p>作者：${newbook.bookAuthor}</p>
                		<p>出版社：${newbook.bookPress}</p>
                  		<h3>价格:${newbook.bookPrice}元</h3>
                    <div class="buy_now_button"><a href="#">Buy Now</a></div>
                    
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            </div>
			<div class="templatemo_content_left_section">
            	<h1 style="color:white">热销商品</h1>
                <div class="templatemo_product_box">
            	<h1>${hotbook.bookName}</h1>
   	      <img src="${hotbook.bookPic}" alt="image" />
                <div class="product_info">
                	<p>类别：${hotbook.booktype.booktypeName}</p>
                		<p>作者：${hotbook.bookAuthor}</p>
                		<p>出版社：${hotbook.bookPress}</p>
                  		<h3>价格:${hotbook.bookPrice}元</h3>
                    <div class="buy_now_button"><a href="#">Buy Now</a></div>
                    
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            </div>
          
        </div> <!-- end of content left -->
        	
        <div id="templatemo_content_right" >       	
            <h1><span style="margin-left:280px">订单详情</span></h1>   
      		<div class="fbneirong" style="color:white">
      			<form action="isOrder.do?book=${book}&name=${name}&bookIds1=${bookIds} " method="post">
      			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" style="background-color: #f9f9f9;color:black">
            		<thead>
              			<tr class="am-success">
              			<th class="table-type">操作</th>
                		<th class="table-id">订单ID</th>
                		<th class="table-title">书名</th>              		 
                		<th class="table-type">价格</th>
                		<th class="table-type">数量</th>
                		<th class="table-type">总价</th> 
               	        </tr>
            		</thead>
            		<tbody style="color:black">
            		<c:forEach items="${bookSet}" var="book">
            		<tr> 
						<td><div style="margin-left:10px;margin-top:60px"><a href="<%=path%>/carDelete.do?name=${name}&bookId=${book.bookId}&bookIds1=${bookIds}">删除</a></div></td>
						<td><div style="margin-left:10px;margin-top:60px">${book.bookId}</div></td>
						<td><div style="margin-left:10px;margin-top:60px">${book.bookName}</div></td>
						<td><div style="margin-left:25px;margin-top:10px"><img alt="头像" src="${book.bookPic}"/></div></td> 
						<td><div style="margin-left:10px;margin-top:60px">${book.bookPrice}</div></td>
						<td><div style="margin-left:40px;margin-top:60px"><input type="text" name="bookAmount"></input></div></td>
					</tr>
					</c:forEach>
            		</tbody>
            		<div class="am-form-group am-cf">
          			<div class="you" style="margin-left:293px;">
            		<button type="submit" class="am-btn am-btn-success am-radius">提交订单</button>
            			</div>
        		</div>  
         		</table>
          </form>
        		
		</div>
            	
            	
            	
				<div class="cleaner_with_height">&nbsp;</div>
       
            
            <a href="subpage.html"><img src="<%=path%>/shop/images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    	
    </div> <!-- end of content -->
    
    <div id="templatemo_footer">
    
	       <a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a> 
        <!-- Credit: www.templatemo.com -->	</div> 
    <!-- end of footer -->
<!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<!-- templatemo 086 book store -->
<!-- 
Book Store Template 
http://www.templatemo.com/preview/templatemo_086_book_store 
-->
</body>
</html>