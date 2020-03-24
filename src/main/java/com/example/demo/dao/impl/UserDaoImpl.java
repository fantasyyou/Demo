package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

/**
 * 修改日期:2019/3/22
 * 修改人:牟松
 * 用户信息数据访问层接口的具体实现类，用于查询用户信息，注册，修改密码
 * 第一个方法用于查询用户输入的用户名和密码是否正确，参数为用户手机号和用户密码，返回结果为空则返回null
 * 第二个方法用于查询用户是否存在，参数为用户手机号和用户名，返回结果为空则返回null
 * 第三个方法用于添加一条用户信息，参数为一个用户类对象
 * 第四个方法用户修改用户的登录密码，参数为一个用户类对象
 **/

@Repository("userdaoimpl")
public class UserDaoImpl implements UserDao{
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private User user;
  
    static class UserRowMapper implements RowMapper<User>{
        public User mapRow(ResultSet resultset, int rowNum) throws SQLException {
        	User user = new User();
        	user.setName(resultset.getString("name"));
        	user.setPhone(resultset.getString("phone"));
        	user.setCode(resultset.getString("code"));
        	user.setPower(resultset.getString("power"));
            return user;
        }
    }

	@Override
	public User queryUser(String phone, String code) {
		String sql = "select * from user where phone=? and code=?";
	    try {
	    	  user=jdbcTemplate.queryForObject(sql,new UserRowMapper(),phone,code);
	    } catch (EmptyResultDataAccessException e) {	
	    	  e.printStackTrace(); 
	          return null;
	    }
	    return user;
	}

	@Override
	public User registerQuery(String phone, String name) {
		String sql = "select * from user where phone=? or name=?";
	    try {
	    	  user=jdbcTemplate.queryForObject(sql,new UserRowMapper(),phone,name);
	    } catch (EmptyResultDataAccessException e) {	
	    	  e.printStackTrace(); 
	          return null;
	    }
	    return user;
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into user(phone,name,code,power) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,user.getPhone(),user.getName(),user.getCode(),user.getPower());	
	}
	
	@Override
	public void updateCode(User user) {
		String sql = "update user set code=? where phone=?";
        this.jdbcTemplate.update(sql,user.getCode(),user.getPhone());	
	}

}
