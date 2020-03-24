package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.*;

/**
  * 修改日期:2020/3/19
  * 修改人:牟松
  * 购物车信息修改接口，主要是用于查询，增加，删除，修改购物车商品信息
  * 第一个方法用于查询用户的购物车信息，参数为用户ID
  * 第二个方法用于添加商品到购物车，参数为一个购物车商品实体
  * 第三个方法用于删除购物车中的商品，参数为商品编号和用户ID
  * 第四个方法用于修改购物车中商品的数量，参数为商品编号和用户ID以及修改后的数量
 **/

public interface ShoppingCarDao {
	public List<ShoppCartColumn> queryCommList(String userid);
	public int addComm(ShoppCartColumn shoppcartcolumn);
	public void deleteComm(String id,String userid);
	public void updateComm(String id,String userid,String number);
}
