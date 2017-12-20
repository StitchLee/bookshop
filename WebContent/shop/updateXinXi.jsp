<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="<%=path%>/shop/templatemo_style.css" />


<link rel="stylesheet" href="<%=path%>/admin/assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="<%=path%>/admin/assets/css/admin.css">


</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
             <li><a href="<%=path%>/goTo.do?name=${customer.customerName}" class="current">主页</a></li>
            <li><a href="subpage.html">搜索</a></li>
            <li><a href="subpage.html">图书馆</a></li>            
            <li><a href="subpage.html">资讯</a></li>  
            <li><a href="#">公司</a></li> 
            <li><a href="#">联系我们</a></li>
            <li><a href="<%=path%>/admin/login.jsp">管理员登录</a></li>
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p style=" font-size:30px;color:white;margin-left:35px;margin-top:0px">
                欢迎您：
        	</p>
        </div>
        	
        
        <div id="templatemo_new_books">
        	<p style="margin-left: 65px;margin-top:10px;font-size:30px;color:white">
				${customerName}
        	</p>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>Categories</h1>
                <ul>
                    <li><a href="index.html">Donec accumsan urna</a></li>
                    <li><a href="index.html">Proin vulputate justo</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Aliquam tristique dolor</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">Sed pellentesque placerat</a></li>
                    <li><a href="#">Suspen disse</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
            	</ul>
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Bestsellers</h1>
                <ul>
                    <li><a href="#">Vestibulum ullamcorper</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Praesent mattis varius</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Flash Templates</a></li>
                    <li><a href="#">CSS Templates</a></li>
                    <li><a href="#">Web Design</a></li>
                    <li><a href="http://www.photovaco.com" target="_parent">Free Photos</a></li>
            	</ul>
            </div>
            
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
			</div>
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right" >
        	
            <h1><span style="margin-left:290px">详细信息</span></h1>   
      <div class="fbneirong">
      		<form:form modelAttribute="customer" class="am-form" action="updateCus.do" method="post">
      			<form:hidden path="customerId"/>
        			<div class="am-form-group am-cf">
         			 	<div class="zuo"style="width:80px;margin-left:43px">用户名：</div>
         			 	<div class="you">
            				<form:input type="text"   path="customerName"/>
          				</div>
       				</div>
       				<div class="am-form-group am-cf">
         			 	<div class="zuo" style="width:100px;margin-left:24px">密码：</div>
         			 	<div class="you">
            				<form:input type="text"   path="customerPwd"/>
          				</div>
       				</div>
        			<div class="am-form-group am-cf">
         			 	<div class="zuo" style="width:200px;margin-left:-75px">联系电话：</div>
         			 	<div class="you">
            				<form:input type="text"   path="customerTel"/>
          				</div>
       				</div>
        			<div class="am-form-group am-cf">
         			 	<div class="zuo" style="width:200px;margin-left:-75px">邮箱地址：</div>
         			 	<div class="you">
            				<form:input type="text"   path="customerEmail"/>
          				</div>
       				</div>
        			<div class="am-form-group am-cf">
         			 	<div class="zuo" style="width:200px;margin-left:-75px">收货地址：</div>
         			 	<div class="you">
            				<form:input type="text"   path="customerAddr"/>
          				</div>
       				</div>       		
        		<div class="am-form-group am-cf">
          			<div class="you" style="margin-left: 45%;">
              			<button type="submit" class="am-btn am-btn-success am-radius">修改</button>
              			<font color="red">${success} </font>
       					 <font color="red">${error} </font>
          			</div>
        		</div>    
        	</form:form>
		</div>
            	
            	
            	
				<div class="cleaner_with_height">&nbsp;</div>
            
            <a href="index.html"><img src="<%=path%>/shop/images/templatemo_ads.jpg" alt="css template ad" /></a>
            
        </div> <!-- end of content right -->
    
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    
    <div id="templatemo_footer">
	       <a href="index.html">Home</a> | <a href="index.html">Search</a> | <a href="index.html">Books</a> | <a href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a> 
        <!-- Credit: www.templatemo.com -->
	</div> <!-- end of footer -->
<!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<!-- templatemo 086 book store -->
<!-- 
Book Store Template 
http://www.templatemo.com/preview/templatemo_086_book_store 
-->
</body>
</html>