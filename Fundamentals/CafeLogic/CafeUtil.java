import java.util.ArrayList;
import java.util.Arrays;
class CafeUtil {
    // methods
    // streak goal
    public int getStreakGoal() {
        int sum = 0;
        for(int i = 1; i <= 10; i ++) {
            sum += i;
        }
        return sum;
    }

    // order total
    public double getOrderTotal(double[] prices) {
        double total = 0;
        for(int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }

    //display menu
    public void displayMenu(ArrayList<String> menuItems) {
        for( int i = 0; i < menuItems.size(); i ++){
            System.out.println(i + " : " + menuItems.get(i));
        }
    }

    // add customer
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customers.size() +" people in front of you");
        customers.add(userName);
        System.out.println(customers);
    }

}