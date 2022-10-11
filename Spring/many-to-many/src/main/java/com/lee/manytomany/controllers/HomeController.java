package com.lee.manytomany.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lee.manytomany.models.Donation;
import com.lee.manytomany.services.DonationService;
import com.lee.manytomany.services.UserService;

@Controller
public class HomeController {
	@Autowired 
	private DonationService donationService;
	
	@Autowired
	private UserService userService;
	
	//DASHBOARD
	@GetMapping("/donations")
	public String donationDash(HttpSession session, Model model) {
		model.addAttribute("donationList", donationService.allDonations());
		model.addAttribute("userList", userService.allUsers());
		// these two lines are for many to many so we can pass user in to dashboard
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("loggedUser", userService.oneUser(userId));
		return "dashboard.jsp";
	}
	
	// CREATE NEW DONATION
	//1. show the form
	@GetMapping("/donations/new")
	public String showDonationForm(Model model) {
		model.addAttribute("newDonation", new Donation());
		model.addAttribute("userList", userService.allUsers());
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
			donationService.createDonation(donation);
		return "redirect:/donations";
	}
	
	//FIND ONE DONATION
	@GetMapping("/donations/{id}")
	public String oneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationService.oneDonation(id));
		return "oneDonation.jsp";
	}
		
	//EDIT DONATION
	@GetMapping("/donations/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Donation donation = donationService.oneDonation(id);
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
			donationService.editDonation(donation);
			return "redirect:/donations";
		}
		
	}
	
	// RECEIVE DONATION
	@PutMapping("/donations/{id}/receive")
	public String receiveDonation(@PathVariable("id") Long donationId, HttpSession session) {
		Long userId = (long) session.getAttribute("userId");
		donationService.receiveDonation(donationId, userId);
		return "redirect:/donations";
	}
	
	//RETURN DONATION
	@PutMapping("/donations/{id}/return")
	public String returnDonation(@PathVariable("id") Long donationId, HttpSession session) {
		Long userId = (long) session.getAttribute("userId");
		donationService.returnDonation(donationId, userId);
		return "redirect:/donations";
	}
	
}
