package com.lee.authdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lee.authdemo.models.LoginUser;
import com.lee.authdemo.models.User;
import com.lee.authdemo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	// REGISTER USER AND CHECK VALIDATIONS
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
    
    // LOGIN USER AND CHECK VALIDATIONS
    public User login(LoginUser newLogin, BindingResult result) {
    	// 1. Find user in the DB by email
			Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
			System.out.println(optionalUser.isPresent());
			// 2. if email is not present, reject
			if(!optionalUser.isPresent()) {
				result.rejectValue("email", "Matches", "This email is not registered");
				return null;
			}
			
			// 3.1 grab the user from potential user
			User user = optionalUser.get();
		
			// 3.2 if BCrypt password match fails
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid Password!");
			}
			
			// 4. if result has errors, return
			if(result.hasErrors()) {
				return null;
			}
			
			// Otherwise, return the user object
			return user;
    }
    
}
