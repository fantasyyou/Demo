package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ConcernDao;
import com.example.demo.entity.ConcernCommodity;
import com.example.demo.service.ConcernService;

/**
 * 修改日期:2020/3/20
 * 修改人:牟松
 * 关注商品业务逻辑的具体实现类，用于查询，添加，删除用户关注的商品
 * 第一个用于查询用户关注的商品，在订单下面的我的关注栏
 * 中使用，参数为用户的ID（用户手机号），起始下标，实现
 * 对关注商品的分页浏览
 * 第二个方法用于添加一个关注的商品，参数为用户的ID（手机号）
 * 和商品编号
 * 第三个方法用于删除一个关注的商品，参数为用户的ID（手机号）
 * 和商品编号
**/

@Service("concernserviceimpl")
public class ConcernServiceImpl implements ConcernService{

	@Autowired()
	private ConcernDao concerndaoimpl;
	
	@Autowired
	ConcernCommodity concerncommodity;
	
	@Override
	public List<ConcernCommodity> queryConcernCommodity(String userid, int start) {
	   return concerndaoimpl.queryConcernCommodity(userid, start);
	}

	@Override
	public void addConcernCommodity(String userid, String commodityid) {
	   concerncommodity.setUserid(userid);
	   concerncommodity.setCommodityid(commodityid);
	   concerndaoimpl.addConcernCommodity(concerncommodity);
	}

	@Override
	public void deleteConcernCommodity(String userid, String commodityid) {
       concerncommodity.setUserid(userid);
       concerncommodity.setCommodityid(commodityid);
       concerndaoimpl.deleteConcernCommodity(concerncommodity);	
	}

}
