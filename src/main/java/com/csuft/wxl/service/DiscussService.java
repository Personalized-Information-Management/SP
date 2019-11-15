package com.csuft.wxl.service;

import java.util.List;

import com.csuft.wxl.pojo.Discuss;

public interface DiscussService {
	List<Discuss> getAllList();

	//获得所有问题包括作者的名字和头像
	List<Discuss> getAllDisAndAuthorList();
	
	public int setDis(Discuss discuss);
}
