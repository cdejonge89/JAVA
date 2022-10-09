package com.lee.authdemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lee.authdemo.models.LoginUser;
import com.lee.authdemo.models.User;
import com.lee.authdemo.services.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userService;
	
	//LOGIN/REGISTER
	//1. show form
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}
	
	// 2.1 process register
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		// this line is calling newUser and passing result of userService
		User registeredUser =userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		} else {
			session.setAttribute("userName", registeredUser.getUserName());
			return "redirect:/donations";
		}
	}
	
	// 2.2 process login
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		} else {
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getUserName());
			return "redirect:/donations";
		}
	}
	
	
	//logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
