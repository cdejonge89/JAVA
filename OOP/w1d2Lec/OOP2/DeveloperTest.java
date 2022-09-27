import java.util.ArrayList;
class DeveloperTest {
    public static void main(String[] args) {
        System.out.println("----- Starting Developer test -----");

        // create a developer - create an instance of Developer class
        Developer dev1 = new Developer("Pepper", 2);
        dev1.displayInfo();
        dev1.setSalary(-30);
        // this way adds language 
        // ArrayList<String> dev1Lang = dev1.getLanguages();
        // dev1Lang.add("Java");
        // dev1Lang.add("Meow");

        // this way uses the other method to add languages
        dev1.addOneLang("Java");
        dev1.addOneLang("Meow");
        
        // calling on the displayInfo method created in main
        dev1.displayInfo();

         // created another anonymous developer
        Developer dev2 = new Developer();
        dev2.displayInfo();
    }
}