/**
 * 监测code(密码)输入框
 * 用于判断用户输入的密码是否一致
 * 不一致则提示用户
 * @returns
 **/
function judgecode()  //监测code(密码)输入框
 { 
   var code=document.getElementById("code").value; 
   var confirm=document.getElementById("confirm").value; 
   if(code==confirm)
     { 
	    document.getElementById('prompt_1').style.display="none";
	    document.getElementById('confirmcode').style.marginTop="40px";
     }
   else
	 { 
	   document.getElementById("prompt_1").innerHTML="密码不一致";
	   document.getElementById('prompt_1').style.display="block";
	   document.getElementById('confirmcode').style.marginTop="14px";
	 }
 }

/**
 * 修改密码，用于用户修改密码时使用
 * 第一步判断密码是否为空，且一致
 * 为空或者不一致给出提示
 * 第二步访问后台修改用户密码
 * @returns
 **/
function retrieve()
 { 
	var code=document.getElementById("code").value;
	var confirm=document.getElementById("confirm").value;
	if((code==""||code==" ")&&(confirm==""||confirm==" "))
	  {
		 document.getElementById("prompt_1").innerHTML="密码为空";
		 document.getElementById('prompt_1').style.display="block";
		 document.getElementById('confirmcode').style.marginTop="14px";
		
	  }
	else if(code!=confirm)
	  {
		 document.getElementById("prompt_1").innerHTML="密码不一致";
		 document.getElementById('prompt_1').style.display="block";
		 document.getElementById('confirmcode').style.marginTop="14px";
	  }
	else
	  {
	     document.getElementById('prompt_1').style.display="none";
	     document.getElementById('confirmcode').style.marginTop="40px";
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
	     var url ="/update/code?phone="+sessionStorage.getItem('phone')+"&code="+code;
	     xmlHttp.open("GET", url, false);
	     xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	     xmlHttp.send(null);		
	  }
 }