package com.lee.inheritance;

import java.util.ArrayList;

public class Developer {

    // 1. member variables (attributes) : what it does (private)
    private String name; 
    private int yearsOfCoding;
    // Instantiate the whole array list
    private ArrayList<String> languages; 
    protected int braincell;
    private double salary;
    private static int devCount;
    private static int totalLanguages;
    
    // 2. constructor (overloaded constructor & empty argument)
    public Developer(){
        this.name = "Anonymous";
        this.yearsOfCoding = 5;
        this.languages = new ArrayList<String>();
        this.braincell = 30;
        devCount++;
    }
    
    public Developer(String name, int braincell) {
    	this.name = name;
    	this.braincell = braincell;
    	this.languages = new ArrayList<String>();
    	this.yearsOfCoding = 10;
        devCount++;
    }

    public Developer(String name, int yearsOfCoding, int braincell, double salary) {
		this.name = name;
		this.yearsOfCoding = yearsOfCoding;
		this.languages = new ArrayList<String>();
		this.braincell = braincell;
		this.salary = salary;
        devCount++;
	}
    
    // 3. getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsOfCoding() {
		return yearsOfCoding;
	}

	public void setYearsOfCoding(int yearsOfCoding) {
		this.yearsOfCoding = yearsOfCoding;
	}

	public ArrayList<String> getLanguages() {
		return languages;
	}

//	public void setLanguages(ArrayList<String> languages) {
//		this.languages = languages;
//	}

	public int getBraincell() {
		return braincell;
	}

	public void setBraincell(int braincell) {
		this.braincell = braincell;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
    public static int getDevCount(){
        return devCount;
    }
    public static void setDevCount(int updatedCount){
        devCount = updatedCount;
    }

    public static int getTotalLanguages(){
        return totalLanguages;
    }
	

    // other methods - create a print all method to call in the test
    public void displayInfo() {
        System.out.println("----- " + this.name + " -----");
        System.out.println("Years of coding " + this.yearsOfCoding);
        System.out.println("Braincell: " + this.braincell);
        System.out.println("Salary: " + this.salary);
        System.out.println("Languages: " + this.languages);
    }

    // create another method that allows us to add languages without using the ArrayList 
    public void addOneLang(String lang) {
        this.languages.add(lang);
        this.salary += 1000;
        this.braincell += 10;
        totalLanguages++;
    }

    
    
    
}
