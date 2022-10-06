package com.lee.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lee.languages.models.Language;
import com.lee.languages.sevices.LanguageService;

@RestController
@RequestMapping("/api")
public class APIController {
	@Autowired
	private LanguageService langService;
	
	//FIND ALL
	@GetMapping("/language")
	public List<Language> allLang(){
		return langService.allLang();
	}
	
	//FIND ONE
	@GetMapping("/language/{id}")
	public Language oneLang(@PathVariable("id") Long id) {
		return langService.oneLang(id);
	}
	
	//CREATE
	@PostMapping("/language")
	public Language create(
			@RequestParam("name") String name,
			@RequestParam("creator") String creator,
			@RequestParam("version") int version
			) {
		Language newLang = new Language(name, creator, version);
		return langService.create(newLang);
	}
	
	//EDIT
	@PutMapping("/language/{id}")
	public Language edit(@PathVariable("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("creator") String creator,
			@RequestParam("version") int version
			) {
		Language foundLang = langService.oneLang(id);
		foundLang.setName(name);
		foundLang.setCreator(creator);
		foundLang.setVersion(version);
		return langService.edit(foundLang);
	}
	
	//DELETE
	@DeleteMapping("/language/{id}")
	public void delete(@PathVariable("id") Long id) {
		langService.delete(id);
	}
	
}
