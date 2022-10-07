package com.lee.onetomany.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lee.onetomany.models.Donation;
import com.lee.onetomany.models.User;
import com.lee.onetomany.services.MainService;

@Controller
public class HomeController {
	@Autowired 
	private MainService mainService;
	
	//DASHBOARD
	@GetMapping("/")
	public String donationDash(Model model) {
		model.addAttribute("donationList", mainService.allDonations());
		model.addAttribute("userList", mainService.allUsers());
		return "donationDashboard.jsp";
	}
	
	// CREATE NEW USER
	//1. show the form
	@GetMapping("/users/new")
	public String showUserForm(Model model) {
		model.addAttribute("newUser", new User());
		return "newUser.jsp";
	}
	
	//2. process
	@PostMapping("/users/process")
	public String processUserForm(
			@Valid @ModelAttribute("newUser") User user, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "newUser.jsp";
		}else {
			mainService.createUser(user);
			return "redirect:/";
		}
	}
	
	// CREATE NEW DONATION
	//1. show the form
	@GetMapping("/donations/new")
	public String showDonationForm(Model model) {
		model.addAttribute("newDonation", new Donation());
		model.addAttribute("userList", mainService.allUsers());
		return "newDonation.jsp";
	}
	
	//2. process the form
	@PostMapping("/donations/process")
	public String processDonationForm(
			@Valid @ModelAttribute("newDonation") Donation donation,
			BindingResult result, Model model
			) {
		if(result.hasErrors()) {
			return "newDonation.jsp";
		} else
			mainService.createDonation(donation);
		return "redirect:/";
	}
	
	//FIND ONE DONATION
	@GetMapping("/donations/{id}")
	public String oneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", mainService.oneDonation(id));
		return "oneDonation.jsp";
	}
	
	
	//FIND ONE USER
	@GetMapping("/users/{id}")
	public String oneUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", mainService.oneUser(id));
		return "oneUser.jsp";
	}
	
	
	
	//EDIT DONATION
	// view form
	@GetMapping("/donations/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Donation donation = mainService.oneDonation(id);
		model.addAttribute("donation", donation);
		return "editDonation.jsp";
	}
	
	// process form
	@PutMapping("/donations/edit/{id}")
	public String processForm(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "editDonation.jsp";
		} else {
			mainService.editDonation(donation);
			return "redirect:/";
		}
		
	}
	
	//DELETE DONATION
	@DeleteMapping("/donations/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		mainService.deleteDonation(id);
		return "redirect:/";
	}

	
}
