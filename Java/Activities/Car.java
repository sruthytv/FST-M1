package net.training_support;

public class Car {
    String color,transmission;
    int make,tyres, doors;
    Car(){
        tyres = 4;
        doors = 4;
    }
    void displayCharacteristics(){
        System.out.println("Color of the Car is : " +color);
        System.out.println("Transmission of the Car: "+transmission);
        System.out.println("Make of the Car: " +make);
        System.out.println("Number of tyres on the car: " +tyres);
        System.out.println("Number of doors on the car: " +doors);
    }
    void accelarate(){
        System.out.println("Car is moving forward.");

    }
    void brake(){
        System.out.println("Car has stopped.");
    }
}