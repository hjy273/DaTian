﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no" />
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>

<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
/* $().ready(function() {  
	//alert("test");
$("#loginForm").validate({  
   rules: {  
   username: "required",    
   password: {  
    required: true,  
    minlength: 5  
   }  
},  
   messages: {  
   username: "请输入姓名",   
   password: {  
    required: "请输入密码",  
    minlength: $.validator.format("密码不能小于{0}个字符")  
   } 
}  
    });  
});  */

</script>
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
<form action="login" name="loginForm" method="post" id="loginForm">
	<div class="div_login_left">
    	<div class="div_login_sub1">
        	登录&nbsp;&nbsp;${msg }
        </div>
    	<div class="div_login_sub2">
			<div class="div_login_sub2a">
            	<div class="div_login_sub2as">
            		
                    <input name="username" type="text" class="input_login1" placeholder="帐户" required/>
                    <input name="password" type="password" class="input_login1" placeholder="密码" required/>   
                    
				</div>
            </div>
			<div class="div_login_sub2b">
            	<input type="submit" id="btn2" value="登&nbsp;录" class="submit_login" hidefocus="true" />          
            </div>
           	
        </div>
       			<br/>
       	 <div class="div_login_sub3">
        	<input type="radio" name="userkind" value="2" checked="checked"/>&nbsp;个人用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="userkind" value="3"/>企业用户
        </div>
        	<br/>
    	<div class="div_login_sub3">
        	<input type="checkbox" />&nbsp;自动登录&nbsp;&nbsp;|&nbsp;&nbsp;忘记密码
        </div>
	</div>
	</form>
	<div class="div_login_right">
    	<div class="div_login_sub1">
        	加入我们
        </div>
    	<div class="div_login_sub4">
        	现在可以简单、快速的成为会员！<br />
            加入会员后可以享受我们提供的快捷服务！<br />
            <input type="button" id="btn2" value="注册" class="submit_login1" hidefocus="true" onclick="window.location.href='registerForm'" />
        </div>
	</div>
</div>

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
</html>