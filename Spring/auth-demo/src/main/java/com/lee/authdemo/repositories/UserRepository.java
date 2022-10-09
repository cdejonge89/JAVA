package com.lee.authdemo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.authdemo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	// logic to check if user exists
	// checking to see if user exists by checking for email 
	Optional<User> findByEmail(String email);
}
