package com.lee.inheritance;

public class JuniorDeveloper extends Developer {
	// 1. attributes
	private boolean isIntern;
	
	// 2. constructors
	public JuniorDeveloper() {
		super("A random Junior Developer", 50);
		this.setYearsOfCoding(1);
		this.isIntern=true;
	}
	
	public JuniorDeveloper(String name) {
		super(name, 1, 60, 85000);
		this.isIntern=false;
	}
		
	// 3. getters/setters
		
	public boolean isIntern() {
		return isIntern;
	}

	public void setIntern(boolean isIntern) {
		this.isIntern = isIntern;
	}

	// 4. other methods
	public void completeInternsip() {
		this.setSalary(1000);
		this.isIntern=false;
	}
		
	public void completeProject() {
		this.setSalary(this.getSalary()+1000);
	}
	}

