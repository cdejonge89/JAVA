package com.lee.zookeeper;

public class Bat extends Mammal{
	// constructor
	public Bat(String name) {
		super(name);
		this.setEnergy(400);
	}
	// method
	public void fly() {
		System.out.println("whooooosh");
		this.energy -= 50;
	}
	
	public void eatHumans() {
		System.out.println(this.getName() + " is eating...something...");
		this.energy += 25;
		
	}
	
	public void attackTown() {
		System.out.println("There's crackling in the distance..");
		this.energy -= 100;
	}
}
