package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.CommodityDao;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CommodityServive;

/**
  * 修改日期:2020/3/18
  * 修改人:牟松
  * 商品业务逻辑接口的具体实现类，主要是用于查询商品的信息
  * 第一个方法用于查询商品的数量，参数为商品的关键字
  * 第二个方法用于查询商品的信息，参数为商品的关键字
  * 第三个方法用于查询分页商品的信息，参数为商品的关键字，商品排序方式，用户操作（选择上一页还是下一页）以及当前页码
  * 第四个方法用于查询一个商品的信息，参数为商品编号
 **/

@Service("commodityserviveimpl")
@Transactional
public class CommodityServiveImpl implements CommodityServive {
    
	@Autowired()
	@Qualifier("commoditydaoimpl")
	private CommodityDao commoditydaoimpl;
	
	public int getCommodityNumber(String keyword) {
	   return commoditydaoimpl.getCommodityNumber(keyword);
	}  
	
	public List<Commodity> queryCommodityList(String keyword) {
	   return commoditydaoimpl.queryCommodityList(keyword);
	}

	public List<Commodity> commodityPaging(String keyword, String sort, String choice, String current) {
	   int startpage=1;
	   if(sort!=null&&sort.equals("sort-1"))
	      sort="";
	   if(sort!=null&&sort.equals("sort-2"))
	      sort="sales";
	   if(sort!=null&&sort.equals("sort-3"))
	      sort="discuss";
	   if(sort!=null&&sort.equals("sort-4"))
	      sort="price";
	   if(choice.equals("previous-page"))
	      startpage=Integer.valueOf(current)-1;
	   if(choice.equals("next-page"))
		  startpage=Integer.valueOf(current)+1;
	   return commoditydaoimpl.commodityPaging(keyword, sort, startpage);
	}

	public Commodity queryCommodity(String id) {
       return commoditydaoimpl.queryCommodity(id);
	}

}
