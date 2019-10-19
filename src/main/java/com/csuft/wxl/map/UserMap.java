package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.User;

@Mapper
public interface UserMap {
	public List<User> selectAll();
	public String selectPasswordByUser_idUser_per(User user);
	public String selectUser_nameByUser_idUser_per(User user);
}
