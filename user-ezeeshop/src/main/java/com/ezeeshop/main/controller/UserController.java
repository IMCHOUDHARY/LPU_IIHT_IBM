package com.ezeeshop.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.main.dao.UserDao;
import com.ezeeshop.main.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserDao userDao;

	@Autowired
	public UserController(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "test....";
	}
	
	@PostMapping("/add_user")
	public User addUser(@RequestBody User user)
	{
		String img = "src/assets/" + user.getImageUrl();
		user.setImageUrl(img);
		userDao.save(user);
		return user;
	}
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userDao.findAll();
	}
	
	@GetMapping("/users_id/{id}")
	public User getUserById(@PathVariable int id)
	{
		return userDao.findById(id).get();
	}
	
	@GetMapping("/users_name/{name}")
	public List<User> getUserByName(@PathVariable String name)
	{
		return userDao.findByName(name);
	}
	
	@DeleteMapping("/delete_id/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable int id)
	{
		userDao.deleteById(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_name/{name}")
	public ResponseEntity<User> deleteUserByName(@PathVariable String name)
	{
		userDao.deleteByName(name);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@PutMapping("/user_update")
	public User updateUser(@RequestBody User user)
	{
		return userDao.saveAndFlush(user);
	}
}
