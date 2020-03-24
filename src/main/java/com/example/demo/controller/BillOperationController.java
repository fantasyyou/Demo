package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.BillOperationService;

/**
  * 修改日期:2020/3/20
  * 修改人:牟松
  * 订单控制器，用于对订单中的商品进行添加到关注，删除，修改数量等操作
  *第一个方法为对订单进行修改，参数为一个字符串（参数用，区分）
**/

@Controller
public class BillOperationController {
	
	@Autowired()
	@Qualifier("billoperationserviceimpl")
	private BillOperationService billoperationserviceimpl;
	
	@ResponseBody
	@RequestMapping("/bill/update")
    public void updateShoppingCart(@RequestParam("commodityid") String parameter){
		billoperationserviceimpl.updateBill(parameter);
    }
    
}
