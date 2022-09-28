package com.lee.zookeeper;

public class Mammal {
	//attributes (member variable)
	private String name;
	protected int energy;

	
	// constructor
	public Mammal(String name) {
		this.name = name;
		this.energy = 100;
	}
	

	// getters/setters
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	// method
	// display energy levels, print and return energy level
	public void displayEnergy() {
		System.out.println("--- " + this.name + " ---");
		System.out.println("Energy: " + this.energy);
	}
}
