package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Discuss;

@Mapper
public interface DiscussMap {
	// 查看所有问题,不包括课程作者
	public List<Discuss> selectAll();

	// 插入一条问题
	public int insertOne(Discuss discuss);
	
	//获取问题的信息，及作者的名字和头像
	public List<Discuss> selectAllDisAndAuthor();
	
}
