package com.example.demo.entity;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
  * 用户实体类，包含了4个基本属性
 **/

public class User 
 {
   private String phone;  //绑定手机号
   private String name;   //用户名
   private String code;   //登录密码
   private String power;  //操作权限
   
   public String getPhone() {
	 return phone;
    } 
   public void setPhone(String phone) {
	 this.phone = phone;
    }
   public String getName() {
	 return name;
    }
   public void setName(String name) {
	 this.name = name;
    }
   public String getCode() {
	 return code;
    }
   public void setCode(String code) {
	 this.code = code;
    }
   public String getPower() {
	 return power;
    }
   public void setPower(String power) {
 	 this.power = power;
    }
 }
