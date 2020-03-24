<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/user/login.css" type="text/css">
<title>FLC PLUS-网上商城</title>
<body>
<div id="test"></div>
<div id="test"></div>
<div id="login-area">
<div class="login-top-title">
   <span style="margin-left:10px">您尚未登录</span>
   <span style="float:right;margin-right:10px">X</span>
</div>
<div class="login-tips">不要轻易向他人转账,谨防诈骗</div>
<div class="login-title">账户登录</div>
<div id="prompt" class="prompt"></div>
<div style="margin:0 auto; width:273px; height:32px;">
<div class="login-img-title" style="background:url(../../images/share/用户.png); background-size:100% 100%;"></div>
<div class="login-div-input"><input class="login-input" type="text" id="phone" placeholder="用户名/已验证手机号"/></div>
</div>
<div style="margin:0 auto; width:273px; height:32px; margin-top:20px">
<div class="login-img-title" style="background:url(../../images/share/密码.png); background-size:100% 100%;"></div>
<div class="login-div-input"><input class="login-input" type="password" id="logincode" placeholder="密码"/></div>
</div>
<div class="login-jump-tips"><a href="../share/retrieve-1.jsp">忘记密码</a></div>
<div id="login-button">登&nbsp;&nbsp;&nbsp;&nbsp;录</div>
<div class="login-jump-tips" style="margin-top:50px; font-size:14px;">
   <img align="absmiddle" width=30px height=30px src="../../images/share/用户.png">
   <a style="color:red;" href="../share/register-1.jsp">立即注册</a>
</div>
</div>
</body>
</html>