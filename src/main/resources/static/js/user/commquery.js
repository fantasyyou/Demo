document.write("<script language=javascript src='../share/login.js'><\/script>");
/**
 * 根据关键字查询商品信息，之后跳转到
 * 商品展示界面
 **/
function commquery()  
 { 
   var keyword=document.getElementById("keyword").value;
   window.location.href="commset.html?keyword="+encodeURI(keyword);
 }

/**
 * 根据标签查询商品信息，之后跳转到
 * 商品展示界面
 * @param object（标签对象）
 **/
function titlequery(object)  
 { 
   var keyword=object.innerHTML
   window.location.href="commset.jsp?keyword="+encodeURI(keyword);
 }

/**
 * 跳转到订单界面，这里需要先检测用户
 * 是否已经登录，没有登录需要先登录
 **/
function jumpbill() { 
   var phone= sessionStorage.getItem('phone');  
   if(phone==null)
	  shield();   
   else
      window.location.href="bill.html";
 }

/**
 * 打开标签区域，用于用于移动到一个
 * 大标签时，展示其2，3级标签
 **/
function openarea(id)
 { 
   document.getElementById(id).style.background="#D0D0D0";
   document.getElementById("assort-area-"+id).style.display="block";
 }

/**
 * 关闭标签区域
 **/
function closearea(id)
 { 
   document.getElementById(id).style.background="#FFFFFF";
   document.getElementById("assort-area-"+id).style.display="none";
 }