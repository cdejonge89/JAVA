import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // constructor
    // no params, initializes items and orders to empty arrays
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // methods
    // addMenuItem
    // create a new item object with the given name and price
    public void addMenuItem(String name, double price) {
        // add the new item object to the menu items array
        Item newItem = new Item(name, price);
        menu.add(newItem);
        // the new menu item will need to be assigned an index property
        // the value shoud be its position, its index, in the menu array
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }


    //display menu
    // method should display all of the items from the menu array
    public void displayMenu() {
        for(Item item: this.menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    // new order
    // method will take input from the user in the terminal to create a new order instance
    // and add it to the orders array
    public void newOrder() {
         //Shows the user a message prompt and sets their input to a variable name
        System.out.println("Please enter customer name for new order: ");
        String name = System.console().readLine();

        // create a new order with the given input string
         // show the user the menu so they can choose items to add
        Order newOrder = new Order(name);
        displayMenu();

        // prompts the user to enter an item number
        System.out.println("Please enter a menu index or q to quit: ");
        String itemNumber = System.console().readLine();

        //write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // get the item objectfrom the menu, and add the item to the order
            int item = Integer.parseInt(itemNumber);
            if(item < this.menu.size()) {
                Item orderItem = menu.get(item);
                newOrder.addItem(orderItem);
            } else {
                System.out.println("Sorry we do not have it");
            }
            // as them to enter a new item index or q again and take their input
            System.out.println("Please enter the index of the coffee you would like to order, or press q to exit");
            itemNumber = System.console().readLine();
        }
        // after you have coolected their order, print the order details
        newOrder.display();
        this.orders.add(newOrder);
    }

        public void addMenuItemByInput(){
            String isCompleted = "y";
            while(isCompleted.equals("y")) {
                System.out.println("Please enter the name of the product: ");
                String itemName = System.console().readLine();
                while(itemName.isEmpty()) {
                    System.out.println("Pleaase enter a valid price");
                    itemName = System.console().readLine();
                }
                System.out.println("Please enter the price of the product: ");
                String itemPrice = System.console().readLine();
                while(itemPrice.isEmpty()) {
                    System.out.println("Please enter a valid price");
                    itemPrice = System.console().readLine();
                }
                double price = Double.parseDouble(itemPrice);
            

            addMenuItem(itemName, price);
            System.out.println("Do you want to add another product? y/n");
            isCompleted = System.console().readLine().toLowerCase();
            }

    } 
}