import java.util.ArrayList;
// create the item class with the member variables listed above
class Item {
    private String name;
    private double price;
    private int index;

    // add a constructor to your item class that takes a string name 
    // and double price as arguments to se the name and price for that object instantiation
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // create getters and setters for name and price
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    // method to print nicely
    public void displayMenu() {
        System.out.println("----- " + this.name + " -----");
        System.out.printf("Price: $%s \n", this.price);
    }
}

