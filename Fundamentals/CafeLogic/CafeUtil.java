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
        for(String menu: menuItems) {
            System.out.println(menu);
        }
    }

    // add customer
//     public addCustomer(ArrayList<String> customers) {

}