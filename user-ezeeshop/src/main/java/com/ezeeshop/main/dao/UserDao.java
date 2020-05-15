package com.ezeeshop.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezeeshop.main.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query
	public List<User> findByName(String name);
	
	@Query
	public void deleteByName(String name);

}
