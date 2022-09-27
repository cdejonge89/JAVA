import java.util.ArrayList;
// create the order class with the member variables listed above
class Order {
    private String name;
    private boolean ready;
    // default if nothing assigned
    private ArrayList<Item> items;

    // add a constructor to your order class that takes in no arguments
    // but sets the name to "Guest" and initializes the items array
    // to an empty ArrayList<Item>
    public Order() {
        this.name = "Guest";
        this.ready = ready;
        this.items = new ArrayList<Item>();
    }

    // pverloaded constructor 
    // add an overloaded constructor for order that takes string name
    // as an argument so you can 
    // create an instance with a name
    public Order(String name) {
        this.name = name;
        this.ready = ready;
        this.items = new ArrayList<Item>();
    }

    // getters and setters for member variables
    // using good nameing conventions for boolean
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public boolean getReady() {
        return this.ready;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    // class methods

    //add item
    // create a method called addItem that takes an item object as an argument
    // and adds the item to the order's items array
    // no return
    public void addItem(Item item) {
        this.items.add(item);
    }

    // get status message
    // create a method called getStatusMessage that returns a string message
    // if the order is ready, return "Your order is ready"
    // if not, return "Thank you for waiting. it will be ready soon"
    public String getStatusMessage() {
        if(ready == true) {
            return this.name + ", your order is ready";
        } else {
            return this.name + ", thank you for waiting, your order will be ready soon.";
        }
    }

    // get order total
    // create a method called getOrderTotal that sums together each of the item's prices
    // and returns the total amount
    public double getOrderTotal() {
        double total = 0.0;
        for(Item item: this.items) {
            total += item.getPrice();
        }
        return total;
    }

    // display
    // create a method called display that prints out the order info

    public void display(){
        System.out.printf("Customer Name: %s | ", this.name);
        for(Item item: this.items) {
            System.out.println("Order: " + item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
}