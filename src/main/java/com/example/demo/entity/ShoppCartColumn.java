package com.example.demo.entity;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
  * 购物车商品实体类，包含了8个基本属性
 **/

public class ShoppCartColumn 
 { 
   private String id;        //商品编号
   private String userid;    //用户编号
   private String store;     //店铺名称
   private String img;       //商品图片
   private String name;      //商品名称
   private String introduce; //商品介绍
   private String price;     //商品价格
   private String number;    //商品数量
   
   public String getId() {
	    return id;
	}
   public void setId(String id) {
		this.id = id;
	}
   public String getUserid() {
		return userid;
	}
   public void setUserid(String userid) {
		this.userid = userid;
	}
   public String getStore() {
	    return store;
    }   
   public void setStore(String store) {
	    this.store = store;
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
   public String getIntroduce() {
	    return introduce;
    }
   public void setIntroduce(String introduce) {
	    this.introduce = introduce;
    }
   public String getPrice() {
		return price;
	}
   public void setPrice(String price) {
		this.price = price;
	}
   public String getNumber() {
		return number;
	}
   public void setNumber(String number) {
		this.number = number;
	}
 }
