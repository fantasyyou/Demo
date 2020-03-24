<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/user/receiveaddress.css" type="text/css">
<script src="../../js/user/receiveaddress.js"></script>
<title>FLC PLUS-网上商城</title>
</head>
<body style="margin:0px; width:1520px; height:auto;">
<div class="receiveaddress">
<div class="add-address">新增收货人信息</div>
<div class="add-address-tag"><span style="color:#FF0000">*</span>所在地区</div>
<div id="re-address" class="div-input" style="width:auto;" onmousemove="openreselect(this.id)" onmouseout="closereselect(this.id)">--请选择--</div>
<div id="re-select" class="re-select" onmousemove="openreselect(this.id)" onmouseout="closereselect(this.id)">
   <div style="width:80%; height:36px; margin-left:10px; border-bottom:2px solid #FF0000;">
      <div id="re-select-1" class="re-select-choice" style="display:block;" onclick="openreselect(this.id)">--请选择--</div>
      <div id="re-select-2" class="re-select-choice" onclick="openreselect(this.id)">--请选择--</div>
      <div id="re-select-3" class="re-select-choice" onclick="openreselect(this.id)">--请选择--</div>
   </div>
   <div id="re-tag-choice" style="width:85%; height:auto;">
      <div id="0" class="re-address-tag" onclick="getprovince(this)">北京</div><div id="2" class="re-address-tag" onclick="getprovince(this)">天津</div>
      <div id="3" class="re-address-tag" onclick="getprovince(this)">河北</div><div id="4" class="re-address-tag" onclick="getprovince(this)">山西</div>
      <div id="5" class="re-address-tag" onclick="getprovince(this)">内蒙古</div><div id="6" class="re-address-tag" onclick="getprovince(this)">辽宁</div>
      <div id="7" class="re-address-tag" onclick="getprovince(this)">吉林</div><div id="8" class="re-address-tag" onclick="getprovince(this)">黑龙江</div>
      <div id="9" class="re-address-tag" onclick="getprovince(this)">上海</div><div id="10"class="re-address-tag" onclick="getprovince(this)">江苏</div>
      <div id="11"class="re-address-tag" onclick="getprovince(this)">浙江</div><div id="12"class="re-address-tag" onclick="getprovince(this)">安徽</div>
      <div id="13"class="re-address-tag" onclick="getprovince(this)">福建</div><div id="14"class="re-address-tag" onclick="getprovince(this)">江西</div>
      <div id="15"class="re-address-tag" onclick="getprovince(this)">山东</div><div id="16"class="re-address-tag" onclick="getprovince(this)">河南</div>
      <div id="17"class="re-address-tag" onclick="getprovince(this)">湖北</div><div id="18"class="re-address-tag" onclick="getprovince(this)">湖南</div>
      <div id="19"class="re-address-tag" onclick="getprovince(this)">广东</div><div id="20"class="re-address-tag" onclick="getprovince(this)">广西</div>
      <div id="21"class="re-address-tag" onclick="getprovince(this)">海南</div><div id="22"class="re-address-tag" onclick="getprovince(this)">重庆</div>
      <div id="23"class="re-address-tag" onclick="getprovince(this)">四川</div><div id="24"class="re-address-tag" onclick="getprovince(this)">贵州</div>
      <div id="25"class="re-address-tag" onclick="getprovince(this)">云南</div><div id="26"class="re-address-tag" onclick="getprovince(this)">西藏</div>
      <div id="27"class="re-address-tag" onclick="getprovince(this)">陕西</div><div id="28"class="re-address-tag" onclick="getprovince(this)">甘肃</div>
      <div id="29"class="re-address-tag" onclick="getprovince(this)">青海</div><div id="30"class="re-address-tag" onclick="getprovince(this)">宁夏</div>
      <div id="31"class="re-address-tag" onclick="getprovince(this)">新疆</div><div style="width:100%; height:20px;"></div>
   </div>
</div>
<div class="add-address-tag"><span style="color:#FF0000">*</span>收货人</div>
<div class="div-input"><input class="re-input" type="text"/></div>
<div class="add-address-tag"><span style="color:#FF0000">*</span>详细地址</div>
<div class="div-input"><input class="re-input" type="text"/></div>
<div class="add-address-tag"><span style="color:#FF0000">*</span>手机号码</div>
<div class="div-input"><input class="re-input" type="text"/></div>
<div class="add-address-tag"><span style="color:#FFFFFF">*</span>固定电话</div>
<div class="div-input"><input class="re-input" type="text"/></div>
<div class="add-address-tag"><span style="color:#FFFFFF">*</span>邮箱地址</div>
<div class="div-input"><input class="re-input" type="text"/></div>
<div class="add-address-tag"><span style="color:#FFFFFF">*</span>地址别名</div>
<div class="div-input"><input class="re-input" type="text"/></div>
<div class="re-button">保存收货人信息</div>
</div>
</body>
</html>