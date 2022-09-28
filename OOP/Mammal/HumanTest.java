class HumanTest {
    public static void main(String[] args) {
        //instanciate
        Human h = new Human();
        //attributes
        h.regulateTemperature();
        h.startSleeping();
        h.goToWork();
        boolean sleeping = h.isSleeping();

        if (sleeping) {
            System.out.println("The human is sleeping!");
        }

    }
}