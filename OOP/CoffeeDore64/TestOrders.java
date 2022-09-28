import java.util.ArrayList;
// create the testing file and complete the rest of the tasks inside this file
class TestOrders {
    public static void main(String[] args) {
        System.out.println("----- Coffee Orders -----");
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

        coffeeKiosk.addMenuItem("cappucino", 5.5);
        coffeeKiosk.addMenuItem("Mocha", 6.5);
        coffeeKiosk.addMenuItem("Latte", 4.5);
        coffeeKiosk.addMenuItem("Drip Coffee", 5.0);

        coffeeKiosk.addMenuItemByInput();
        coffeeKiosk.newOrder();

        } 
}