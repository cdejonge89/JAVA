class Casting {
    public static void main(String[] args) {
        // 7. type casting
        
        int days = 7;
        double cost = 10.01;

        // implicit casting
        // change the int to a double
        double doubleDay = days;
        System.out.println(doubleDay);

        // you can multiply or whatever the int and double
        double totalCost = cost * days; // works because double * ints still equals a double
        double totalCost2 = cost + days; 
        System.out.println(totalCost);
        System.out.println(totalCost2);

        // change double to int
        int roundUpCost = (int)cost;
        System.out.println(roundUpCost);
        int roundUpTotalCost = (int) cost * days;
        System.out.println(roundUpTotalCost);
    }
}