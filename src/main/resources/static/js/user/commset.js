/**
 * 用户动态更新商品展示界面，当用户选择分页
 * 或者排序方式时，动态更新页面
 * @param id（用户点击操作的ID，即分页或者
 * 排序标签的ID），用于判断用户进行的操作类型
 * @returns
 **/
function query(id)
 { 
   var sort=id;     //用户选择的排序方式
   var choice=id;   //用户的操作类型，分页或排序
   var current=1;   //用户当前浏览的页码
   var keyword = sessionStorage.getItem('keyword');
   if(id=="previous-page"||id=="next-page")  //选择了分页
	 {
	   var current=document.getElementById("current-page").innerHTML;
	   var total=document.getElementById("total-page").innerHTML;
	   if(id=="previous-page"&&current==1)  //判断是否选择了上一页并且当前页码=1
		   return;
	   if(id=="next-page"&&current==total)  //判断是否选择了下一页并且当前页码=总的页码
		   return;
	   for(var i=1;i<=4;i++)    //判读用户当前的排序方式
		 { 
		   var color=document.getElementById("sort-"+i).style.backgroundColor;
		   if(color=="rgb(255, 0, 0)")  //判读sort-i排序方式是否被选中
			 sort="sort-"+i;
		 }
	   choice=id;
	   current=document.getElementById("current-page").innerHTML;  
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
   xmlHttp.onreadystatechange = function() {
      if (xmlHttp.readyState == 4) {
	      if (xmlHttp.status == 200) {	
	         s=xmlHttp.responseText;     //接受json数据
	         if(id=="previous-page"||id=="next-page")
	           updatepaget(id)          //修改分页样式
	         else
	           updatesort(id);          //修改排序样式
  	         var object=JSON.parse(s);
  	         var commodityset="";
  	         for(var i=0;i<object.length;i++)
	        	{  
 	        	  commodityset=commodityset+"<div id="+object[i].id+" class='comm' onmousemove='move(this.id)' onmouseout='out(this.id)'>"+
                               "<div class='comm_img' style='background:url(../../images/commodity/book.png); background-size:100% 100%;'"+
                               "onclick='querycommodityinformation(this)'></div>"+
                               "<div class='comm_price'>"+object[i].price+"</div>"+
                               "<div class='comm_name' onclick='querycommodityinformation(this)'>"+object[i].name+"</div>"+
                               "<div class='comm_discuss'>"+object[i].discuss+"条评价</div>"+
                               "<div class='comm_store'>"+object[i].store+"</div>"+
                               "<div class='comm_operate'>"+
                                 "<div class='sidebar' onclick='addconcerncommodity(this)'>关注</div>"+
                                 "<div class='sidebar_input' onclick='addshoppcartcommodity(this)'>加入购物车</div>"+
                               "</div>"+
                               "</div>"; 
	        	}
  	         document.getElementById("commarea").innerHTML=commodityset;
	      }
	    else 
	      alert(xmlHttp.status);
      }
    } 
   var url ="/commodity/query/paging?keyword="+keyword+"&sort="+sort+"&choice="+choice+"&current="+current;
   xmlHttp.open("POST", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);  
 }

/**
 * 用于把商品添加到用户的购物车
 * @param object（用户点击的商品对象）
 * @returns
 */
function addconcerncommodity(object)
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
   var url ="/concerncommodity/add?userid="+sessionStorage.getItem('phone')+"&commodityid="+commodityid;
   xmlHttp.open("POST", url, false);
   xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
   xmlHttp.send(null);  
 }

/**
 * 跳转到商品的详细介绍界面
 * @param object（用户点击的商品对象）
 * @returns
 */
function querycommodityinformation(object) { 
	var commodityid=object.parentNode.id;
	window.open("commodityinformation.html?commodityid="+commodityid);
  }

/**
 * 用于修改页面的排序样式
 * @param id（选择的排序方式）
 * @returns
 */
function updatesort(id)
 {
   for(var i=1;i<=4;i++)  //全部修改为默认样式
	 { 
       document.getElementById("sort-"+i).style.backgroundColor='#FFFFFF';
	   document.getElementById("sort-"+i).style.color='#000000';
	 }
   document.getElementById(id).style.backgroundColor='#FF0000'; //选择的排序方式改为被选样式
   document.getElementById(id).style.color='#FFFFFF';
   document.getElementById("current-page").innerHTML=1;
 }

/**
 * 用于修改页面的页码样式
 * @param id（选择的操作，即上一页或者下一页）
 * @returns
 */
function updatepaget(id) 
 {
   if(id=="previous-page")
	 {
	   var current=parseInt(document.getElementById("current-page").innerHTML)-parseInt("1");
	   document.getElementById("current-page").innerHTML=current;
	 }
   else
     {
	   var current=parseInt(document.getElementById("current-page").innerHTML)+parseInt("1");
	   document.getElementById("current-page").innerHTML=current;
     }
 }