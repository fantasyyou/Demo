package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.VerificationDao;
import com.example.demo.entity.User;
import com.example.demo.entity.VerificationCode;
import com.example.demo.service.UserService;

/**
 * 修改日期:2019/3/22
 * 修改人:牟松
 * 用户信息业务逻辑接口的具体实现类，用于查询用户信息，注册，修改密码
 * 第一个方法用于查询用户输入的用户名和密码是否正确，参数为用户手机号和用户密码，返回结果为空则返回null
 * 第二个方法用于查询用户是否存在，参数为用户手机号和用户名，返回结果为空则返回null
 * 第三个方法用于添加一条用户信息，参数为用户手机号，用户名，用户密码
 * 第四个方法用于发送验证码，参数为用户手机号和用户操作类型（注册，修改密码）
 * 第五个方法用于验证用户输入的验证码，参数为用户手机号，用户输入的密码，用户操作类型（注册，修改密码）
 * 第六个方法用户修改用户的登录密码，参数为用户手机号和新的密码
 **/

@Service("userserviceimpl")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userdaoimpl")
	private UserDao userdaoimpl;
	
	@Autowired
	private User user;
	
	@Autowired
	@Qualifier("verificationdaoimpl")
	private VerificationDao verificationdaoimpl;
	
	@Autowired
	private VerificationCode verificationcode;
	
	@Override
	public String queryUser(String phone, String code) {
		User users=userdaoimpl.queryUser(phone, code); 
		if(users!=null)
		  return users.getName();
		else
		  return "验证失败";	
	}

	@Override
	public String registerQuery(String phone, String name) {
		User users=userdaoimpl.registerQuery(phone, name); 
		if(users!=null)
		  return users.getName();
		else
		  return "用户不存在";	
	}

	@Override
	public void registerUser(String phone, String name, String code) {
		user.setPhone(phone);
		user.setName(name);
		user.setCode(code);
		user.setPower("普通用户");
		userdaoimpl.addUser(user);
	}

	@Override
	public void sendVerificationCode(String phone,String type) {
		verificationcode.setPhone(phone);
		verificationcode.setCode(verificationdaoimpl.getCode());
		verificationcode.setType(type);
		verificationdaoimpl.sendVerificationCode(verificationcode);
		verificationdaoimpl.addVerificationCode(verificationcode);
	}

	@Override
	public String userVerification(String phone,String code,String type) {
		verificationcode.setPhone(phone);
		verificationcode.setCode(code);
		verificationcode.setType(type);
		if(verificationdaoimpl.userVerification(verificationcode)!=null)
		  return "验证成功";
	    else
	      return "验证失败";	
	}

	@Override
	public void updateCode(String phone,String code) {
		user.setPhone(phone);
		user.setCode(code);
		userdaoimpl.updateCode(user);
	}

}
