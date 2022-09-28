package com.lee.zookeeper;

public class Gorilla extends Mammal {
	//constructor 
	public Gorilla(String name) {
		super(name);
	}

	// method
	public void throwSomething() {
		System.out.println(this.getName() + " threw something");
		this.energy -= 5;
//		System.out.println("Gorilla Energy: " + this.getEnergy());

	}
	
	public void eatBananas() {
		System.out.println(this.getName() + " ate a banana");
		this.energy +=10;
//		System.out.println("Gorilla Energy: " + this.getEnergy());
	}
	
	public void climb() {
		System.out.println(this.getName() + " is climbing a tree");
		this.energy -= 10;
//		System.out.println("Gorilla energy " + this.getEnergy());
	}
	

}
