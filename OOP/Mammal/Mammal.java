class Mammal {
    // attributes
    private boolean sleeping = true;

    // methods
    public void regulateTemperature() {
        System.out.println("My temp is feeling good");
    }
    public void startSleeping() {
        System.out.println("..zzz");
    }
    public boolean isSleeping(){
        return sleeping;
    }
}