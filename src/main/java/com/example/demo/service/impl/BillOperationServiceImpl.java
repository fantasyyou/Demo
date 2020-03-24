package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ConcernDao;
import com.example.demo.dao.ShoppingCarDao;
import com.example.demo.entity.ConcernCommodity;
import com.example.demo.service.BillOperationService;

/**
 * 修改日期:2020/3/20
 * 修改人:牟松
 * 订单业务逻辑的具体实现类，用于对订单中的商品进行添加到关注，删除，修改数量等操作
 * 第一个方法为对订单进行修改，参数为一个字符串（参数用，区分），后台解析成一个字符串
 * 数组，第一个字符串为用户选择（移动到我的关注，加到我的关注，删除选中商品），第
 * 二个字符串为用户的ID（手机号），之后的每一个字符串为商品的编号
**/


@Service("billoperationserviceimpl")
public class BillOperationServiceImpl implements BillOperationService{
	
	@Autowired()
	@Qualifier("concerndaoimpl")
	private ConcernDao concerndaoimpl;
	
	@Autowired()
	@Qualifier("shoppingcardaoimpl")
	private ShoppingCarDao shoppingcardaoimpl;
	
	@Autowired
	private ConcernCommodity concerncommodity;
	
	public void updateBill(String parameter) {
	   String[] parameterlist=parameter.split(",");
	   if(parameterlist[0].equals("移到我的关注")||parameterlist[0].equals("加到我的关注"))
	      {
	        for(int i=2;i<parameterlist.length;i++)
	    	  {
	        	concerncommodity.setUserid(parameterlist[1]);
	        	concerncommodity.setCommodityid(parameterlist[i]);
	        	concerndaoimpl.addConcernCommodity(concerncommodity);
	    	  }
	      } 
	   if(parameterlist[0].equals("删除选中的商品")||parameterlist[0].equals("移到我的关注")||parameterlist[0].equals("删除"))
	      {
	        for(int i=2;i<parameterlist.length;i++)
	      	  shoppingcardaoimpl.deleteComm(parameterlist[i], parameterlist[1]);   		
	      }
		
	}
}
