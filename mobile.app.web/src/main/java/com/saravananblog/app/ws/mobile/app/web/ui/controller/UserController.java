package com.saravananblog.app.ws.mobile.app.web.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saravananblog.app.ws.mobile.app.web.service.UserService;
import com.saravananblog.app.ws.mobile.app.web.shared.dto.UserDto;
import com.saravananblog.app.ws.mobile.app.web.ui.model.request.UserDetailsRequestModel;
import com.saravananblog.app.ws.mobile.app.web.ui.model.response.UserDetailsResponseModel;

import org.springframework.beans.BeanUtils;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	 UserService userService;

	
	@GetMapping
	public String getUser() {
		
		return "Get User get Called";
				
	}
	
	@PostMapping
	public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserDetailsResponseModel userDetailResponse=new UserDetailsResponseModel();
		
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser=userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userDetailResponse);
		
		return userDetailResponse;
	}
	
	@PutMapping
	public String updateUser() {
		
		return "Update user get called";
	}
	
	@DeleteMapping
	public String DeleteUser() {
	
		return "Delete User get called";
	}


}
