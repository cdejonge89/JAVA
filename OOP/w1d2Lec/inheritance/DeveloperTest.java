package com.lee.inheritance;

public class DeveloperTest {

	public static void main(String[] args) {
		System.out.println(" Hello World");
        System.out.println("----- Starting Developer test -----");

        // create a developer - create an instance of Developer class
        Developer dev1 = new Developer("Pepper", 2);
        dev1.displayInfo();
        dev1.setSalary(-30);

        // method to add languages
        dev1.addOneLang("Java");
        dev1.addOneLang("Meow");
        
        // calling on the displayInfo method created in main
        dev1.displayInfo();

         // created another anonymous developer
        Developer dev2 = new Developer();
        dev2.displayInfo();
        
        System.out.println("Dev count: " + Developer.getDevCount());
        System.out.println("Total languages: " + Developer.getTotalLanguages());
        
        JuniorDeveloper dev3 = new JuniorDeveloper();
        dev3.displayInfo();
        dev3.completeInternsip();
        dev3.displayInfo();
        dev3.completeProject();
        dev3.completeProject();
        dev3.completeProject();
        dev3.displayInfo();
        
        JuniorDeveloper dev4 = new JuniorDeveloper("Ohio Joe");
        dev4.displayInfo();
        
        SeniorDeveloper dev5 = new SeniorDeveloper();
        dev5.yellAtJunDev(dev4);
        dev5.yellAtJunDev(dev3);
        dev5.displayInfo();
	}

}