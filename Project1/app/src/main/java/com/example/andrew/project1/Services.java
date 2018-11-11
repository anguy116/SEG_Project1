package com.example.andrew.project1;


public class Services {
    private String serviceName;
    private int rate;

    public Services(String name, int rate){
        this.serviceName = name;
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public String getServiceName() {
        return serviceName;
    }
}
