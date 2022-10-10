package com.lee.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.lee.bookclub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	// finding the user by their email
	Optional<User> findByEmail(String email);
	

}
