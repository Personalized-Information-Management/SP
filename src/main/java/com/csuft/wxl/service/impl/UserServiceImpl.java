package com.csuft.wxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMap userMap;
	@Override
	public String getPassword(User user) {
		// TODO Auto-generated method stub
		return userMap.selectPasswordByUser_idUser_per(user);
	}
	@Override
	public String getName(User user) {
		// TODO Auto-generated method stub
		return userMap.selectUser_nameByUser_idUser_per(user);
	}

}
