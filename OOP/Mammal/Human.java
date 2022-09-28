class Human extends Mammal {

    // method
    public void goToWork(){
        System.out.println("I'm going to work, something only humans do");
    }

    // change the method of superclass (parent) by 
    // writing a method that has the same method signature 
    // and return type as the parent method
    public void startSleeping() {
        System.out.println("toss and turn ...zzz");
        // use super keyword to invoke the superclass method from the parent
        super.startSleeping();
    }
}