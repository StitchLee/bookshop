<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=path%>/admin/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="<%=path%>/admin/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path%>/admin/assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="<%=path%>/admin/assets/css/admin.css">
<script src="<%=path%>/admin/assets/js/jquery.min.js"></script>
<script src="<%=path%>/admin/assets/js/app.js"></script>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->






</head>

<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="<%=path%>/admin/assets/i/logo.png"></div>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

   <li class="am-dropdown tognzhi" data-am-dropdown>
  <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o" data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">6</span></button>
  <ul class="am-dropdown-content"> 	
    <li class="am-dropdown-header">所有消息都在这里</li>    
  </ul>
</li>

 <li class="kuanjie">
 	
 	<a href="#">会员管理</a>           
 	<a href="#">订单管理</a>   
 	<a href="#">产品管理</a> 
 	<a href="#">个人中心</a> 
 <a href="<%=path%>/index.html">退出登录</a>
 </li>

 <li class="soso">
 	
<p>   
	
	<select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
          <option value="b">全部</option>
          <option value="o">产品</option>
          <option value="o">会员</option>
          
        </select>

</p>

<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="圆角表单域" /></p>
<p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
 </li>




      <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main"> 

<div class="nav-navicon admin-main admin-sidebar">
    
    
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：${name}</div>
    <div class="sideMenu">
      <h3 class="am-icon-flag"><em></em> <a href="<%=path%>/admin/index.jsp">商品管理</a></h3>
      <ul>
        <li><a href="<%=path%>/page.do">商品列表</a></li>
        <li><a href="<%=path%>/admin/selectBook.jsp">搜索商品</a></li>
        <li class="func" dataType='html' dataLink='msn.htm' iconImg='images/msn.gif'><a href="<%=path%>/admin/addbooklist.jsp">添加新商品</a></li>
        <li><a href="<%=path%>/deletelist.do">删除商品</a></li>
        <li><a href="<%=path%>/updatelist.do">修改商品信息</a></li>
        <li><a href="<%=path%>/admin/addtype.jsp">增加商品类别</a></li>
      </ul>
      <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 订单管理</a></h3>
      <ul>
         <li><a href="<%=path%>/selectAllOrders.do"> 订单列表</a></li>
        			<li><a href="<%=path%>/deleteOrderList.do"> 删除订单</a></li>
        			<li><a href="<%=path%>/admin/SelectOrders.jsp"> 搜索订单</a></li>
      </ul>
      <h3 class="am-icon-users"><em></em> <a href="#">会员管理</a></h3>
      <ul>
        <li><a href="<%=path%>/cpage.do">会员列表</a></li>
        <li><a href="<%=path%>/deletecuslist.do">删除会员</a></li>
      </ul>
      <h3 class="am-icon-volume-up"><em></em> <a href="#">信息通知</a></h3>
  
    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script> 

    
    
    
    
    
    
    
</div>

<div class=" admin-content">
	
		<div class="daohang">
			<ul>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </li>
						
			</ul>	
</div>
	
	


<div class="admin-biaogelist">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on"> 栏目名称</ul>     
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">商品列表</a></dl>     
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
  <ul>
    <li>
      <div class="am-btn-group am-btn-group-xs">
        <select data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}" onchange="window.location=this.value;">
       <option value="a">图书分类</option>
          <option value="<%=path%>/typepage.do?typeId=1">小说类</option>
          <option value="<%=path%>/typepage.do?typeId=2">科技类</option> 
          <option value="<%=path%>/typepage.do?typeId=3">历史类</option> 
          <option value="<%=path%>/typepage.do?typeId=4">儿童文学类</option> 
         
        </select>
      </div>
    </li>
  </ul>
</div>


    <form class="am-form am-g">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success">
                <th class="table-id">ID</th>
                <th class="table-title">名称</th>  
                <th class="table-type">作者</th>
                <th class="table-type">价格</th>
                <th class="table-type">封面</th>
                <th class="table-type">出版社</th>
                <th class="table-type">分类</th>
               	
              </tr>
            </thead>
            <tbody>
              	<c:forEach items="${booklist}" var="book">
					<tr> 
						<td>${book.bookId}</td>
						<td>${book.bookName}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.bookPrice}</td>
						<td><img alt="头像" src="${book.bookPic}" /></td>
						<td>${book.bookPress}</td>
						<td>${book.booktype.booktypeName}</td>
					</tr>
				</c:forEach>
            </tbody>
         </table>
            </form>
 <table style="margin-left: 430px">
       <tr>
            <td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br>            
                <a href="<%=request.getContextPath()%>/typepagetwo.do?pageNo=${page.topPageNo}&typeId=${typeId}"><input type="button" name="fristPage" value="首页" /></a>
                <c:choose>
                  <c:when test="${page.pageNo!=1}">             
                      <a href="<%=request.getContextPath()%>/typepagetwo.do?pageNo=${page.previousPageNo }&typeId=${typeId}"><input type="button" name="previousPage" value="上一页" /></a>                
                  </c:when>
                  <c:otherwise>   
                      <input type="button" disabled="disabled" name="previousPage" value="上一页" />       
                  </c:otherwise>
                </c:choose>
                <c:choose>
                  <c:when test="${page.pageNo != page.totalPages}">
                    <a href="<%=request.getContextPath()%>/typepagetwo.do?pageNo=${page.nextPageNo }&typeId=${typeId}"><input type="button" name="nextPage" value="下一页" /></a>
                  </c:when>
                  <c:otherwise>    
                      <input type="button" disabled="disabled" name="nextPage" value="下一页" />
                  </c:otherwise>
                </c:choose>
                <a href="<%=request.getContextPath()%>/typepagetwo.do?pageNo=${page.bottomPageNo}&typeId=${typeId}"><input type="button" name="lastPage" value="尾页" /></a>
            </td>
        </tr>
     </table>
 
 
 
 <div class="foods">
  <ul>
    版权所有@2015. 模板收集自 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> -  More Templates<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
  </ul>
  <dl>
    <a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
  </dl>
</div>




</div>

</div>




</div> 
<script src="assets/js/amazeui.min.js"></script>
</body>
</html>