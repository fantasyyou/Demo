package com.example.demo.dao;

import com.example.demo.entity.VerificationCode;

/**
 * 修改日期:2020/3/22
 * 修改人:牟松
 * 验证类数据访问层接口，用户发送，保存，查询验证码
 * 第一个方法用于获得一个六位验证码
 * 第二个方法用于发送验证码，参数为一个验证类类对象
 * 第三个方法用于添加一条验证码记录，参数为一个验证类类对象
 * 第四个方法为查询一条验证码记录，参数和返回结果均为一个验证码类对象，返回结果为空则为null
**/

public interface VerificationDao {
	public String getCode();
    public void sendVerificationCode(VerificationCode verificationcode);
    public void addVerificationCode(VerificationCode verificationcode);
    public VerificationCode userVerification(VerificationCode verificationcode);
}
