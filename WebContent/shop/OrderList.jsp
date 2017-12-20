<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="<%=path%>/shop/templatemo_style.css" />


<link rel="stylesheet" href="<%=path%>/admin/assets/css/tab.css"/>
<link rel="stylesheet" href="<%=path%>/admin/assets/css/admin.css">


</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
             <li><a href="<%=path%>/goToMain.do?name=${name}" class="current">主页</a></li>
            <li><a href="<%=path%>/bookpage.do?name=${name}&id=${newbook.bookId}">商品分类</a></li>
            <li><a href="<%=path%>/selectOrdersToShop.do?name=${name}">订单详情</a></li>            
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
				${name}
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
        	
            <h1><span style="margin-left:290px">订单详情</span></h1>   
      <form class="am-form am-g" method="post"  action="<%=path%>/delete1.do?name=${name}">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped "style="background-color: #f9f9f9;color:black">
            <thead>
              <tr class="am-success">
              	<th class="table-type">勾选</th>
                <th class="table-id">订单编号</th>  
                <th class="table-type">商品</th>
                <th class="table-type">数量(本)</th>
                <th class="table-type">总价(元)</th>
                <th class="table-type">是否支付</th>
                <th class="table-type">下单时间</th>
                <th class="table-type">收货地址</th>
               	
              </tr>
            </thead>
            <tbody>
              	<c:forEach items="${orderslist}" var="o">
					<tr> 
						<td><input type="checkbox" value= "${o.orderId}" name = "orderIds"></td>
						<td>${o.orderId}</td>
						<td>${o.bookSet}</td>
						<td>${o.bookAmonut}</td>
						<td>${o.totalMoney}</td>						
						<c:if test="${o.isPay == '0'}">
							<td>否</td>
						</c:if>
						<c:if test="${o.isPay == '1'}">
							<td>是</td>
						</c:if>
						<td>${o.orderTime}</td>
						<td>${o.customerAddr}</td>
					</tr>
				</c:forEach>
            </tbody>
         </table>
         <input type="submit" class="am-btn am-btn-success am-radius" value="删除订单" style="margin-left:300px"></input>
          </form> 
          <table style="margin-left:420px">
       <tr>
            <td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br>            
                <a href="<%=request.getContextPath()%>/selectOrdersToShop.do?pageNo=${page.topPageNo}&name=${name}"><input type="button" name="fristPage" value="首页" /></a>
                <c:choose>
                  <c:when test="${page.pageNo!=1}">             
                      <a href="<%=request.getContextPath()%>/selectOrdersToShop.do?pageNo=${page.previousPageNo }&name=${name}"><input type="button" name="previousPage" value="上一页" /></a>                
                  </c:when>
                  <c:otherwise>   
                      <input type="button" disabled="disabled" name="previousPage" value="上一页" />       
                  </c:otherwise>
                </c:choose>
                <c:choose>
                  <c:when test="${page.pageNo != page.totalPages}">
                    <a href="<%=request.getContextPath()%>/selectOrdersToShop.do?pageNo=${page.nextPageNo }&name=${name}"><input type="button" name="nextPage" value="下一页" /></a>
                  </c:when>
                  <c:otherwise>    
                      <input type="button" disabled="disabled" name="nextPage" value="下一页" />
                  </c:otherwise>
                </c:choose>
                <a href="<%=request.getContextPath()%>/selectOrdersToShop.do?pageNo=${page.bottomPageNo}&name=${name}"><input type="button" name="lastPage" value="尾页" /></a>
            </td>
        </tr>
     </table>
            	
            	
            	
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