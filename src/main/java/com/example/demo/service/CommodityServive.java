package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Commodity;

/**
  * 修改日期:2020/3/18
  * 修改人:牟松
  * 商品业务逻辑接口，主要是用于查询商品的信息
  * 第一个方法用于查询商品的数量，参数为商品的关键字
  * 第二个方法用于查询商品的信息，参数为商品的关键字
  * 第三个方法用于查询分页商品的信息，参数为商品的关键字，商品排序方式，用户操作（选择上一页还是下一页）以及当前页码
  * 第四个方法用于查询一个商品的信息，参数为商品编号
 **/

public interface CommodityServive {
	public int getCommodityNumber(String keyword);
	public List<Commodity> queryCommodityList(String keyword);
	public List<Commodity> commodityPaging(String keyword,String sort,String choice,String current);
	public Commodity queryCommodity(String id);
}
