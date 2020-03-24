/**
 * 动态校验用户注册信息，用于判断
 * 用户名和用户手机号是否存在，存
 * 在则提示用户信息存在，否则关闭
 * 提示标签
 * @returns
 **/
function provingName()  
 { 
   var name=document.getElementById("name").value; 
   if(name==""||name==" ")
	 {
	   document.getElementById('prompt_1').style.display="none";
	   document.getElementById('getcode').style.marginTop="40px";
	 }
   else
	 {
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
			     if(s=="用户不存在")
			       {
			  	     document.getElementById('prompt_1').style.display="none";
				     document.getElementById('getcode').style.marginTop="40px";
			       }
			     else
			       {
			  	     document.getElementById("prompt_1").innerHTML="用户名或手机号已注册";
				     document.getElementById('prompt_1').style.display="block";
				     document.getElementById('getcode').style.marginTop="14px";
			       }
		      }
		    else 
		      alert(xmlHttp.status);
	      }
	    } 
	   var url ="/register/query?phone="+sessionStorage.getItem('phone')+"&name="+name;
	   xmlHttp.open("GET", url, false);
	   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	   xmlHttp.send(null);   
	 }
 }

/**
 * 监测code(密码)输入框，用于判断
 * 用户输入的密码是否一致，不一致
 * 给出提示，一致则关闭提示标签
 * @returns
 **/
function judgecode()  
 { 
   var code=document.getElementById("code").value; 
   var confirm=document.getElementById("confirm").value; 
   if(code==confirm)
     { 
	   document.getElementById('prompt_2').style.display="none";
	   document.getElementById('confirmcode').style.marginTop="40px";
     }
   else
	 { 
	   document.getElementById("prompt_2").innerHTML="密码不一致";
	   document.getElementById('prompt_2').style.display="block";
	   document.getElementById('confirmcode').style.marginTop="14px";
	 }
 }

/**
 * 用户注册前进行信息校验，判断用户
 * 信息是否为空，若存在为空则提示用
 * 户，并判断用户手机号是否可用，通
 * 过判断是否有提示标签的方式进行判
 * 断，都通过则调用registerconnect方法注册
 * @returns
 **/
function register()
 { 
   var name=document.getElementById("name").value; 
   var code=document.getElementById("code").value; 
   var confirm=document.getElementById("confirm").value; 
   if(name!=""&&name!=" ") //用户名不为空
	 {
	   if(code==confirm) //密码一致
    	 {
    	   if(code==""||code==" ") //密码为空
    		 {
        	   document.getElementById("prompt_2").innerHTML="密码为空";
        	   document.getElementById('prompt_2').style.display="block";
        	   document.getElementById('confirmcode').style.marginTop="14px";
    		 }
    	   else
    		 { 
    		   var str=document.getElementById('getcode').style.marginTop; //判断用户名或手机号是否可用
    		   if(str=="40px")
    		     registerconnect(name,code);
    		 }
    	 }
       else
    	 {
    	   document.getElementById("prompt_2").innerHTML="密码不一致";
    	   document.getElementById('prompt_2').style.display="block";
    	   document.getElementById('confirmcode').style.marginTop="14px";
    	 }
	 }
   else
	 {
	   document.getElementById("prompt_1").innerHTML="用户名为空";
	   document.getElementById('prompt_1').style.display="block";
	   document.getElementById('getcode').style.marginTop="14px";
	 }
 }

/**
 * 用户注册，访问后台并传递注册信息进行注册
 * @param name（用户名）code（用户密码）
 * @returns
 **/
function registerconnect(name,code)
 { 
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
	         window.location.href='login.jsp';
	      }
	    else 
	      alert(xmlHttp.status);
      }
    } 
   var url ="/register/user?phone="+sessionStorage.getItem('phone')+"&name="+name+"&code="+code;
   xmlHttp.open("POST", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);   	 
 }