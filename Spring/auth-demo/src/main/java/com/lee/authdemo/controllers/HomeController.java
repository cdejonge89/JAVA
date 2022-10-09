package com.lee.authdemo.controllers;

import javax.servlet.http.HttpSession;
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

import com.lee.authdemo.models.Donation;
import com.lee.authdemo.services.DonationService;

@Controller
public class HomeController {
	@Autowired
	private DonationService donationService;
	
	//dashboard - FIND ALL
	@GetMapping("/donations")
	public String dashboard(HttpSession session, Model model) {
		// if statement for security - can only go to this page if logged in
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("donationList", donationService.allDonations());
		return "dashboard.jsp";
	}
	
	//CREATE
	//show form
	@GetMapping("/donations/new")
	public String createDonation(
			@ModelAttribute("newDonation") Donation newDonation) {
		return "newDonation.jsp";
	}
	
	//process
	@PostMapping("/donations/new")
	public String processDonation(
			@Valid @ModelAttribute("newDonation") Donation donation,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newDonation.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/donations";
		}
	}
	
	//FIND ONE
	@GetMapping("/donations/{id}")
	public String donationDetails(@PathVariable("id") Long id, Model model) {
		Donation foundDonation = donationService.oneDonation(id);
		model.addAttribute("donation", foundDonation);
		return "oneDonation.jsp";
	}
	
	//EDIT
	//show form
	@GetMapping("/donations/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model, HttpSession session) {
		Donation foundDonation = donationService.oneDonation(id);
		model.addAttribute("donation", foundDonation);
		// to protect route
		if(foundDonation.getDonor().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/donations";
		}
		return "editPage.jsp";
	}
	
	//process form
	@PutMapping("/donations/edit/{id}")
	public String processForm(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editPage.jsp";
		} else {
			donationService.editDonation(donation);
			return "redirect:/donations";
		}
	}
	
	//DELETE
	@DeleteMapping("/donations/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationService.deleteDonation(id);
		return "redirect:/donations";
	}
}
