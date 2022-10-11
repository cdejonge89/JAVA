package com.lee.projectmanagerbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.projectmanagerbr.models.Project;
import com.lee.projectmanagerbr.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	public ProjectRepository projectRepo;
	
	//CREATE
	public Project createProject(Project newProject) {
		return projectRepo.save(newProject);
	}
	
	//FIND ALL
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	//FIND ONE
	public Project oneProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}
	
	//EDIT
	public Project editProject(Project project) {
		return projectRepo.save(project);
	}
	
	
	//DELETE
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
}
