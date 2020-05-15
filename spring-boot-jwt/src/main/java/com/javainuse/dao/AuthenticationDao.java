package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javainuse.model.Authenticate;

public interface AuthenticationDao extends JpaRepository<Authenticate, Integer> {

	@Query
	public Authenticate findByUsername(String username);
}
