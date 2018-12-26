package com.saravananblog.app.ws.mobile.app.web;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saravananblog.app.ws.mobile.app.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
