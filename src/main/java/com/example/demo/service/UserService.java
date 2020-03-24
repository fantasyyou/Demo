package com.example.demo.service;

/**
 * 修改日期:2019/3/22
 * 修改人:牟松
 * 用户信息业务逻辑接口，用于查询用户信息，注册，修改密码
 * 第一个方法用于查询用户输入的用户名和密码是否正确，参数为用户手机号和用户密码，返回结果为空则返回null
 * 第二个方法用于查询用户是否存在，参数为用户手机号和用户名，返回结果为空则返回null
 * 第三个方法用于添加一条用户信息，参数为用户手机号，用户名，用户密码
 * 第四个方法用于发送验证码，参数为用户手机号和用户操作类型（注册，修改密码）
 * 第五个方法用于验证用户输入的验证码，参数为用户手机号，用户输入的密码，用户操作类型（注册，修改密码）
 * 第六个方法用户修改用户的登录密码，参数为用户手机号和新的密码
 **/

public interface UserService {
	public String queryUser(String phone,String code);      
	public String registerQuery(String phone,String name);  
	public void registerUser(String phone,String name,String code); 
	public void sendVerificationCode(String phone,String type);
	public String userVerification(String phone,String code,String type);
	public void updateCode(String phone,String code);
}
