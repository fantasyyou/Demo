package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.dao.DiscussDao;
import com.example.demo.entity.Discuss;
import com.example.demo.service.DiscussService;

/**
 * 修改日期:2020/3/21
 * 修改人:牟松
 * 用户评论业务逻辑的具体实现类，用于查询，添加，删除用户的评论
 * 第一个方法用于添加一条评论，参数为商品编号，用户名，评论内容
 * 第二个方法用于删除一条评论，参数为商品编号，用户名
 * 第三个方法用于查询一个商品的评论，参数为商品编号，返回结果为一个List集合
**/

@Service("discussserviceimpl")
public class DiscussServiceImpl implements DiscussService{
    
	@Autowired
	@Qualifier("discussdaoimpl")
	private DiscussDao discussdaoimpl;
	
	@Autowired
	private Discuss discuss;

	@Override
	public int addDiscuss(String commodityid, String username, String content) {
		discuss.setCommodityid(commodityid);
		discuss.setUsername(username);
		discuss.setContent(content);
		discussdaoimpl.addDiscuss(discuss);
		return 0;
	}

	@Override
	public void deleteDiscuss(String commodityid, String username) {
		discuss.setCommodityid(commodityid);
		discuss.setUsername(username);
		discussdaoimpl.addDiscuss(discuss);	
	}

	@Override
	public List<Discuss> queryDiscuss(String commodityid) {
        return discussdaoimpl.queryDiscuss(commodityid);
	}

}
