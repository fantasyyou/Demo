/**
 * 用户获取验证码，用于身份验证
 * 时，用于向后台发送请求，获取验证码
 * @param type（用户操作类型，包括注册
 * 和修改密码），发送给后台，后台判断
 * 用户操作并和验证码及用户手机号一起
 * 保存，便于后续对验证码进行校验
 * @returns
 **/
function send(type)
 {   	
  var phone=document.getElementById("phone").value; 
  if(phone==""||phone==" ")
     { 
	   document.getElementById("prompt_1").innerHTML="请输入手机号";
	   document.getElementById('prompt_1').style.display="block";
	   document.getElementById('getcode').style.marginTop="14px";
     }
  else if(phone!=""&&phone!=" "&&!(/^1[34578]\d{9}$/.test(phone)))
	 { 
	   document.getElementById("prompt_1").innerHTML="手机号格式错误";
	   document.getElementById('prompt_1').style.display="block";
	   document.getElementById('getcode').style.marginTop="14px";
	 }
  else 
    {   
	    document.getElementById('prompt_1').style.display="none";
	    document.getElementById('getcode').style.marginTop="40px";
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
			     names = s.split(",");
			     sessionStorage.setItem('register-phone',phone);  
		      }
		    else 
		      alert(xmlHttp.status);
	       }
	     } 
	    var url ="/verificationcode/send?phone="+phone+"&type="+encodeURI(type);
        xmlHttp.open("GET", url, false);
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
        xmlHttp.send(null);
    } 
 }

/**
 * 下一步跳转，跳转修改密码界面或注册界面
 * @param address（跳转页面名称，即两个
 * 界面的名称），type（跳转前需要对用户身份
 * 进行验证，这里是验证类型，包括修改密码和
 * 注册，用于后台判断用户需要进行的验证操作，
 * 便于后台进行验证码的校验
 * @returns
 **/
function next(address,type)
 { 
   var phone=document.getElementById("phone").value; 
   if(document.getElementById('getcode').style.marginTop=="40px"&&phone!=""&&phone!=" ")
	 {  
	    var code=document.getElementById("code").value;
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
		           { 
		     		 document.getElementById("prompt_2").innerHTML="验证码错误";
		     		 document.getElementById('prompt_2').style.display="block";
		     		 document.getElementById('next').style.marginTop="14px";
		           }
		         else
		      	    window.location.href=address;  //页面跳转
		      }
		    else 
		      alert(xmlHttp.status);
	       }
	     }     
	    var url ="/verificationcode/verification?phone="+phone+"&code="+code+"&type="+encodeURI(type);
	    xmlHttp.open("POST", url, false);
	    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	    xmlHttp.send(null);
	 }
 }

/**
 * 监测phone(手机号)输入框
 * 输入的手机号的值变化时利用正则表达式判断
 * 手机号不为空并且正则表达结果为false时，提示错误
 * 否则关闭提示标签
 * @returns
 **/
function judgephone()  
 { 
   var phone=document.getElementById("phone").value; 
   if(phone==""||phone==" "||(/^1[34578]\d{9}$/.test(phone)))
     { 
	    document.getElementById('prompt_1').style.display="none";
	    document.getElementById('getcode').style.marginTop="40px";
     }
   else if(phone!=""&&phone!=" "&&!(/^1[34578]\d{9}$/.test(phone)))
	 { 
	   document.getElementById("prompt_1").innerHTML="手机号格式错误";
	   document.getElementById('prompt_1').style.display="block";
	   document.getElementById('getcode').style.marginTop="14px";
	 }
 }

/**
 * 监测code(验证码)输入框
 * 输入的验证码的值变化时，关闭验证码输入结果的提示标签
 * @returns
 **/
function judgecode()  
 { 
   document.getElementById('prompt_2').style.display="none";
   document.getElementById('next').style.marginTop="40px";
 }