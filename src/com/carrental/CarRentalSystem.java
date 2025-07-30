package com.carrental;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals= new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int rentDays){

        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,rentDays));
        }
        else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Car car){
        Rental rentalCarToRemove=null;
        for(Rental rental:rentals){
            if(rental.getCar()==car){
                rentalCarToRemove=rental;
                break;
            }
        }

        if (rentalCarToRemove!=null){
            rentals.remove(rentalCarToRemove);
            car.returnCar();
            System.out.println("Car returned successfully");
        }
        else {
            System.out.println("Car was not found.");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("===================================");
            System.out.println("   Welcome to Car Rental System 🚗");
            System.out.println("===================================");


        }
    }



}



