package com.lee.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lee.lookify.models.Lookify;
import com.lee.lookify.services.LookifyService;

@RestController
public class APIController {
	@Autowired
	private LookifyService lookService;
		
	//FIND ALL
	@GetMapping("/songs")
	public List<Lookify> allMusic() {
		return lookService.allMusic();
	}
	
	//CREATE
	@PostMapping("/songs/new")
	public Lookify create(
			@RequestParam("title") String title,
			@RequestParam("artist") String artist,
			@RequestParam("rating") int rating
			) {
		Lookify newSong = new Lookify(title, artist, rating);
		return lookService.create(newSong);
	}
	
	//FIND ONE
	@GetMapping("/songs/{id}")
	public Lookify details(@PathVariable("id") Long id) {
		return lookService.findOne(id);
	}
	
	//EDIT
	@PutMapping("/songs/{id}")
	public Lookify edit(@PathVariable("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("artist") String artist,
			@RequestParam("rating") int rating
			) {
		Lookify foundSong = lookService.findOne(id);
		foundSong.setTitle(title);
		foundSong.setArtist(artist);
		foundSong.setRating(rating);
		return lookService.edit(foundSong);
	}
	
	//DELETE
	@DeleteMapping("/songs/{id}")
	public void delete(@PathVariable("id") Long id) {
		lookService.delete(id);
	}
	
	
}
