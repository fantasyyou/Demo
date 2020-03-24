package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.ShoppingCarDao;
import com.example.demo.entity.ShoppCartColumn;

/**
 * 修改日期:2020/3/19
 * 修改人:牟松
 * 购物车信息修改接口的具体实现类，主要是用于查询，增加，删除，修改购物车商品信息
 * 第一个方法用于查询用户的购物车信息，参数为用户ID
 * 第二个方法用于添加商品到购物车，参数为一个购物车商品实体
 * 第三个方法用于删除购物车中的商品，参数为商品编号和用户ID
 * 第四个方法用于修改购物车中商品的数量，参数为商品编号和用户ID以及修改后的数量
 **/

@Repository("shoppingcardaoimpl")
public class ShoppingCarDaoImpl implements ShoppingCarDao{
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static class ShoppCartColumnRowMapper implements RowMapper<ShoppCartColumn>{
        public ShoppCartColumn mapRow(ResultSet resultset, int rowNum) throws SQLException {
        	ShoppCartColumn shoppcartcolumn=new ShoppCartColumn();
		    shoppcartcolumn.setId(resultset.getString("id"));
		    shoppcartcolumn.setUserid(resultset.getString("userid"));
		    shoppcartcolumn.setStore(resultset.getString("store"));
		    shoppcartcolumn.setImg(resultset.getString("img"));
		    shoppcartcolumn.setName(resultset.getString("name"));
		    shoppcartcolumn.setIntroduce(resultset.getString("introduce"));
		    shoppcartcolumn.setPrice(resultset.getString("price"));
		    shoppcartcolumn.setNumber(resultset.getString("number"));
            return shoppcartcolumn;
        }
    }

	public List<ShoppCartColumn> queryCommList(String userid) {
	    String sql = "select * from shoppcartcolumn where userid="+"'"+userid+"'";
        List<ShoppCartColumn> shoppcartcolumnlist = jdbcTemplate.query(sql, new ShoppCartColumnRowMapper());     
        return shoppcartcolumnlist;     
	}

	public int addComm(ShoppCartColumn shoppcartcolumn) {
		String sql = "insert into shoppcartcolumn(id,userid,img,name,introduce,price,number,store) values(?,?,?,?,?,?,?,?)";
		this.jdbcTemplate.update(sql,
				                 shoppcartcolumn.getId(),
				                 shoppcartcolumn.getUserid(),
				                 shoppcartcolumn.getImg(),
				                 shoppcartcolumn.getName(),
				                 shoppcartcolumn.getIntroduce(),
				                 shoppcartcolumn.getPrice(),
				                 shoppcartcolumn.getNumber(),
				                 shoppcartcolumn.getStore());
		return 1;
	}

	public void deleteComm(String id, String userid) {
		String sql = "delete from shoppcartcolumn where id=? and userid=?";
        this.jdbcTemplate.update(sql,id,userid);	
	}

	public void updateComm(String id, String userid, String number) {
		String sql = "update shoppcartcolumn set number=? where id=? and userid=?";
		System.out.println(sql);
	    this.jdbcTemplate.update(sql,number,id,userid);		
	}

}
