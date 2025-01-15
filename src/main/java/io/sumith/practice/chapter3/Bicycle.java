package io.sumith.practice.chapter3;

class Bicycle implements BicycleImpl {
    private int speed = 0;
    private int gear = 0;

    public void speedUp(int increaseTheSpeed) {
        this.speed = speed +  increaseTheSpeed;
    }

    public void speedDown(int decreaseTheSpeed) {
        this.speed = speed + decreaseTheSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    void changeGear(int newValue) {
        gear = newValue;
    }

    public int getGear() {
        return gear;
    }

    public void printStates() {
        System.out.println("Speed : " + speed + "\n" + "Gear : " + gear );
    }

    @Override
    public void doSomething() {
        System.out.println("Bla bla blaa......");
    }

    @Override
    public int applyBreaksToStop() {
        this.speed = 0;
        this.gear = 0;
        return 0;
    }
}
