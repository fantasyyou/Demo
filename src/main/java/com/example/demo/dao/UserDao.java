package com.example.demo.dao;

import com.example.demo.entity.User;

/**
 * 修改日期:2019/3/22
 * 修改人:牟松
 * 用户信息数据访问层接口，用于查询用户信息，注册，修改密码
 * 第一个方法用于查询用户输入的用户名和密码是否正确，参数为用户手机号和用户密码，返回结果为空则返回null
 * 第二个方法用于查询用户是否存在，参数为用户手机号和用户名，返回结果为空则返回null
 * 第三个方法用于添加一条用户信息，参数为一个用户类对象
 * 第四个方法用户修改用户的登录密码，参数为一个用户类对象
 **/

public interface UserDao {
	public User queryUser(String phone,String code);      //查询手机号或用户名是否可用
	public User registerQuery(String phone,String name);  //查询手机号或用户名是否可用
	public void addUser(User user);                       //添加用户
	void updateCode(User user);                           //修改用户密码
}
