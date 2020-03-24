package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.Discuss;
import com.example.demo.service.CommodityServive;
import com.example.demo.service.DiscussService;

/**
 * 修改日期:2020/3/21
 * 修改人:牟松
 * 商品详情信息查询控制器，用于接受用户查询商品详情的请求，并
 * 返回结果给用户，返回结果为JSON数组，包含了商品信息和用户评论
**/

@Controller
public class CommodityInformationController {
	
	@Autowired
	@Qualifier("commodityserviveimpl")
	private CommodityServive commodityserviveimpl;
	
	@Autowired 
	@Qualifier("discussserviceimpl")
	private DiscussService discussserviceimpl;
	
	@Autowired
	private Commodity commodity;
	
	@ResponseBody
	@RequestMapping("/commodity/information/query")
    public JSONArray queryCommodityInformation(@RequestParam("commodityid") String commodityid){
		commodity=commodityserviveimpl.queryCommodity(commodityid);
		List<Discuss> discusslist=discussserviceimpl.queryDiscuss(commodityid);
		JSONArray jsonarray=new JSONArray();
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("id",commodity.getId());
		jsonobject.put("store",commodity.getStore());
		jsonobject.put("img",commodity.getImg()); 
		jsonobject.put("name",commodity.getName()); 
		jsonobject.put("introduce",commodity.getIntroduce()); 
		jsonobject.put("price",commodity.getPrice());
		String discussnumber="";
		int number=Integer.valueOf(commodity.getDiscuss());
		if((number/10000)>0)
		   discussnumber=String.valueOf(number/10000)+"万";
		else if((number/100)==0)
		   discussnumber=String.valueOf(number)+"件";
		else
		   discussnumber=String.valueOf((number/100)*100)+"+";
		jsonobject.put("discussnumber",discussnumber); 
		jsonarray.add(jsonobject);
		for(int i=0;i<discusslist.size();i++)
			jsonarray.add(discusslist.get(i));
		return jsonarray;
    }
}
