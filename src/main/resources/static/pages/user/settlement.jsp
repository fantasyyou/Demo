<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/share/font.css" type="text/css">
<link rel="stylesheet" href="../../css/share/title.css" type="text/css">
<link rel="stylesheet" href="../../css/share/share.css" type="text/css">
<link rel="stylesheet" href="../../css/user/bill.css" type="text/css">
<link rel="stylesheet" href="../../css/user/settlement.css" type="text/css">
<title>FLC PLUS-网上商城</title>
</head>
<script type="text/javascript">
window.onload=function()
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
  	         s=xmlHttp.responseText;     //接受json数据
  	         var jsonobject=JSON.parse(s);
  	         var commodityset="";
  	         for(var i=0;i<jsonobject.length;i++)
	        	{ 
	        	  commodityset=commodityset+"<div id="+jsonobject[i].id+" class='bi-comm'>"+
	        	               "<div class='bi-store'><a>"+jsonobject[i].name+"</a></div>"+
					       	   "<input style='float:left; margin-top:15px;' type='checkbox' id='"+jsonobject[i].id+"-total' onclick='singleelection(this.id)'>"+
					       	   "<div class='bi-comm-img' style='background:url(../../images/commodity/"+jsonobject[i].img+".png); background-size:100% 100%;'></div>"+					       	   
					           "<div class='bi-comm-name'><a>"+jsonobject[i].introduce+"</a></div>"+
					           "<div class='bi-comm-price'>"+jsonobject[i].price+"</div>"+
					       	   "<div class='bi-comm-number'>"+
					       	      "<div class='bi-reduce' onclick='updatenumber(this)'>-</div>"+
					       	      "<div id='"+jsonobject[i].id+"-number' class='bi-quantity'>"+jsonobject[i].number+"</div>"+
					       	      "<div class='bi-add' onclick='updatenumber(this)'>+</div>"+
					       	   "</div>"+
					       	   "<div class='bi-comm-price' style='margin-left:0px;'>"+jsonobject[i].subtotal+"</div>"+
					       	   "<div class='bi-comm-operate'>"+
					       	      "<div><a onclick='operationcommodity(this)'>删除</a></div>"+
					       	      "<div style='clear:left;'><a onclick='operationcommodity(this)'>移到我的关注</a></div>"+
					       	      "<div style='clear:left;'><a onclick='operationcommodity(this)'>加到我的关注</a></div>"+
					       	   "</div>"+
					           "</div>";
	        	} 
  	         document.getElementById("bi-comm-area").innerHTML=commodityset;
  	      }
  	    else 
  	      alert(xmlHttp.status);
     }
   } 
  var url ="../../com/servlet/user/ManageSettlementServlet";
  xmlHttp.open("POST", url, false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
  xmlHttp.send(null); 
 }
</script>
<body class="body">
<div class="ti-top-title-area">
   <div class="title-left-260"><a onclick="javascript:{window.location.href='homepage.jsp'}">FLC PLUS首页</a></div>
   <div class="title-left-652"><a>fantasy</a></div>
   <div class="title-width-80"><a>免费注册</a></div>
   <div class="title"><strong>|</strong></div>
   <div class="title-width-80"><a>我的啄木鸟</a></div>
   <div class="title"><strong>|</strong></div>
   <div class="title-width-80"><a>个人中心</a></div>
</div>
<div class="bi-logo">
   <img class="logo-img" align="absmiddle" src="../../images/share/logo.jpg">
   <font class="f-25-STXinwei">啄木鸟</font>&nbsp;&nbsp;
   <span class="f-20-STHeiti">结算页</span>
</div>
<div class="bi-icon"></div>
<span class="tatble-title">填写并核对订单信息</span>
<div class="bi-table-area">
   <div class="information-title"><a>收货人信息</a></div>
   <div id="address-area">
      <div style="line-height:43px;">
         <div class="subnav-address">张三&nbsp;北京</div>
         &nbsp;&nbsp;<span>张三 </span>   
         <span>北京</span>   
         <span>宣武区</span>   
         <span>内环到三环里</span>   
         <span>展览馆路24外交学院</span>  
         &nbsp;&nbsp;<span>177****1675</span>  
      </div>
      <div style="line-height:43px;">
         <div class="subnav-address">张三&nbsp;北京</div>
         &nbsp;&nbsp;<span>张三 </span>   
         <span>北京</span>   
         <span>宣武区</span>   
         <span>内环到三环里</span>   
         <span>展览馆路24外交学院</span> 
         &nbsp;&nbsp;<span>177****1675</span>  
      </div>
      <div style="clear:both; margin-left:40px">收起地址</div> 
   </div>
   <div class="patch-line"></div>
   <div class="information-title"><a>支付方式</a></div>
   <div id="pay">
      <div class="subnav-address">货到付款</div>
      <div class="subnav-pay">在线支付</div>
   </div>
   <div class="patch-line"></div>
   <div class="information-title"><a>送货清单</a></div>
   <div id="comm-area">
   <div id="">
    <span style="margin-left:20px">蓝墨水图书专营店</span>
	<div class="bi-comm">
	   <div class="bi-comm-img" style="background:url(../../images/commodity/book.png); background-size:100% 100%;"></div>
	   <div class="bi-comm-name"><a>Java EE互联网轻量级框架整合开发 SSM框架（Spring MVC+Spring+MyBatis）和Redis实现 </a></div>
	   <div class="bi-comm-price">60.00</div>
	   <div class="bi-comm-number">1</div> 
	   <div class="bi-comm-operate">有货</div>
	</div>
    <div class="bi-comm">
	   <div class="bi-comm-img" style="background:url(../../images/commodity/book.png); background-size:100% 100%;"></div>
	   <div class="bi-comm-name"><a>Java EE互联网轻量级框架整合开发 SSM框架（Spring MVC+Spring+MyBatis）和Redis实现 </a></div>
	   <div class="bi-comm-price">60.00</div>
	   <div class="bi-comm-number">1</div> 
	   <div class="bi-comm-operate">有货</div>
	</div>
    <span style="margin-left:20px">蓝墨水图书专营店</span>
	<div class="bi-comm">
	   <div class="bi-comm-img" style="background:url(../../images/commodity/book.png); background-size:100% 100%;"></div>
	   <div class="bi-comm-name"><a>Java EE互联网轻量级框架整合开发 SSM框架（Spring MVC+Spring+MyBatis）和Redis实现 </a></div>
	   <div class="bi-comm-price">60.00</div>
	   <div class="bi-comm-number">1</div> 
	   <div class="bi-comm-operate">有货</div>
	</div>
    <div class="bi-comm">
	   <div class="bi-comm-img" style="background:url(../../images/commodity/book.png); background-size:100% 100%;"></div>
	   <div class="bi-comm-name"><a>Java EE互联网轻量级框架整合开发 SSM框架（Spring MVC+Spring+MyBatis）和Redis实现 </a></div>
	   <div class="bi-comm-price">60.00</div>
	   <div class="bi-comm-number">1</div> 
	   <div class="bi-comm-operate">有货</div>
	</div>
   </div>
   </div>
</div>
</body>
</html>