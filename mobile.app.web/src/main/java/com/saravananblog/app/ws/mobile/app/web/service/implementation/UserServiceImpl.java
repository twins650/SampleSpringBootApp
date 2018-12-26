package com.saravananblog.app.ws.mobile.app.web.service.implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saravananblog.app.ws.mobile.app.io.entity.UserEntity;
import com.saravananblog.app.ws.mobile.app.web.UserRepository;
import com.saravananblog.app.ws.mobile.app.web.service.UserService;
import com.saravananblog.app.ws.mobile.app.web.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {
	
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUser");
		
		UserEntity SavedUserValues= userRepository.save(userEntity);
		
		
		UserDto returnValue=new UserDto();
		
		BeanUtils.copyProperties(SavedUserValues, returnValue);
		
		return returnValue;
	}

}
