package com.example.demo.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.ConcernCommodity;
import com.example.demo.entity.Discuss;
import com.example.demo.entity.Order;
import com.example.demo.entity.ReceiveAddress;
import com.example.demo.entity.ShoppCartColumn;
import com.example.demo.entity.User;
import com.example.demo.entity.VerificationCode;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
 * JavaBean配置类，用于注入实体类
  * 项目中包含了10个实体类，商品，用户，
  * 购物车商品，关注商品，收获地址，订单，
  * 评论，验证码，和获取当前时间所使用的那个类
 **/

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Commodity commodity()
	{   
		return new Commodity();
	}
	
	@Bean
	public ConcernCommodity concerncommodity()
	{   
		return new ConcernCommodity();
	}
	
	@Bean
	public Discuss discuss()
	{   
		return new Discuss();
	}
	
	@Bean
	public Order order()
	{   
		return new Order();
	}
	
	@Bean
	public ReceiveAddress receiveaddress()
	{   
		return new ReceiveAddress();
	}
	
	@Bean
	public ShoppCartColumn shoppcartcolumn()
	{   
		return new ShoppCartColumn();
	}
	
	@Bean
	public User user()
	{   
		return new User();
	}
	
	@Bean
	public VerificationCode verificationcode()
	{
		return new VerificationCode();
	}
	
	@Bean
	public SimpleDateFormat simpledateformat()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	@Bean
	public Date date()
	{
		return new Date();
	}
}
