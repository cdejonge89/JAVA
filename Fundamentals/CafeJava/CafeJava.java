public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // lines of text that will appear in the app
        String generalGreeting = "Welcome to cafe java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "your total is $";

        // menu variables: create 3 more price variables
        double mochaPrice = 3.5;
        double dripCoffee = 2.0;
        double shortLatte = 4.0;
        double icedAmericano = 4.5;

        // customer name variables: create 3 more customers
        String customer1 = "Cindihuri";
        String customer2 = "Lee";
        String customer3 = "Keanu";
        String customer4 = "Lucy";
        

        // order completions: create order status flag for each customer
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;


        // APP INTERACTION SIMULATION
        // example
        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + displayTotalMessage + dripCoffee + pendingMessage);
        System.out.println(isReadyOrder4 ? customer4 + readyMessage : customer4 + pendingMessage);
        System.out.println(customer2 + ", your total is $" + shortLatte*2);
        System.out.println(isReadyOrder2 ? customer2 + readyMessage : customer2 + pendingMessage);
        System.out.println(customer3 + ", your total is $" + dripCoffee);
        System.out.println(customer3 + ", your new total is $" + (shortLatte - dripCoffee));
    }
}