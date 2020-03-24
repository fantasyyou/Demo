package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Discuss;

/**
 * 修改日期:2020/3/21
 * 修改人:牟松
 * 用户评论数据访问层接口，用于查询，添加，删除用户的评论
 * 第一个方法用于添加一条评论，参数为一个评论类对象
 * 第二个方法用于删除一条评论，参数为一个评论类对象
 * 第三个方法用于查询一个商品的评论，参数为商品编号，返回结果为一个List集合
**/

public interface DiscussDao {
   public int addDiscuss(Discuss discuss);                 //增加一条评论信息
   public void deleteDiscuss(Discuss discuss);             //删除一条评论信息
   public List<Discuss> queryDiscuss(String commodityid);  //根据商品ID查询商品评论
}
