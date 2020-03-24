package com.example.demo.entity;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
  * 评论实体类，包含了4个基本属性
 **/

public class Discuss 
 {
   private String commodityid;  //商品编号
   private String username;     //用户昵称
   private String content;      //评价内容
   private String time;         //评价时间
   
   public String getCommodityid() {
		return commodityid;
	}
   public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}
   public String getUsername() {
		return username;
	}
   public void setUsername(String username) {
		this.username = username;
	}
   public String getContent() {
		return content;
	}
   public void setContent(String content) {
		this.content = content;
	}
   public String getTime() {
		return time;
	}
   public void setTime(String time) {
		this.time = time;
	}
 }