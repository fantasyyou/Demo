package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.ConcernCommodity;
import com.example.demo.service.ConcernService;

/**
 * 修改日期:2020/3/20
 * 修改人:牟松
 * 关注商品控制器，用于查询，添加，删除用户关注的商品
 * 第一个用于查询用户关注的商品，在订单下面的我的关注栏
 * 中使用，参数为用户的ID（用户手机号），起始下标，实现
 * 对关注商品的分页浏览
 * 第二个方法用于添加一个关注的商品，参数为用户的ID（手机号）
 * 和商品编号
 * 第三个方法用于删除一个关注的商品，参数为用户的ID（手机号）
 * 和商品编号
**/

@Controller
public class ConcernCommodityController {
	
	@Autowired()
	@Qualifier("concernserviceimpl")
	ConcernService concernserviceimpl;

	@ResponseBody
	@RequestMapping("/concerncommodity/query")
    public List<ConcernCommodity> queryConcernCommodity(@RequestParam("userid") String userid,@RequestParam("start") int start){
		return concernserviceimpl.queryConcernCommodity(userid, start);
    }
	
	@ResponseBody
	@RequestMapping("/concerncommodity/add")
    public void addConcernCommodity(@RequestParam("userid") String userid,@RequestParam("commodityid") String commodityid){
		concernserviceimpl.addConcernCommodity(userid, commodityid);
    }
	
	@ResponseBody
	@RequestMapping("/concerncommodity/delete")
    public void deleteConcernCommodity(@RequestParam("userid") String userid,@RequestParam("commodityid") String commodityid){
		concernserviceimpl.deleteConcernCommodity(userid, commodityid);
    }

}
