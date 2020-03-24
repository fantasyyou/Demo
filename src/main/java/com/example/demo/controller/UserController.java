package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.UserService;

/**
 * 修改日期:2019/3/22
 * 修改人:牟松
 **/

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userserviceimpl")
	private UserService userserviceimpl;
	
	@ResponseBody
	@RequestMapping("/user/login")
	public String userLogin(@RequestParam("phone") String phone,@RequestParam("code") String code)
	{
		return userserviceimpl.queryUser(phone, code); 
	}
	
	@ResponseBody
	@RequestMapping("/verificationcode/send")
	public void sendsendVerificationCode(@RequestParam("phone") String phone,@RequestParam("type") String type)
	{
		userserviceimpl.sendVerificationCode(phone, type);
	}

	@ResponseBody
	@RequestMapping("/verificationcode/verification")
	public String userVerification(@RequestParam("phone") String phone,@RequestParam("code") String code,@RequestParam("type") String type)
	{   
        return userserviceimpl.userVerification(phone, code, type);
	}
	
	@ResponseBody
	@RequestMapping("/register/query")
	public String registerQuery(@RequestParam("phone") String phone,@RequestParam("name") String name)
	{   
        return userserviceimpl.registerQuery(phone, name);
	}
	
	@ResponseBody
	@RequestMapping("/register/user")
	public void registerUser(@RequestParam("phone") String phone,@RequestParam("name") String name,@RequestParam("code") String code)
	{   
        userserviceimpl.registerUser(phone, name, code);
	}
	
	@ResponseBody
	@RequestMapping("/update/code")
	public void updateCode(@RequestParam("phone") String phone,@RequestParam("code") String code)
	{  
        userserviceimpl.updateCode(phone, code);
	}
}
