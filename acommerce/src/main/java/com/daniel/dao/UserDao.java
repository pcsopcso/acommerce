package com.daniel.dao;

import java.util.List;

import com.daniel.model.User;

public interface UserDao {

	public int create (User user)throws Exception;
	
	public int update(User user)throws Exception;
	
	public int delete(String username)throws Exception;
	
	public User findById(String username)throws Exception;
	
	public List<User> findAll()throws Exception;
}
