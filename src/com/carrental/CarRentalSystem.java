package com.carrental;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private final List<Car> cars;
    private final List<Customer> customers;
    private final List<Rental> rentals;

    CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals= new ArrayList<>();
    }

    public void showRentalCarsData(){
        for(Rental rental : rentals){
            System.out.println(rental.getCar().getCarBrand()+" "+rental.getCustomer()+" "+rental.getRentDays());
        }
    }

    public void listingCars(){
        for(Car car : cars)
        {
            System.out.println(car.getCarNumber()+" " +car.getCarBrand()+" "+ car.getCarModel()+" "+car.getCarBasePricePerDay());
        }
    }

    public void addCar(String carNumber, String carBrand, String carModel, int carBasePricePerDay){

        boolean carAlreadyExist=false;
        if(cars.isEmpty()) {
            cars.add(new Car(carNumber,carBrand,carModel,carBasePricePerDay));
            System.out.println("✅ Car added successfully: " + carBrand + " " + carModel + " [" + carNumber + "]");
        }

        else{
            for(Car car : cars){
                if(car.getCarNumber().equals(carNumber)){
                    carAlreadyExist=true;
                    break;
                }
            }

            if(carAlreadyExist){
                System.out.println("❌ Car with number " + carNumber + " already exists. Please check again!");
            }
            else {
                cars.add(new Car(carNumber,carBrand,carModel,carBasePricePerDay));
                System.out.println("✅ Car added successfully: " + carBrand + " " + carModel + " [" + carNumber + "]");
            }
        }



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

            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice : ");

            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1)
            {
                System.out.println("🚗 Renting a car...");
                System.out.println("-------------------");

                System.out.println("Enter your name: ");
                String customerName = sc.nextLine();

                System.out.println("Enter your age: ");
                int customerAge = sc.nextInt();
                sc.nextLine();

                System.out.println("📋 Listing available cars...");
                int counting=1;
                for (Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(counting+"."+car.getCarNumber() + ". "+car.getCarBrand()+" "+car.getCarModel());
                        counting++;
                    }
                }

                System.out.println("Enter the car number to rent the car : ");
                String carNumberRent = sc.nextLine();

                System.out.println("Enter the number of days you want rent the car: ");
                int carRentDays= sc.nextInt();
                sc.nextLine();

                Customer newCustomer= new Customer("CUS"+(customers.size()+1), customerName,customerAge);
                addCustomer(newCustomer);

                Car selectedCar=null;
                for(Car car : cars)
                {
                    if(car.isAvailable()&&car.getCarNumber().equals(carNumberRent)){
                        selectedCar=car;
                        break;
                     }
                }

                if(selectedCar!=null)
                {
                    double totalPrice = selectedCar.getCarBasePricePerDay()*carRentDays;
                    System.out.println(totalPrice);
//                  System.out.println("==========================================");
                    System.out.println("           Car Rental Information ");
                    System.out.println("------------------------------------------");
                    System.out.println("Rental Id        :");
                    System.out.println("Customer ID      :"+newCustomer.getCustomerId());
                    System.out.println("Customer Name    :"+newCustomer.getCustomerName());
                    System.out.println("Customer Age     :"+newCustomer.getCustomerAge());
                    System.out.println("Car Brand        :"+selectedCar.getCarBrand());
                    System.out.println("Car Model        :"+selectedCar.getCarModel());
                    System.out.println("Car Rent Days    :"+carRentDays);
                    System.out.printf("Total Price       : $%.2f%n",totalPrice);

                    System.out.println("Confirm renting this car (Y/N): ");
                    String confirm =sc.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,carRentDays);
                        System.out.println("✅ Car rented successfully " + selectedCar.getCarBrand() + " " + selectedCar.getCarModel() + " [" + selectedCar.getCarNumber() +"] " +selectedCar.getCarBasePricePerDay());
                    }
                    else {
                        System.out.println("Rental Canceled");
                    }
                }
                else {
                    System.out.println("Invalid car selection or car not available for rent.");
                }
            }
            else if (choice==2) {
                System.out.println("🔄 Returning a car...");
                System.out.println("---------------------");
                System.out.println("Enter car the Id you want to return");
                String carId = sc.nextLine();
                System.out.println(carId);

                Car carToReturn= null;
                for(Car car: cars)
                {
                    if(car.getCarNumber().equals(carId)&&car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }

                if(carToReturn!= null){
                    Customer customer=null;
                    for (Rental rental : rentals) {
                        if (rental.getCar()==carToReturn)
                        {
                            customer=rental.getCustomer();
                            break;
                        }
                    }

                    if(customer!=null){
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getCustomerName());
                    }
                    else {
                        System.out.println("Car was not returned or rental information is missing");
                    }
                }
            }

            else if (choice == 3){
                break;
            }
            else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }

            System.out.println("=======================================================");
            System.out.println("🚗 Thank you for using the Car Rental System!");
            System.out.println("📅  We hope to serve you again soon.");
            System.out.println("👋  Goodbye! Thank you for using Car Rental System.");
            System.out.println("=======================================================");

        }
    }



}



