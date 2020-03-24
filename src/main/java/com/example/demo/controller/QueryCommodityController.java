package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.CommodityServive;
import com.example.demo.entity.Commodity;

/**
  * 修改日期:2020/3/16
  * 修改人:牟松
  * 商品查询控制器，用于接受用户查询商品信息的请求
 * queryCommodity方法的参数为商品的关键字，返回
  * 的结果为一个商品信息的list集合
 * commodityPaging方法的参数为request，用于接受
 * HTML传递过来的参数，关键字，用户操作，当前页码
 **/

@Controller
public class QueryCommodityController {

	@Autowired()
	@Qualifier("commodityserviveimpl")
	private CommodityServive commodityserviveimpl;

	@ResponseBody
	@RequestMapping("/commodity/query")
    public JSONArray queryCommodity(@RequestParam("keyword") String keyword){
	   List<Commodity> commoditylist=commodityserviveimpl.queryCommodityList(keyword);  
	   JSONArray jsonarray=new JSONArray();
	   JSONObject jsonobject=new JSONObject();
	   for(int i=0;i<commoditylist.size();i++)
		   jsonarray.add(commoditylist.get(i));
	   int commnumber=commodityserviveimpl.getCommodityNumber(keyword);
	   jsonobject.put("commnumber",commnumber);
	   jsonobject.put("pagenumber",commnumber/15+1);
	   jsonarray.add(jsonobject);
	   return jsonarray;
    }
	
	@ResponseBody
	@RequestMapping("/commodity/query/paging")
    public List<Commodity> commodityPaging(HttpServletRequest request){
	   String keyword=request.getParameter("keyword");  //商品关键字
	   String sort=request.getParameter("sort");        //排序方式
	   String choice=request.getParameter("choice");    //翻页操作
	   String current=request.getParameter("current");  //当前页码
	   return commodityserviveimpl.commodityPaging(keyword, sort, choice, current);
    }
}
