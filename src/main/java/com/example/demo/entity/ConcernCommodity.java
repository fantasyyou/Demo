package com.example.demo.entity;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
  * 关注商品实体类，包含了5个基本属性
 **/

public class ConcernCommodity 
 {
   private String userid;       //用户编号
   private String commodityid;  //商品编号
   private String img;          //商品图片名称
   private String name;         //商品名称
   private String price;        //商品价格
   
   public String getUserid() {
	  return userid;
    }
   public void setUserid(String userid) {
	  this.userid = userid;
    }
   public String getCommodityid() {
	  return commodityid;
    }
   public void setCommodityid(String commodityid) {
	  this.commodityid = commodityid;
    }
   public String getImg() {
	  return img;
    }
   public void setImg(String img) {
	  this.img = img;
    }
   public String getName() {
	  return name;
    }
   public void setName(String name) {
	  this.name = name;
    }
   public String getPrice() {
	  return price;
    }
   public void setPrice(String price) {
	  this.price = price;
    }
 }