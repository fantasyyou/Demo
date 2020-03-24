package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.DiscussDao;
import com.example.demo.entity.Discuss;

/**
 * 修改日期:2020/3/21
 * 修改人:牟松
 * 用户评论数据访问层接口的具体实现类，用于查询，添加，删除用户的评论
 * 第一个方法用于添加一条评论，参数为一个评论类对象
 * 第二个方法用于删除一条评论，参数为一个评论类对象
 * 第三个方法用于查询一个商品的评论，参数为商品编号，返回结果为一个List集合
**/

@Repository("discussdaoimpl")
public class DiscussDaoImpl implements DiscussDao{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Autowired
	private Date date;
    
	@Autowired
	private SimpleDateFormat simpledateformat;
    
    static class DiscussRowMapper implements RowMapper<Discuss>{
        public Discuss mapRow(ResultSet resultset, int rowNum) throws SQLException {
        	Discuss discuss=new Discuss();
        	discuss.setUsername(resultset.getString("username"));
        	discuss.setContent(resultset.getString("content"));
        	discuss.setTime(resultset.getString("time"));
            return discuss;
        }
    }

	public int addDiscuss(Discuss discuss) {
		String sql = "insert into discuss(commodityid,username,content,time) values(?,?,?,?)";
		this.jdbcTemplate.update(sql,
				                 discuss.getCommodityid(),
				                 discuss.getUsername(),
				                 discuss.getContent(),
				                 simpledateformat.format(date));
		return 1;		
	}


	public void deleteDiscuss(Discuss discuss) {
		String sql = "delete from discuss where commodityid=? and username=?";
        this.jdbcTemplate.update(sql,discuss.getCommodityid(),discuss.getUsername());
		
	}

	public List<Discuss> queryDiscuss(String commodityid) {
		String sql = "select * from discuss where commodityid=?";
        List<Discuss> discusslist = jdbcTemplate.query(sql, new DiscussRowMapper(),commodityid);     
        return discusslist;  
	}
}
