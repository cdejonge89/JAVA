public class TestGreetings {
    public static void main(String[] args) {
        // to use the greetings methods
        // create a variable of type greetings
        Greetings greeterApp = new Greetings(); //1 
        // use the variable to access Greetings methods
        // using dot notation
        String dateMessage = greeterApp.getCurrentDate(); //2
        System.out.println(dateMessage); //3
    }
}
//1. we are instantiating a new Greetings object. Now, all public methods of the Greetings class are available to that object
//2. calling the getCurrentDate() method on the object
//3. pringting the currentDate string

//As long as both Greetings and TestGreetings files are in the same directory, you do not have to explicitly import one into another. Also, you can just run the javac compiler on TestGreetings, and it will compile both files for us.