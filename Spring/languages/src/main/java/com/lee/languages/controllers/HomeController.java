package com.lee.languages.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.languages.models.Language;
import com.lee.languages.sevices.LanguageService;

@Controller
public class HomeController {
	
	@Autowired
	private LanguageService langService;
	
	//VIEW ONE
	@GetMapping("/languages/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Language language = langService.oneLang(id);
		model.addAttribute("language", language);
		return "details.jsp";
	}
	
	//VIEW ALL
	@GetMapping("/languages") 
	public String dashboard(Model model) {
		model.addAttribute("langList", langService.allLang() );
		// this line let's me render the form
		model.addAttribute("newLanguage", new Language());
		return "dashboard.jsp";
	}
	
	//CREATE
	@PostMapping("/process/add")
	public String processForm(
			@Valid @ModelAttribute("newLanguage") Language language,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			//importing the list all to process to the route
			model.addAttribute("langList", langService.allLang() );
			return "dashboard.jsp";
		} else {
			langService.create(language);
			return "redirect:/languages";
		}
		
	}

	//EDIT
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = langService.oneLang(id);
        model.addAttribute("language", language);
        return "editLang.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "editLang.jsp";
        } else {
            langService.edit(language);
            return "redirect:/languages";
        }
    }
    
    //DELETE
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
        langService.delete(id);
        return "redirect:/languages";
    }

	
}
