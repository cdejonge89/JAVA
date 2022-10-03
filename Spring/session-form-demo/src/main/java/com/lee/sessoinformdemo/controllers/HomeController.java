package com.lee.sessoinformdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	//----------- SESSION -------------
	@GetMapping("/sessions/home")
	public String sessionHome(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			//get count from session
			Integer tempCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", tempCount+1);
		}
		return "/sessions/home.jsp";
	}
	
	@GetMapping("/sessions/getcount")
	public String getCount() {
		return "/sessions/getCount.jsp";
	}
	
	// ------------- GET (SEARCH) FORM ------------
	// show the form
	@GetMapping("/search")
	public String showSearchForm() {
		return "/searchForm/searchForm.jsp";
	}
	
	// process+display
	@GetMapping("/searchResult")
	public String displaySearchResult(
			@RequestParam("keyword") String keyword,
			Model model){
		model.addAttribute("keyword", keyword);
		System.out.println(keyword);
		return "/searchForm/searchResult.jsp";
	}
	
	// ------------- REVIEW FORM ------------
	// 1. Show the form
	@GetMapping("/review")
	public String showReviewForm() {
		return "/reviewForm/reviewForm.jsp";
	}
	
	// 2. process the form - get the info from the form (requestParam)
	// save the result in session (since we don't have a database yet)
	@PostMapping("/process/review")
	public String processReviewForm(
			@RequestParam("product") String product,
			@RequestParam("rating") Integer rating,
			@RequestParam("comments") String comments,
			HttpSession session
			){
		// save in session
		session.setAttribute("product", product);
		session.setAttribute("rating", rating);
		session.setAttribute("comments", comments);
		// for post mapping, never return
		//always redirect
		return "redirect:/review/result";
	}
	
	// 3. display the result
	@GetMapping("/review/result")
	public String displayReviewResult() {
		return "/reviewForm/reviewResult.jsp";
	}
	
	
}
