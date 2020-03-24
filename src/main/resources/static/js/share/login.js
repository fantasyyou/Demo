/**
 * 用户登录，用于登录界面时登录使用
 * 第一步获取用户输入的手机号和登录密码
 * 第二步判断是否为空
 * 第三步访问后台，查询用户是否存在可用
 * 验证失败给出提示，验证成功跳转到主页
 * @returns
 **/
function login()
  { 
    var phone=document.getElementById("phone").value; 
    var logincode=document.getElementById("logincode").value; 
    if(phone==""||phone==" ")
       {
    	 document.getElementById("prompt").innerHTML="请输入用户名";
       }
    if(logincode==""||logincode==" ")
	   {
    	 document.getElementById("prompt").innerHTML="请输入密码";
	   }
    if((phone==""||phone==" ")&&(logincode==""||logincode==" "))
       {
    	 document.getElementById("prompt").innerHTML="请输入用户名和密码";
       }
    
    if((phone!=""&&phone!=" ")&&(logincode!=""&&logincode!=" "))
      { 
    	document.getElementById("prompt").innerHTML="";
	    var xmlHttp = null;
	    try{
		     xmlHttp = new XMLHttpRequest();
	       } 
		catch (e) {
			 try {
			       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				 } catch (e) {
					   alert("Your browser does not support XMLHTTP!");
					   return;
					}
			 }
	    xmlHttp.onreadystatechange = function() {
	       if (xmlHttp.readyState == 4) {
		      if (xmlHttp.status == 200) {	
		         s = xmlHttp.responseText;
			     if(s=="验证失败")		      
			       document.getElementById("prompt").innerHTML="用户名不存在或密码错误!";
			     else
			       { 
			    	 cancel_shield();
			    	 sessionStorage.setItem('phone',phone);     
			    	 sessionStorage.setItem('name',s);
			    	 window.location.href="../user/homepage.html";	
			       }
		      }
		    else 
		      alert(xmlHttp.status);
	       }
	     }     
        var url ="/user/login?phone="+phone+"&code="+logincode;
        xmlHttp.open("GET", url, false);
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
        xmlHttp.send(null);
      }
  }

/**
 * 动态登录界面，在点击购物车，个人中心等
 * 标签时，动态检测用户是否登录。
 * 如果没有登录，打开登录窗口
 * @returns
 **/
function shield(){
   document.getElementById("prompt").innerHTML="";
   var test=document.getElementById("test");
   test.style.display="block"; 
   var loginarea=document.getElementById("login-area");   
   loginarea.style.display="block";
}

/**
 * 动态登录界面关闭
 * @returns
 **/
function cancel_shield(){
   var test=document.getElementById("test");
   test.style.display="none"; 
   var loginarea=document.getElementById("login-area");
   loginarea.style.display="none";
}
