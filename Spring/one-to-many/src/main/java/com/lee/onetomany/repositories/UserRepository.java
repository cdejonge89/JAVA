package com.lee.onetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.onetomany.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//FIND ALL
	List<User> findAll();
}
