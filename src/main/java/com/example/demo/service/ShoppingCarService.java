package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ShoppCartColumn;

/**
  * 修改日期:2020/3/19
  * 修改人:牟松
  * 购物车业务逻辑接口，主要是实现对用户购物车信息的管理
  * 第一个方法用于查询用户的购物车信息，参数为用户ID（用户手机号）
  * 第二个方法用于添加商品到购物车，参数为商品编号和用户ID（用户手机号）以及购买数量
  * 第三个方法用于删除购物车中的商品，参数为商品编号和用户ID（用户手机号）
  * 第四个方法用于修改购物车中商品的数量，参数为商品编号和用户ID（用户手机号）以及修改后的数量
 **/

public interface ShoppingCarService {
	public List<ShoppCartColumn> queryCommList(String userid);
	public ShoppCartColumn addComm(String id, String userid,String number);
	public void deleteComm(String id,String userid);
	public void updateComm(String id,String userid,String number);
}
