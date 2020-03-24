/**
 * 添加商品，用于用户从商品详情信息
 * 页码中把商品加入到购物车中
 * @param object（商品对象）
 **/
function addcommodity(object)
 {  
   var commodityid=object.parentNode.id;
   var number=document.getElementById("number").innerHTML;
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
   var url ="/shoppingcart/add?id="+commodityid+"&userid="+sessionStorage.getItem('phone')+"&number="+number;
   xmlHttp.open("GET", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);  
 }

/**
 * 关注商品，用于用户从商品详情信息
 * 页码中把商品加入到用户的关注中
 * @param object（商品对象）
 **/
function addconcerncommodity()
{
  var commodityid=document.getElementById("introduce-comm-name").parentNode.id;
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
  var url ="/concerncommodity/add?userid="+sessionStorage.getItem('phone')+"&commodityid="+commodityid;
  xmlHttp.open("POST", url, false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
  xmlHttp.send(null);  
}

/**
 * 修改商品数量，用于修改商品详情页面商品
 * 的数量，当用户添加时可以选择数量
 * @param object（点击按钮+或者-）
 **/
function updatenumber(obecjt)
 {  
   var childs=obecjt.parentNode.children;
   var information=obecjt.parentNode.parentNode.id+",";
   if(obecjt.innerHTML=="-"&&childs[0].innerHTML!="1")
	 childs[0].innerHTML=parseInt(childs[0].innerHTML)-parseInt("1");
   if(obecjt.innerHTML=="+")
	 childs[0].innerHTML=parseInt(childs[0].innerHTML)+parseInt("1");
 }