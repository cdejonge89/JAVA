import java.util.ArrayList;
// create the testing file and complete the rest of the tasks inside this file
class TestOrders {
    public static void main(String[] args) {
        System.out.println("----- Coffee Orders -----");
    

        Item item1 = new Item("Mocha", 4.99);
        Item item2 = new Item("Americano", 4.50);
        Item item3 = new Item("Drip Coffee", 2.0);
        Item item4 = new Item("Pumpkin Spice Latte", 7);


        // create 2 orders for unspecified guests
        Order order1 = new Order();
        Order order2 = new Order();

        // create 3 orders using the overloaded constructor
        // to give each a name for the order
        Order order3 = new Order("Keanu");
        Order order4 = new Order("Lee");
        Order order5 = new Order("Lucy");

        // add at least 2 items to each of the orders 
        // using the addItem method 
        // ex - add item1 to order3, you would need to call the addItem
        // method from the order3 instance: order3.addItem(item);
        order4.addItem(item1);
        order4.addItem(item1);
        System.out.println(order4.getOrderTotal());

        order3.addItem(item2);
        System.out.println(order3.getOrderTotal());

        order2.addItem(item3);
        order2.addItem(item4);
        System.out.println(order2.getOrderTotal());
        // implement the getStatusMessage functionaly 
        // by setting some orders to ready 
        // and printing the message for each order
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());
        order4.setReady(false);
        System.out.println(order4.getStatusMessage());

        // call the display method on all of your orders
        order1.display();
        order2.display();
        order3.display();
        order4.display();

        // call the display all method from item class
        item1.displayMenu();



        } 
}