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
import com.example.demo.entity.ShoppCartColumn;
import com.example.demo.service.ShoppingCarService;

/**
  * 修改日期:2020/3/17
  * 修改人:牟松
  * 购物车控制器，用于接受用户对购物车操作的请求
  * 第一个方法用于接受用户查询购物车信息的请求，并返回查询结果，参数为用户ID
  * 第二个方法用户接受用户添加商品的请求，参数为商品编号，用户ID，添加商品数量
  * 第三个方法用于接受用户删除商品的请求，参数为商品编号和用户ID
  * 第四个方法用于接受用户修改商品的请求，参数为商品编号，用户ID，修改后的商品数量
 **/

@Controller
public class ShoppingCartController {
	
	@Autowired()
	@Qualifier("shoppingcarserviceimpl")
	private ShoppingCarService shoppingcarserviceimpl;
	
	@Autowired
	ShoppCartColumn shoppcartcolumn;
	
	@ResponseBody
	@RequestMapping("/shoppingcart/query")
    public JSONArray queryShoppingCart(@RequestParam("userid") String userid){
		List<ShoppCartColumn> shoppcartcolumnlist=shoppingcarserviceimpl.queryCommList(userid);
	    JSONArray jsonarray=new JSONArray();
	    JSONObject jsonobject=new JSONObject();
	    for(int i=0;i<shoppcartcolumnlist.size();i++)
		   jsonarray.add(shoppcartcolumnlist.get(i));
	    int totalnumber=0;      //商品总数
	    float totalprice=0;     //商品总额
	    for(int i=0;i<shoppcartcolumnlist.size();i++)
	      {
		    totalnumber+=Integer.valueOf(shoppcartcolumnlist.get(i).getNumber()); 
		    totalprice+=Float.valueOf(shoppcartcolumnlist.get(i).getPrice())*Float.valueOf(shoppcartcolumnlist.get(i).getNumber());	 
	      }
        jsonobject.put("totalnumber",totalnumber); 
        jsonobject.put("totalprice",totalprice);  
        jsonarray.add(jsonobject);
        return jsonarray;
    }
	
	@ResponseBody
	@RequestMapping("/shoppingcart/add")
    public JSONObject addShoppingCart(@RequestParam("id") String id,@RequestParam("userid") String userid,@RequestParam("number") String number){
		if((shoppcartcolumn=shoppingcarserviceimpl.addComm(id, userid,number))!=null)
		  {
			JSONObject jsonobject = new JSONObject();              /*向前端发送数据*/
	        jsonobject.put("id",shoppcartcolumn.getId());
	        jsonobject.put("name",shoppcartcolumn.getName()); 
	        jsonobject.put("img",shoppcartcolumn.getImg());  
	        jsonobject.put("introduce",shoppcartcolumn.getIntroduce());
	        jsonobject.put("price",shoppcartcolumn.getPrice()); 
	        jsonobject.put("subtotal",Float.valueOf(shoppcartcolumn.getPrice())*Float.valueOf(shoppcartcolumn.getNumber()));  
	        jsonobject.put("store", shoppcartcolumn.getStore());	
	        return jsonobject;
		  }
        return null;		
    }
	
	@ResponseBody
	@RequestMapping("/shoppingcart/delete")
    public void deleteShoppingCart(@RequestParam("id") String id,@RequestParam("userid") String userid){
	    shoppingcarserviceimpl.deleteComm(id, userid);
    }
	
	@ResponseBody
	@RequestMapping("/shoppingcart/update")
    public void updateShoppingCart(@RequestParam("id") String id,@RequestParam("userid") String userid,@RequestParam("number") String number){
		shoppingcarserviceimpl.updateComm(id, userid, number);
    }
}
