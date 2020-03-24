package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.CommodityDao;
import com.example.demo.entity.Commodity;

/**
 * 修改日期:2020/3/18
 * 修改人:牟松
 * 商品信息接口的具体实现类，主要是用于查询商品的信息
 * 第一个方法用于查询商品的数量，参数为商品的关键字
 * 第二个方法用于查询商品的信息，参数为商品的关键字
 * 第三个方法用于查询分页商品的信息，参数为商品的关键字，商品排序方式，以及商品页码
 * 第四个方法用于查询一个商品的信息，参数为商品编号
 **/

@Repository("commoditydaoimpl")
public class CommodityDaoImpl implements CommodityDao{
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
  
    static class CommodityRowMapper implements RowMapper<Commodity>{
        public Commodity mapRow(ResultSet resultset, int rowNum) throws SQLException {
        	Commodity commodity = new Commodity();
			commodity.setId(resultset.getString("id"));
			commodity.setImg(resultset.getString("img"));
			commodity.setPrice(resultset.getString("price"));
			commodity.setName(resultset.getString("name"));
			commodity.setDiscuss(resultset.getString("discuss"));
			commodity.setSales(resultset.getString("sales"));
			commodity.setStore(resultset.getString("store"));
            return commodity;
        }
    }

	public int getCommodityNumber(String keyword) {
		String sql="select COUNT(name) from commodity where name like '%"+keyword+"%'";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}  
	
	public List<Commodity> queryCommodityList(String keyword) {
        String sql="select * from commodity where name like '%"+keyword+"%' limit 0,15";
        List<Commodity> commoditylist = jdbcTemplate.query(sql, new CommodityRowMapper());     
        return commoditylist;
	}

	public List<Commodity> commodityPaging(String keyword,String sort,int startpage) {
		String sql = "select * from commodity where name like '%"+keyword+"%'";
		if(!sort.equals("")&&!sort.equals(" "))
		   sql =sql+" order by "+sort+" desc";
		sql=sql+" limit "+(startpage-1)*15+",15";		
		List<Commodity> commoditylist = jdbcTemplate.query(sql, new CommodityRowMapper());
	    return commoditylist;
	}

	public Commodity queryCommodity(String id) {
		String sql = "select * from commodity where id=?";
		return jdbcTemplate.queryForObject(sql,new CommodityRowMapper(),id);
	}
}
