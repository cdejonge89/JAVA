import java.util.ArrayList;
class Developer {
    // create a blue print
    // 1. member variables : what it does
    public String name; 
    public int yearsOfCoding;
    // instanciate the whole array list
    public ArrayList<String> languages = new ArrayList<String>();
    public int braincell;

    // 2. constructor

    // other methods - create a print all method to call in the test
    public void displayInfo() {
        System.out.println("----- " + this.name + " -----");
        System.out.println("Years of coding " + this.yearsOfCoding);
        System.out.println("Braincell: " + this.braincell);
        System.out.println("Languages: " + this.languages);
    }
}