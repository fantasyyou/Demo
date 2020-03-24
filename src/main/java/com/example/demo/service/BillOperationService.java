package com.example.demo.service;

/**
 * 修改日期:2020/3/20
 * 修改人:牟松
 * 订单业务逻辑接口，用于对订单中的商品进行添加到关注，删除，修改数量等操作
 *第一个方法为对订单进行修改，参数为一个字符串（参数用，区分）
**/

public interface BillOperationService {
	public void updateBill(String parameter);
}
