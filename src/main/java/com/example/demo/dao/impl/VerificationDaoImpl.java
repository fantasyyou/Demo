package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.VerificationDao;
import com.example.demo.entity.VerificationCode;
import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;

/**
 * 修改日期:2020/3/22
 * 修改人:牟松
 * 验证类数据访问层接口的具体实现类，用户发送，保存，查询验证码
 * 第一个方法用于获得一个六位验证码
 * 第二个方法用于发送验证码，参数为一个验证类类对象
 * 第三个方法用于添加一条验证码记录，参数为一个验证类类对象
 * 第四个方法为查询一条验证码记录，参数和返回结果均为一个验证码类对象，返回结果为空则为null
**/

@Repository("verificationdaoimpl")
public class VerificationDaoImpl implements VerificationDao{
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private VerificationCode verificationcode;
	
    static class VerificationCodeRowMapper implements RowMapper<VerificationCode>{
        public VerificationCode mapRow(ResultSet resultset, int rowNum) throws SQLException {
        	VerificationCode verificationcode = new VerificationCode();
			verificationcode.setPhone(resultset.getString("phone"));
			verificationcode.setCode(resultset.getString("code"));
			verificationcode.setType(resultset.getString("type"));
            return verificationcode;
        }
    }
    
    public String getCode() { //生成验证码的方法       
        Random rand=new Random(System.nanoTime());    //随机数生产器
	    char[] code=new char[6];
	    for(int i=0;i<6;i++)
	      {
	        int v=rand.nextInt(9);  //生成0-9的一个数
	        code[i]=(char)('0'+v);
	      }
	    return new String(code);
    }
    
	@Override
	public void sendVerificationCode(VerificationCode verificationcode) {
		  GlobalParams globalParams=new GlobalParams();
		  globalParams.setNeedLog(1);  //生成日志
		  ConfigManager.setGlobalParams(globalParams);
		  String userid="E104IN";   
		  String password="3YnT4C";
		  int priority = 1;
		  String ipAddress1 = "api01.monyun.cn:7901";
          String ipAddress2 = null;
		  String ipAddress3 = null;
		  String ipAddress4 = null;
	      int result = -310007;
		  try {
				result = ConfigManager.setAccountInfo(userid, password, priority,
						ipAddress1,ipAddress2, ipAddress3,ipAddress4);
				if (result == 0) {
					System.out.println("设置用户账号信息成功！");
				} else {
					System.out.println("设置用户账号信息失败，错误码：" + result);
				}
		  } catch (Exception e) {
				e.printStackTrace();
			}
		  boolean isKeepAlive = false;
		  SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);
		  try {
				Message message = new Message();
				message.setUserid(userid);
				message.setMobile(verificationcode.getPhone());  //发送手机号
				message.setContent("您的验证码是"+verificationcode.getCode()+"，在3分钟内有效。如非本人操作请忽略本短信。");  //短信内容
				StringBuffer returnValue = new StringBuffer();
				int results = -310099;
				results = smsSendConn.singleSend(message,returnValue);  //发送验证码
				if (results == 0) {
					System.out.println("单条发送提交成功！");
					System.out.println(returnValue.toString());
				}
				else {
					System.out.println("单条发送提交失败,错误码：" + results);
				}
		  } catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void addVerificationCode(VerificationCode verificationcode) {
		String sql = "insert into verificationcode(phone,code,type) values(?,?,?)";
        this.jdbcTemplate.update(sql,verificationcode.getPhone(),verificationcode.getCode(),verificationcode.getType());			
	}


	@Override
	public VerificationCode userVerification(VerificationCode verificationcode) {
		String sql = "select * from verificationcode where phone=? and code=? and type=?";
	    try {
	    	  this.verificationcode=jdbcTemplate.queryForObject(sql,new VerificationCodeRowMapper(),
	    			                                                verificationcode.getPhone(),
	    			                                                verificationcode.getCode(),
	    			                                                verificationcode.getType());    	 
	    } catch (EmptyResultDataAccessException e) {	
	    	  e.printStackTrace(); 
	          return null;
	    }
	   return this.verificationcode; 
	}
}
