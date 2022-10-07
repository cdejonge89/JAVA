package com.lee.lookify.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.lee.lookify.models.Lookify;
import com.lee.lookify.services.LookifyService;

@Controller
public class HomeController {
	@Autowired
	private LookifyService lookService;
	
	//WELCOME PAGE
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//VIEW ALL - DASHBOARD
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songList", lookService.allMusic());
		return "dashboard.jsp";
	}
	
	//DETAILS
	@GetMapping("/songs/details/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Lookify lookify = lookService.findOne(id);
		model.addAttribute("lookify", lookify);
		return "details.jsp";
	}
	
	//CREATE
	@GetMapping("/songs/create")
	public String createForm(Model model) {
		Lookify emptySong = new Lookify();
		model.addAttribute("newSong", emptySong);
		return "create.jsp";
		
	}
	
	@PostMapping("/process/add")
	public String processForm(
			@Valid @ModelAttribute("newSong") Lookify lookify,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("songList", lookService.allMusic());
			return "create.jsp";
		} else {
			lookService.create(lookify);
			return "redirect:/dashboard";
		}
		
	}
	
	//DELETE
	@DeleteMapping("/songs/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		lookService.delete(id);
		return "redirect:/dashboard";
	}
	
	//SEARCH BAR
	@PostMapping("/search")
	public String redirectSearch(@RequestParam(value="artist") String artist) {
		return "redirect:/search/" + artist;
	}

	@GetMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<Lookify> songs = lookService.findByArtist(artist);
		model.addAttribute("songs", songs);
		System.out.println(songs);
		return "search.jsp";
	}
	
	//TOP TEN FILTER
	@GetMapping("/search/topTen")
	public String details(Model model) {
		List<Lookify> songs = lookService.topTen();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
	
}
