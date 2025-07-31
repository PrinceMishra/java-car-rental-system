package com.carrental;
public class Main {
    public static void main(String[] args) {

        CarRentalSystem rentalSystem =new CarRentalSystem();

        rentalSystem.addCar("MH12AB1234", "Toyota","Fortuner", 5000);
        rentalSystem.addCar("UP32KL9001", "Mahindra","XUV700", 4000);
        rentalSystem.addCar("UP32KL9001", "Tata","Altroz", 2000);
        rentalSystem.addCar("UP32KL9001", "Tata","Nexon", 4000);

        System.out.println();

        System.out.println("Listing Cars");
        rentalSystem.listingCars();

        System.out.println();

        rentalSystem.menu();
    }


}