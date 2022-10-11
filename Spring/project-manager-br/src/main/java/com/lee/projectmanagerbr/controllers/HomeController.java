package com.lee.projectmanagerbr.controllers;

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

import com.lee.projectmanagerbr.models.Project;
import com.lee.projectmanagerbr.services.ProjectService;

@Controller
public class HomeController {
	@Autowired
	public ProjectService projectService;
	
	// show all projects
	@GetMapping("/projects")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("projectList", projectService.allProjects());
		return "dashboard.jsp";
	}
	
	//CREATE a project
	//show the form
	@GetMapping("/projects/new")
	public String createProject(
			@ModelAttribute("newProject") Project newProject, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		return "createProject.jsp";
	}
	
	//process the form
	@PostMapping("/projects/new")
	public String processProject(
			@Valid @ModelAttribute("newProject") Project project,
			BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		if(result.hasErrors()) {
			return "createProject.jsp";
		} else {
			projectService.createProject(project);
			return "redirect:/projects";
		}
		
	}
	
	//PROJECT DETAILS
	@GetMapping("/projects/{id}")
	public String projectDetails(
			@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Project project = projectService.oneProject(id);
		model.addAttribute("project", project);
		return "projectDetails.jsp";
	}
	
	//EDIT PROJECT
	//show form
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Project project = projectService.oneProject(id);
		model.addAttribute("project", project);
		//to ensure you can't edit someone elses book
		if(!project.getTeamlead().getId().equals( (Long) session.getAttribute("userId"))) {
			return "redirect:/projects";
		}
		return "editProject.jsp";
	}
	
	//process form
	@PutMapping("/projects/edit/{id}")
	public String processProject(
			@Valid @ModelAttribute("project") Project project,
			BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		if(result.hasErrors()) {
			return "editProject.jsp";
		} else {
			projectService.editProject(project);
			return "redirect:/projects";
		}
	}
	
	//DELTE
	@DeleteMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/projects";
	}
	
}
