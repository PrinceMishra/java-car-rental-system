package com.carrental;

public class Car {

    private int carId;
    private String carBrand;
    private String carModel;
    private double carBasePricePerDay;
    private boolean isAvailable=true;

    Car(int carId, String carBrand, String carModel, double carBasePricePerDay){

        this.carId=carId;
        this.carBrand=carBrand;
        this.carModel=carModel;
        this.carBasePricePerDay=carBasePricePerDay;
    }

    public int getCarId(){
        return carId;
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
