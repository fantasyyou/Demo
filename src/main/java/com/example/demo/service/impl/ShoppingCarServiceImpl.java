package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.ShoppingCarDao;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.ShoppCartColumn;
import com.example.demo.service.CommodityServive;
import com.example.demo.service.ShoppingCarService;

/**
  * 修改日期:2020/3/19
  * 修改人:牟松
  * 购物车业务逻辑接口的具体实现类，主要是实现对用户购物车信息的管理
  * 第一个方法用于查询用户的购物车信息，参数为用户ID
  * 第二个方法用于添加商品到购物车，参数为商品编号和用户ID以及购买数量
  * 第三个方法用于删除购物车中的商品，参数为商品编号和用户ID
  * 第四个方法用于修改购物车中商品的数量，参数为商品编号和用户ID以及修改后的数量
 **/

@Service("shoppingcarserviceimpl")
@Transactional
public class ShoppingCarServiceImpl implements ShoppingCarService{
	
	@Autowired()
	@Qualifier("shoppingcardaoimpl")
	private ShoppingCarDao shoppingcardaoimpl;
	
	@Autowired()
	@Qualifier("commodityserviveimpl")
	private CommodityServive commodityserviveimpl;
	
	@Autowired
	private ShoppCartColumn shoppcartcolumn;
	
	@Autowired
	private Commodity commodity;
	
	@Override
	public List<ShoppCartColumn> queryCommList(String userid) {
		return shoppingcardaoimpl.queryCommList(userid);
	}

	@Override
	public ShoppCartColumn addComm(String id, String userid,String number) {
		commodity=commodityserviveimpl.queryCommodity(id);
		shoppcartcolumn.setId(commodity.getId());
		shoppcartcolumn.setUserid(userid);
		shoppcartcolumn.setStore(commodity.getStore());
		shoppcartcolumn.setImg(commodity.getImg());
		shoppcartcolumn.setName(commodity.getName());
		shoppcartcolumn.setIntroduce(commodity.getIntroduce());
		shoppcartcolumn.setPrice(commodity.getPrice());
		shoppcartcolumn.setNumber(number);
		int result=shoppingcardaoimpl.addComm(shoppcartcolumn);
		if(result==1) //商品不存在于购物车
			return shoppcartcolumn;
		else
			return null;	
	}

	@Override
	public void deleteComm(String id, String userid) {
		this.shoppingcardaoimpl.deleteComm(id, userid);
	}

	@Override
	public void updateComm(String id, String userid, String number) {
		this.shoppingcardaoimpl.updateComm(id, userid, number);		
	}

}
