package com.carrental;

public class Car {

    private String carNumber;
    private String carBrand;
    private String carModel;
    private double carBasePricePerDay;
    private boolean isAvailable=true;

    Car(String carNumber, String carBrand, String carModel, int carBasePricePerDay){
        this.carNumber=carNumber;
        this.carBrand=carBrand;
        this.carModel=carModel;
        this.carBasePricePerDay=carBasePricePerDay;
    }

    public String getCarNumber(){
        return carNumber;
    }

    public String getCarBrand(){
        return carBrand;
    }

    public String getCarModel(){
        return carModel;
    }

    public double getCarBasePricePerDay() {
        return carBasePricePerDay;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void rent(){
        isAvailable=false;
    }
    public void returnCar(){
        isAvailable=true;
    }
}
