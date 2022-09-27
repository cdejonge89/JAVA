import java.util.ArrayList;
// create the item class with the member variables listed above
class Items {
    public String name;
    public double price;

    // method to print nicely
    public void displayMenu() {
        System.out.println("----- " + this.name + " -----");
        System.out.printf("Price: $%s \n", this.price);
    }
}

