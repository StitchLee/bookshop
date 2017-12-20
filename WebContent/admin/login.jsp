<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/login.css" />
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">管理员登录</div>
        <div class="login_form">
			<form id="Login" name="Login" method="post" onsubmit="" action="<%=path%>/login.do">
				<li class="login-item" style="list-style:none">
					<span>用户名</span>
					<input type="text" name="adminName" class="login_input">
				</li>
				<li class="login-item">
					<span>密码</span>
					<input type="password" name="adminPwd" class="login_input">
				</li>
				<div class="clearfix"></div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
				</li>                      
           </form>
           <font color="red">${errormsg} </font>
		</div>
	</div>
</div>
</body>
</html>