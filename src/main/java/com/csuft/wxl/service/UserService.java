package com.csuft.wxl.service;

import com.csuft.wxl.pojo.User;

public interface UserService {
	String getPassword(User user);
	String getName(User user);
}
