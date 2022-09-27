import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        // create an instance of the CafeUtil class
        CafeUtil appTest = new CafeUtil();

        // ====== Appt Test Casses =====

        // add together every consecutive integer from 1-10 and return the sum (55)
        System.out.println("\n------ Streak Goal Test ------");
        System.out.printf(
            "Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());

        // given an array of item prices from an order
        // sum all of the prices in the array and return the total
        System.out.println("------ Order Total Test ------");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf(
            "Order total: %s \n\n", appTest.getOrderTotal(lineItems));

        // given an ArrayList of menu items(strings),
        // print outeach index and menu item    
        System.out.println("------ Display Menu Test ------");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("------ Add Customer Test ------");
        ArrayList<String> customers = new ArrayList<String>();
        // Test 4 times
        // for(int i = 0; i < 4; i++) {
        //     appTest.addCustomer(customers);
        //     System.out.println("\n");
        // }
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s ", userName);
    }

}