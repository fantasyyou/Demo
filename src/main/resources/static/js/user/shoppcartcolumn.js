/**
 * 打开购物车栏
 **/
function shoppcartmove() {
   //if(document.getElementById("all-shoppcart-goods").children.length==0)
   shoppcartcolumnquery();
   document.getElementById("shoppcart-column").style.display="block";
   document.getElementById("patch-line-shoppcart").style.display="block";
   document.getElementById("shoppcart").style.backgroundColor='#FFFFFF';
   document.getElementById("shoppcart").style.borderBottom='0px';
   document.getElementById("shoppcart").style.height="43px";
   document.getElementById("shoppcart").style.boxShadow="0px 0px 3px #aaa";
 }

/**
 * 关闭购物车栏
 **/
function shoppcartout() {
   document.getElementById("shoppcart-column").style.display="none";
   document.getElementById("patch-line-shoppcart").style.display="none";
   document.getElementById("shoppcart").style.backgroundColor='#F0F0F0';
   document.getElementById("shoppcart").style.borderBottom='1px solid #ADADAD';
   document.getElementById("shoppcart").style.height="42px";
   document.getElementById("shoppcart").style.boxShadow="0px 0px 0px #aaa";
 }

/**
 * 购物车商品查询，用于查询用户的购物车信息
 * 第一步访问后台进行查询
 * 第二步对查询的数据进行动态的展示
 **/
function shoppcartcolumnquery()
 { 
   var phone = sessionStorage.getItem('phone');
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
	         var obj =JSON.parse(s);
	         var comminformation="";   //购物车里的商品信息
	         for(var i=0;i<obj.length-1;i++)
	           {
	        	 comminformation=comminformation+"<div id="+obj[i].id+" class='sc-comm'>" +
	        	 "<div class='sc-comm-img' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'></div>" +
	        	 "<div class='sc-comm-name'>"+obj[i].name+"</div>"+
	        	 "<div class='sc-comm-price'><span style='float:right'>￥"+obj[i].price+" ×"+obj[i].number+"</span>" +
	        	 "<a style='float:right; clear:both' onclick='deleteshoppcartgoods(this)'>删除</a></div></div>"
	           }
	         document.getElementById("all-shoppcart-goods").innerHTML=comminformation;
	         document.getElementById("shoppcart-goods-total-number").innerHTML=obj[obj.length-1].totalnumber+"件";
	         document.getElementById("shoppcart-goods-total-price").innerHTML=obj[obj.length-1].totalprice;
	      }
	    else 
	      alert(xmlHttp.status);
      }
    } 
   var url ="/shoppingcart/query?userid="+sessionStorage.getItem('phone');
   xmlHttp.open("GET", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);  
 }

/**
 * 删除一个购物车中的商品，用户
 * 可以选择删除按钮删除一个商品
 * 之后返回后台删除这个商品在数据
 * 库中的记录
 * @param object（删除商品对象）
 **/
function deleteshoppcartgoods(object)
 {
   var id=object.parentNode.parentNode.id;
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
   var url ="/shoppingcart/delete?id="+id+"&userid="+sessionStorage.getItem('phone');
   xmlHttp.open("POST", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);
   shoppcartcolumnquery();
 }

/**
 * 添加一个商品到购物车中，用户
 * 可以选择加入购物车标签将商品
 * 加入到自己的购物车之中，之后
 * 访问后台在购物车信息中加一条
 * 用户的数据
 * @param object（添加商品对象）
 **/
function addshoppcartcommodity(object)
 {  
   var commodityid=object.parentNode.parentNode.id;
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
   var url ="/shoppingcart/add?id="+commodityid+"&userid="+sessionStorage.getItem('phone')+"&number=1";
   xmlHttp.open("GET", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);  
   shoppcartcolumnquery();
 }