package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.ConcernDao;
import com.example.demo.entity.ConcernCommodity;

/**
 * 修改日期:2020/3/20
 * 修改人:牟松
 * 关注商品数据访问层的具体实现类，用于实现对关注商品的信息管理
 * 第一个用于查询用户关注的商品，在订单下面的我的关注栏
 * 中使用，参数为用户的ID（用户手机号），起始下标，实现
 * 对关注商品的分页浏览
 * 第二个方法用于添加一个关注的商品，参数为一个商品对象
 * 第三个方法用于删除一个关注的商品，参数为一个商品对象
**/

@Repository("concerndaoimpl")
public class ConcernDaoImpl implements ConcernDao{
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //创建ConcernCommodityRowMapper，用于将查询结果映射成一个ConcernCommodity对象
    static class ConcernCommodityRowMapper implements RowMapper<ConcernCommodity>{
        public ConcernCommodity mapRow(ResultSet resultset, int rowNum) throws SQLException {
        	ConcernCommodity ConcernCommodity=new ConcernCommodity();
        	ConcernCommodity.setCommodityid(resultset.getString("id"));
        	ConcernCommodity.setImg(resultset.getString("img"));
        	ConcernCommodity.setName(resultset.getString("name"));
        	ConcernCommodity.setPrice(resultset.getString("price"));
            return ConcernCommodity;
        }
    }
    
	@Override
	public List<ConcernCommodity> queryConcernCommodity(String userid, int start) {
		String sql="select id,img,name,price from commodity INNER JOIN concerncommodity ON"
				 + "(commodity.id=concerncommodity.commodityid and concerncommodity.userid=?) limit ?,5";
	    List<ConcernCommodity> concerncommoditylist = jdbcTemplate.query(sql, new ConcernCommodityRowMapper(),userid,start);     
		return concerncommoditylist;
	}

	@Override
	public void addConcernCommodity(ConcernCommodity concerncommodity) {
		String sql = "insert into concerncommodity(userid,commodityid) values(?,?)";
        this.jdbcTemplate.update(sql,concerncommodity.getUserid(),concerncommodity.getCommodityid());		
	}

	@Override
	public void deleteConcernCommodity(ConcernCommodity concerncommodity) {
		String sql = "delete from concerncommodity where userid? and commodityid=?";
        this.jdbcTemplate.update(sql,concerncommodity.getUserid(),concerncommodity.getCommodityid());	
	}
}
