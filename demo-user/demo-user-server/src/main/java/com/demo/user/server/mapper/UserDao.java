package com.demo.user.server.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.demo.user.server.entity.User;

@Mapper
public interface UserDao {

	@Insert("Insert into t_user(id, name) values (#{id}, #{name})")
	public int insert(User user);
	
}
