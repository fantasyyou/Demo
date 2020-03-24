/**
 * 全部选中，用于选择订单的所有商品
 * @param id（全选框ID）
 * 用于判断当前是选中还是未选中
 * 选中取消全部选中，否则选中
 * 所有商品
 **/
function allelection(id)  //设置全部选中或全部未选中
 { 
   var object=document.getElementById(id);
   if(object.checked==true)
	 { 
	   var childs=document.getElementById("bi-comm-area").children;
	   for(var i=0;i<childs.length;i++)
		   document.getElementById(childs[i].id+"-total").checked=true;
	   document.getElementById("total-1").checked=true;
	   document.getElementById("total-2").checked=true;
	 }
   else
	 { 
	   var childs=document.getElementById("bi-comm-area").children;
	   for(var i=0;i<childs.length;i++)
		 document.getElementById(childs[i].id+"-total").checked=false;	
	   document.getElementById("total-1").checked=false;
	   document.getElementById("total-2").checked=false;
	 }
 }

/**
 * 单件选中，用于选择订单的单件商品
 * @param id（商品选中框ID）
 * 用于判断当前是选择还是未选择
 * 选择中取消选中，否则选中商品
 **/
function singleelection(id)
 {
   var object=document.getElementById(id);
   if(object.checked==false)
	 {
	   document.getElementById("total-1").checked=false;
	   document.getElementById("total-2").checked=false;	   
	 }
   else
	 {
	   var bool=true;
	   var childs=document.getElementById("bi-comm-area").children;
	   for(var i=0;i<childs.length;i++)
		 {
		   if(document.getElementById(childs[i].id+"-total").checked==false)
		     bool=false;
		 }
	   if(bool==true)
		  {
		    document.getElementById("total-1").checked=true;
		    document.getElementById("total-2").checked=true;			   
		  }
	 }
 }

/**
 * 修改商品数量，用于对订单商品的数量进行修改
 * @param obecjt（用户选择对象，+或者-）
 * 第一步对页面进行修改，包括数量，价格
 * 第二步访问后台修改购物车中商品的数量
 **/
function updatenumber(obecjt)
{  
  var childs=obecjt.parentNode.children;
  var information=obecjt.parentNode.parentNode.id+",";
  if(obecjt.innerHTML=="-"&&childs[1].innerHTML!="1")
	  {
	    var child=obecjt.parentNode.parentNode.children;
	    childs[1].innerHTML=parseInt(childs[1].innerHTML)-parseInt("1");
	    child[6].innerHTML=parseFloat(child[6].innerHTML)-parseFloat(child[4].innerHTML);
	    information+=childs[1].innerHTML;
	    document.getElementById("total-number").innerHTML=parseInt(document.getElementById("total-number").innerHTML)-parseInt("1");
 	    document.getElementById("total-price").innerHTML=parseFloat(document.getElementById("total-price").innerHTML)-parseFloat(child[4].innerHTML);
	  }
  if(obecjt.innerHTML=="+")
	  { 
	    var child=obecjt.parentNode.parentNode.children;
	    childs[1].innerHTML=parseInt(childs[1].innerHTML)+parseInt("1");
	    child[6].innerHTML=parseInt(child[6].innerHTML)+parseInt(child[4].innerHTML);
	    information+=childs[1].innerHTML;
	    document.getElementById("total-number").innerHTML=parseInt(document.getElementById("total-number").innerHTML)+parseInt("1");
 	    document.getElementById("total-price").innerHTML=parseFloat(document.getElementById("total-price").innerHTML)+parseFloat(child[4].innerHTML);
	  }
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
  var url ="/shoppingcart/update?id="+obecjt.parentNode.parentNode.id+"&userid="+sessionStorage.getItem('phone')+"&number="+childs[1].innerHTML;
  xmlHttp.open("POST", url, false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
  xmlHttp.send(null); 
}

/**
 * 修改我关注栏中的商品
 * @param obecjt（用户选择对象，上一页（＜）或者下一页（＞））
 * 首先判断用户选择的页码，然后访问后台返回数据
 **/
function updateconcerncommodity(object)  //查询我的关注商品
 { 
   var start=parseInt(sessionStorage.getItem('concerncommodity-start')); //读取当前关注商品位置
   if(object.innerHTML=="＜"&&start>=5)  //获得用户请求
	   start=start-5;
   else if(object.innerHTML=="＜"&&start<5)  //获得用户请求
	  return;
   else if(object.innerHTML=="＞")  //获得用户请求
	  start=start+5; 
   var child=document.getElementById("bi-comm-title").children;
   child[0].style.color="#000000";
   child[1].style.color="#FF0000";
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
   	         s=xmlHttp.responseText;   //接受json数据
   	         if(s=="[]")  //判断返回的数据是否为[],是则表示为空，同时下标减5，即回到上一页，效果为最后一页无法跳转下一页
   	        	 {  	        	
   	        	   sessionStorage.setItem('concerncommodity-start',start=start-5);
   	        	   return;
   	        	 }
   	         var jsonobject=JSON.parse(s);
   	         var concerncommodity="<div class='update' style='margin-top:130px;' onclick='updateadarea(this)'>＜</div>";
   	         for(var i=0;i<jsonobject.length;i++)
   	           {
        		 concerncommodity=concerncommodity+"<div id="+jsonobject[i].id+" class='bi-ad-comm'>"+
                 "<div class='ad-comm-img' style='background:url(../../images/commodity/book.png); background-size:100% 100%;' onclick='querycommodityinformation(this)'></div>"+
                 "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>"+jsonobject[i].name+"</a></div>"+
                 "<div class='ad-comm-price'>"+jsonobject[i].price+"</div>"+
                 "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
                 "</div>";
   	           }
   	        concerncommodity=concerncommodity+"<div class='update' style='margin-top:130px; margin-left:976px;' onclick='updateadarea(this)'>＞</div>";
   	        
   	        document.getElementById("bi-ad-comm-area").innerHTML=concerncommodity; 
   	     }
   	    else  	      
   	      alert(xmlHttp.status);
   	    sessionStorage.setItem('concerncommodity-start',start);
      }
    } 
   var url ="/concerncommodity/query?userid="+sessionStorage.getItem('phone')+"&start="+start;
   xmlHttp.open("GET", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null); 
 }

/**
 * 修改订单，根据用户选中的商品和用户
 * 选择（删除，移动，关注）对所选中
 * 的商品进行相应的操作，删除为从购物
 * 车中删除，移动为从购物中删除，添加
 * 到关注，关注为把商品添加到关注商品
 * 当中
 **/
function operationbill(object)
{
  var childs=document.getElementById("bi-comm-area").children;
  var commodityid=object.innerHTML+","+sessionStorage.getItem('phone')+",";
  for(var i=0;i<childs.length;i++)
	 {	
	   if(document.getElementById(childs[i].id+"-total").checked==true)
	     commodityid=commodityid+childs[i].id+",";
	 }
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
  if(object.innerHTML=="删除选中的商品"||object.innerHTML=="移到我的关注")
	 { 
      for(var i=childs.length-1;i>0;i--)
   	 { 
   	   if(document.getElementById(childs[i].id+"-total").checked==true)
   		 { 
   		   var number=document.getElementById(childs[i].id+"-number").innerHTML;
   		   var price=childs[i].children[6].innerHTML;
   		   var totalnumber=document.getElementById("total-number").innerHTML;
   		   var totalprice=document.getElementById("total-price").innerHTML;
   		   document.getElementById("total-number").innerHTML=parseInt(totalnumber)-parseInt(number);
   		   document.getElementById("total-price").innerHTML=parseFloat(totalprice)-parseFloat(price);	
   		   document.getElementById("bi-comm-area").removeChild(childs[i]);	   		   
   		 }
   	 }
	   if(document.getElementById(childs[0].id+"-total").checked==true)
		 {
		   var number=document.getElementById(childs[0].id+"-number").innerHTML;
		   var price=childs[0].children[6].innerHTML; 
		   var totalnumber=document.getElementById("total-number").innerHTML;
		   var totalprice=document.getElementById("total-price").innerHTML;
		   document.getElementById("total-number").innerHTML=parseInt(totalnumber)-parseInt(number);
		   document.getElementById("total-price").innerHTML=parseFloat(totalprice)-parseFloat(price);	
		   document.getElementById("bi-comm-area").removeChild(childs[0]);
		 }
	 }
  var url ="/bill/update?commodityid="+encodeURI(commodityid);
  xmlHttp.open("GET", url, false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
  xmlHttp.send(null); 
}

/**
 * 修改商品，根据用户选中的商品和用户
 * 选择（删除，移动，关注）对所选中
 * 的商品进行相应的操作，删除为从购物
 * 车中删除，移动为从购物中删除，添加
 * 到关注，关注为把商品添加到关注商品
 * 当中
 * @param object（选择对象，即删除，移动，关注标签）
 * 这是针对单件商品的修改
 **/
function operationcommodity(object)
{
  var commodityid=object.innerHTML+","+sessionStorage.getItem('phone')+",";
  commodityid=commodityid+object.parentNode.parentNode.parentNode.id;
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
  if(object.innerHTML=="删除"||object.innerHTML=="移到我的关注")
	  { 
	    var number=document.getElementById(object.parentNode.parentNode.parentNode.id+"-number").innerHTML;
	    var price=object.parentNode.parentNode.parentNode.children[6].innerHTML; 
	    var totalnumber=document.getElementById("total-number").innerHTML;
	    var totalprice=document.getElementById("total-price").innerHTML;
	    document.getElementById("total-number").innerHTML=parseInt(totalnumber)-parseInt(number);
	    document.getElementById("total-price").innerHTML=parseFloat(totalprice)-parseFloat(price);	
	    document.getElementById("bi-comm-area").removeChild(object.parentNode.parentNode.parentNode);	
	  }
  var url ="/bill/update?commodityid="+encodeURI(commodityid);
  xmlHttp.open("GET", url, false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
  xmlHttp.send(null); 
}

/**
 * 修改随手购中的商品
 **/
function updateadcommodity()
{ 
  var child=document.getElementById("bi-comm-title").children;
  child[0].style.color="#FF0000";
  child[1].style.color="#000000";
  var childs=document.getElementById("bi-ad-comm-area").children;
  if(childs[1].id=="106")
	 { 
	   var recommend="<div class='update' style='margin-top:130px;' onclick='updateadarea(this)'>＜</div>"+
	   "<div id='101' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥13.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='102' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥93.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='103' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥147.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='104' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥195.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='105' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥78.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
      "<div class='update' style='margin-top:130px; margin-left:976px;' onclick='updateadarea(this)'>＞</div>";
	   document.getElementById("bi-ad-comm-area").innerHTML=recommend; 
	 } 
  else
	 { 
	   var recommend="<div class='update' style='margin-top:130px;' onclick='updateadarea(this)'>＜</div>"+
	   "<div id='106' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥148.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='107' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥68.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='108' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥58.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div id='109' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥174.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
      "<div id='110' class='bi-ad-comm'>"+
      "<div class='ad-comm-img' onclick='querycommodityinformation(this)' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>"+
      "<div class='ad-comm-name' onclick='querycommodityinformation(this)'><a>Java EE互联网轻量级框架整合开发 SSM框架 (Spring MVC+Spring+MyBatis)和Redis实现 </a></div>"+
      "<div class='ad-comm-price'>￥79.00</div>"+
      "<div class='ad-comm-add' onclick='addbillcommodity(this)'>加入购物车</div>"+
      "</div>"+
	   "<div class='update' style='margin-top:130px; margin-left:976px;' onclick='updateadarea(this)'>＞</div>";
	   document.getElementById("bi-ad-comm-area").innerHTML=recommend; 
	 }	 
}

/**
 * 修改随手购和我的关注标签颜色
 * 颜色为红为当前选中的状态
 **/
function updateadarea(object)
{
  var childs=document.getElementById("bi-comm-title").children;
  if(childs[0].style.color=="rgb(255, 0, 0)")
    updateadcommodity();	
  else
	 updateconcerncommodity(object);	
}

/**
 * 添加商品，用于把用户从随手购或者
 * 关注栏中的商品加入购物车
 * @param object（添加的商品对象）
 **/
function addbillcommodity(object)
{ 
  var commodityid=object.parentNode.id;
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
	  	         var commodityset=document.getElementById("bi-comm-area").innerHTML
	  	         commodityset=commodityset+"<div id="+jsonobject.id+" class='bi-comm'>"+
	              "<div class='bi-store'><a>"+jsonobject.store+"</a></div>"+
		       	  "<input style='float:left; margin-top:15px;' type='checkbox' id='"+jsonobject.id+"-total' onclick='singleelection('this.id')'>"+
		       	  "<div class='bi-comm-img' style='background:url(../../images/commodity/"+jsonobject.img+".png); background-size:100% 100%;'></div>"+					       	   
		          "<div class='bi-comm-name'><a>"+jsonobject.name+"</a></div>"+
		          "<div class='bi-comm-price'>"+jsonobject.price+"</div>"+
		       	  "<div class='bi-comm-number'>"+
		       	     "<div class='bi-reduce' onclick='updatenumber(this)'>-</div>"+
		       	     "<div id='"+jsonobject.id+"-number' class='bi-quantity'>1</div>"+
		       	     "<div class='bi-add' onclick='updatenumber(this)'>+</div>"+
		       	  "</div>"+
		       	  "<div class='bi-comm-price' style='margin-left:0px;'>"+jsonobject.subtotal+"</div>"+
		       	  "<div class='bi-comm-operate'>"+
		       	     "<div><a onclick='operationcommodity(this)'>删除</a></div>"+
		       	     "<div style='clear:left;'><a onclick='operationcommodity(this)'>移到我的关注</a></div>"+
		       	     "<div style='clear:left;'><a onclick='operationcommodity(this)'>加到我的关注</a></div>"+
		       	  "</div>"+
		          "</div>";
			     document.getElementById("total-number").innerHTML=parseInt(document.getElementById("total-number").innerHTML)+parseInt("1");
			  	 document.getElementById("total-price").innerHTML=parseFloat(document.getElementById("total-price").innerHTML)+parseFloat(jsonobject.price);	
	  	         document.getElementById("bi-comm-area").innerHTML=commodityset;
	  	      }
	  	    else 
	  	      alert(xmlHttp.status);
	     }
	   }
  var url ="/shoppingcart/add?id="+commodityid+"&userid="+sessionStorage.getItem('phone')+"&number=1";
  xmlHttp.open("GET", url, false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
  xmlHttp.send(null);  
}