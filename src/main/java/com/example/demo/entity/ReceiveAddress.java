package com.example.demo.entity;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
  * 收获地址实体类，包含了11个基本属性
 **/

public class ReceiveAddress 
 {
   private String id;        //收货地址ID
   private String user;      //用户识别标志
   private String province;  //省级别
   private String city;      //市级别
   private String county;    //县级别
   private String name;      //收货人姓名
   private String address;   //收货人地址
   private String phone;     //收货人电话
   private String fixedphone;//收货人固定电话
   private String email;     //收货人邮箱
   private String alias ;    //地址别名
   
   public String getId() {
		return id;
	}
   public void setId(String id) {
		this.id = id;
	}
   public String getUser() {
		return user;
	}
   public void setUser(String user) {
		this.user = user;
	}
   public String getProvince() {
		return province;
	}
   public void setProvince(String province) {
		this.province = province;
	}
   public String getCity() {
		return city;
	}
   public void setCity(String city) {
		this.city = city;
	}
   public String getCounty() {
		return county;
	}
   public void setCounty(String county) {
		this.county = county;
	}	
   public String getName() {
		return name;
	}
   public void setName(String name) {
		this.name = name;
	}
   public String getAddress() {
		return address;
	}
   public void setAddress(String address) {
		this.address = address;
	}
   public String getPhone() {
		return phone;
	}
   public void setPhone(String phone) {
		this.phone = phone;
	}
   public String getFixedphone() {
		return fixedphone;
	}
   public void setFixedphone(String fixedphone) {
		this.fixedphone = fixedphone;
	}
   public String getEmail() {
		return email;
	}
   public void setEmail(String email) {
		this.email = email;
	}
   public String getAlias() {
		return alias;
	}
   public void setAlias(String alias) {
		this.alias = alias;
	}
 }