package com.lee.projectmanagerbr.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lee.projectmanagerbr.models.LoginUser;
import com.lee.projectmanagerbr.models.User;
import com.lee.projectmanagerbr.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	//CREATE - register user and check validations
	public User register(User newUser, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		//if email already exists, reject
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "Unique", "This email is already registered");
		}
		//if password doesn't match, reject
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords do not match");
			System.out.println(result);
		}
		//return null if result has errors
		if(result.hasErrors()) {
			return null;
		}
		//hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		userRepo.save(newUser);
		return newUser;
	}
		
		//LOGIN
		public User login(LoginUser newLogin, BindingResult result) {
			// find user in the db by email
			Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
			// if email is not present, reject 
			if(!optionalUser.isPresent()) {
				result.rejectValue("email", "Matches", "This email is not registered");
				return null;
			}
			// grab the user from potential user
			User user = optionalUser.get();
			// if Bcrypt math fails. reject
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid password!");
			}
			//if result has errors, return 
			if(result.hasErrors()) {
				return null;
			}
			// otherwise return the user object
			return user;
	}
	
}
