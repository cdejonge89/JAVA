package com.lee.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lee.bookclub.models.LoginUser;
import com.lee.bookclub.models.User;
import com.lee.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	// CREATE
	// REGISTER user and check validations
	public User register(User newUser, BindingResult result) {
    	// Reject if email is false(present in database)
    	// 1. find user in the DB by email
    	//.findByEmail email can be found in newUser object
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	
    	// 2. if the email is present, reject
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "Unique", "The email is already registered");
    	}
    	
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "Passowrds do not match");
    		System.out.println(result);
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	// Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	userRepo.save(newUser);
        return newUser;
    }
	
	//LOGIN
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
		if(!optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "This email is not registered");
			return null;
		}
		User user = optionalUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid password!");
		}
		if(result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	
}
