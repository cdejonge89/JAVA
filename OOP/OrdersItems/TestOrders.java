import java.util.ArrayList;
// create the testing file and complete the rest of the tasks inside this file
class TestOrders {
    public static void main(String[] args) {
        System.out.println("----- Coffee Orders -----");

        // menu items
        // create 4 item variables of type item and instantiate each as an item object.
        Items item1 = new Items();
        item1.name = "Mocha";
        item1.price = 5.99;

        Items item2 = new Items();
        item2.name = "Latte";
        item2.price = 3.99;

        Items item3 = new Items();
        item3.name = "Drip Coffee";
        item3.price = 2.99;

        Items item4 = new Items();
        item4.name = "Capuccino";
        item4.price = 4.99;

        // order variables -- order1, order2, etc
        // create 4 order variables of type order and instantiate each as an order object
        Order order1 = new Order();
        System.out.println(order1.total);
        order1.name = "Keanu";

        Order order2 = new Order();
        order2.name = "Lee";

        Order order3 = new Order();
        order3.name = "Lucy";

        Order order4 = new Order();
        order4.name = "Joe";

        order1.items.add(item3);
        order1.total += item3.price;

        // add item1 to order2's item list and increment the order's total
        order2.items.add(item1);
        order2.total += item1.price;

        // order3 ordered a cappucino. add the cappuccino to their order list and their tab
        order3.items.add(item4);
        order3.total += item4.price;

        // order4 added a latte, update accordingly
        order4.items.add(item2);
        order4.total += item2.price;

        // Keanu's order is now ready, update their status
        order1.ready = true;

        // Joe ordered 2 more lattes, update their order
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        // Lee's order is now ready, update their status
        order2.ready = true;


        // application simulations
        //use this example code to text various orders' updates
        // item1.displayMenu();
        // item2.displayMenu();
        // item3.displayMenu();
        // item4.displayMenu();
        // System.out.printf("Beverge: %s\n Price: $%s", item1.name, item1.price);

        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.println("Order ready? " + order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.println("Order ready? " + order1.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        // System.out.printf("Name: %s\n", order1.ready);
    }
}