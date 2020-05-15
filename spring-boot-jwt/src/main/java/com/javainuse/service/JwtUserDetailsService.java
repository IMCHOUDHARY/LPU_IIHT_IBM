package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javainuse.dao.AuthenticationDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AuthenticationDao authenticationDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			//return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//			//		new ArrayList<>());
//			return new User("javainuse", "$2a$05$AJPf0b11Lqhtikkv4gOSxOwt7LLFxKyIkacjJl0Sj3k.idXmT3Lnq",
//							new ArrayList<>());       //ankitchoudhary
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		
		
		if (authenticationDao.findByUsername(username).getUsername().equals(username)) {
			System.out.println("Hellooooooo    "+authenticationDao.findByUsername(username).getUsername());
			System.out.println("Password    "+authenticationDao.findByUsername(username).getPassword());
			//return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
			//		new ArrayList<>());
			return new User(authenticationDao.findByUsername(username).getUsername() , authenticationDao.findByUsername(username).getPassword(),
							new ArrayList<>());       //ankitchoudhary
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}