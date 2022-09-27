import java.util.ArrayList;
class DeveloperTest {
    public static void main(String[] args) {
        System.out.println("----- Starting Developer test -----");

        // create a developer - create an instance of Developer class
        Developer dev1 = new Developer();
        dev1.name = "Pepper";
        dev1.yearsOfCoding = 14;
        dev1.braincell = 2;
        dev1.languages.add("Java"); 
        dev1.languages.add("Meow");
        
        // calling on the displayInfo method created in main
        dev1.displayInfo();
    }
}