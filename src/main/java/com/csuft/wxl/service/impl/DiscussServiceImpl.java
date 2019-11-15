package com.csuft.wxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.DiscussMap;
import com.csuft.wxl.pojo.Discuss;
import com.csuft.wxl.service.DiscussService;

@Service
public class DiscussServiceImpl implements DiscussService {
	@Autowired
	DiscussMap discussMap;
	@Override
	public List<Discuss> getAllList() {
		// TODO Auto-generated method stub
		return discussMap.selectAll();
	}
	@Override
	public List<Discuss> getAllDisAndAuthorList() {
		// TODO Auto-generated method stub
		return discussMap.selectAllDisAndAuthor();
	}
	@Override
	public int setDis(Discuss discuss) {
		// TODO Auto-generated method stub
		return discussMap.insertOne(discuss);
	}

}
