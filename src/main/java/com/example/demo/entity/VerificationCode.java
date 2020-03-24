package com.example.demo.entity;

/**
  * 修改日期:2019/3/22
  * 修改人:牟松
  * 验证码实体类，包含了三个基本属性
 **/

public class VerificationCode {
	
	private String phone;
	private String code;
	private String type;	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
