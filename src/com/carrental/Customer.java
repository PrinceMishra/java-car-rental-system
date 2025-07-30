package com.carrental;

public class Customer {

    private String customerId;
    private String customerName;
    private int customerAge;

    Customer(String customerId, String customerName, int customerAge){

        this.customerId=customerId;
        this.customerName=customerName;
        this.customerAge=customerAge;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerAge(){
        return customerAge;
    }
}
