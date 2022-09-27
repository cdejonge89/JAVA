import java.util.ArrayList;
class Developer {
    // create a blue print
    // 1. member variables : what it does (private)
    private String name; 
    private int yearsOfCoding;
    // instanciate the whole array list
    private ArrayList<String> languages; 
    private int braincell;
    private double salary;

    // 2. constructor (overladed constructor & empty argument)
    public Developer(){
        this.name = "Anonymous";
        this.yearsOfCoding = 5;
        this.languages = new ArrayList<String>();
        this.braincell = 30;
    }

    public Developer(String name, int braincell) {
        this.name = name;
        this.braincell = braincell;
        this.languages = new ArrayList<String>();
        this.yearsOfCoding = 10;
    }

    // 3. getters & setters (getVariableName (getYearsOfCoding))
    // the point is for developers to change something outside this file
    // getter: return data type of variable, no parameters
    public String getName() {
        return this.name;
    }

    public int getYearsOfCoding() {
        return this.yearsOfCoding;
    }

    public int getBraincell(){
        return this.braincell;
    }
    public double getSalary(){
        return this.salary;
    }

    public ArrayList<String> getLanguages(){
        return this.languages;
    }


    // 3. setters : no return, with parameters with same datatype
    public void setName(String name) {
        this.name = name;
    }

    public void setYearsOfCoding(int yearsOfCoding) {
        this.yearsOfCoding = yearsOfCoding;
    }

    public void setBraincell(int braincell) {
        this.braincell = braincell;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
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
    }
}