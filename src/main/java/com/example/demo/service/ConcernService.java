package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ConcernCommodity;

/**
 * 修改日期:2020/3/20
 * 修改人:牟松
 * 关注商品业务逻辑接口，用于查询，添加，删除用户关注的商品
 * 第一个用于查询用户关注的商品，在订单下面的我的关注栏
 * 中使用，参数为用户的ID（用户手机号），起始下标，实现
 * 对关注商品的分页浏览
 * 第二个方法用于添加一个关注的商品，参数为用户的ID（手机号）
 * 和商品编号
 * 第三个方法用于删除一个关注的商品，参数为用户的ID（手机号）
 * 和商品编号
**/

public interface ConcernService {
	List<ConcernCommodity> queryConcernCommodity(String userid, int start);  
	public void addConcernCommodity(String userid,String commodityid); 
	public void deleteConcernCommodity(String userid,String commodityid);
}
