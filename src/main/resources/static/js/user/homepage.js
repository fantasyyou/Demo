/**
 * 修改主页下方的几个推荐商品信息
 **/
function updaterecommend()
 { 
   var childs=document.getElementById("recommend").children;
   if(childs[1].id=="recommend-1")
	 { 
	   var recommend="<div style='float:left; width:200px; height:100%; background:url(../../images/commodity/picc.jpg); background-size:100% 100%;'></div>"+
	   "<div id='recommend-6' style='float:left; width:204px; height:100%; background:#FFFFFF; font-family:Microsoft YaHei;'>"+
	   "<div class='update' style='margin-top:100px;' onclick='updaterecommend()'>＜</div>"+      
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic6.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>迷你充电宝  10000毫安  移动电源  快充  大容量  超薄便携</div>"+
	   "<div style='width:183px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>59.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>128.00</span></div>"+
	   "</div>"+
	   "</div>"+	   
	   "<div id='recommend-7' class='recommend'>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic7.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>稚优泉  橄榄润唇膏  保湿滋润  补水无色  防干裂  嘴部护理  学生</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>29.90</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>39.90</span></div>"+
	   "</div>"+
	   "</div>"+
	   "<div id='recommend-8' class='recommend'>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic8.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>韩国原装  进口 全南蜂蜜柚子茶 泡水喝的饮品 水果茶  冲饮果酱</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>39.50</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>49.50</span></div>"+
	   "</div>"+
	   "</div>"+
	   "<div id='recommend-9' class='recommend'>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic9.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>MIJIA 米家FKR-35GW-B1ZM-M3 小米 变频冷暖 静音挂机 智能空调</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>1999.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>2586.00</span></div>"+
	   "</div>"+
	   "</div>"+
	   "<div id='recommend-10' class='recommend'>"+
	   "<div class='update' style='margin-top:100px; margin-left:178px;' onclick='updaterecommend()'>＞</div>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic10.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>马丁男士 古龙洗发水 沐浴露套装 持久留下 去头皮屑 止头痒 洗头膏洗浴</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>98.80</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>168.00</span></div>"+
	   "</div>"+
	   "</div>"+
	   "</div>";
	   document.getElementById("recommend").innerHTML=recommend; 
	 }
   else
	 { 
	   var recommend="<div style='float:left; width:200px; height:100%; background:url(../../images/commodity/picc.jpg); background-size:100% 100%;'></div>"+
	   "<div id='recommend-1' style='float:left; width:204px; height:100%; background:#FFFFFF; font-family:Microsoft YaHei;'>"+
	   "<div class='update' style='margin-top:100px;' onclick='updaterecommend()'>＜</div>"+      
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic1.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>Acer/宏碁 蜂鸟3 SF314旗舰版 轻薄 14英寸八代i5 便携手提女生笔记本</div>"+
	   "<div style='width:183px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>5499.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>6099.00</span></div>"+
	   "</div>"+
	   "</div>"+	   
	   "<div id='recommend-2' class='recommend'>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic2.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>森麦  魔鬼猫音魔  耳机头戴式  电脑游戏吃鸡手机耳麦 重低音音乐带话筒隔音降噪</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>168.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>269.00</span></div>"+
	   "</div>"+
	   "</div>"+
	   "<div id='recommend-3' class='recommend'>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic3.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>美可卓 澳洲进口 成人奶粉蓝胖子脱脂牛奶粉低脂女士冲饮早餐</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>128.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>196.00</span></div>"+
	   "</div>"+
	   "</div>"+
	   "<div id='recommend-4' class='recommend'>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic4.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>OliviaBurton  腕表  英国小众 手表dw/ob手表女士正品简约潮流石英表</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>880.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>1690.00</span></div>"+
	   "</div>"+
	   "</div>"+
	   "<div id='recommend-5' class='recommend'>"+
	   "<div class='update' style='margin-top:100px; margin-left:178px;' onclick='updaterecommend()'>＞</div>"+
	   "<div style='width:183px; height:70%; margin-left:10px; background:url(../../images/picture/pic5.jpg); background-size:100% 100%;'></div>"+
	   "<div class='recommend-name'>正品 VOTO IX20 刘海屏 全网通 智能手机 游戏学生 全面屏</div>"+
	   "<div style='width:203px; height:15%; margin-left:10px;'>"+
	   "<div class='reduce-price'>￥<span>828.00</span></div>"+
	   "<div class='prime-price'>￥<span style='text-decoration:line-through;'>1756.00</span></div>"+
	   "</div>"+
	   "</div>"+
	   "</div>";
	   document.getElementById("recommend").innerHTML=recommend; 
	 }
 }