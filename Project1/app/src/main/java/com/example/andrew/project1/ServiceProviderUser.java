package com.example.andrew.project1;

import java.util.ArrayList;

public class ServiceProviderUser extends User {
    private String email;
    private String password;
    private String companyName;
    private String phoneNumber;
    private String address;
    private String description;
    private boolean licensed;
    private ArrayList<String> services;
    private boolean[] available;
    private double rating;
    private double totalRating;
    private int noRated;

    public ServiceProviderUser (String email, String password, String companyName, String address, String phoneNumber, boolean licensed){
        this.email = email;
        this.password = password;
        this.companyName=companyName;
        this.phoneNumber=phoneNumber;
        this.address = address;
        description = "";
        this.licensed = licensed;
        services = new ArrayList<String>();
        available = new boolean[7];
        rating = 0.0;
        noRated = 0;

        for (int a =0; a<7; a++){
            available[a] = false;
        }

    }

    public ServiceProviderUser (String email, String password, String companyName, String description, String address, String phoneNumber, boolean licensed){
        this.email = email;
        this.password = password;
        this.description = description;
        this.companyName=companyName;
        this.phoneNumber=phoneNumber;
        this.address = address;
        this.licensed = licensed;
        services = new ArrayList<String>();
        available = new boolean[7];
        rating = 0.0;
        noRated = 0;

        for (int a =0; a<7; a++){
            available[a] = false;
        }
    }

    public String getServices() {
        String big = "";
        if (!services.isEmpty()){
            for (int a = 0; a<services.size(); a++){
                // If it is the last element in the list, do not add the end comma
                if (a == services.size() -1) {
                    big = big + services.get(a);
                }
                else {
                    big = big + services.get(a) + ",";
                }
            }
            return big;
        }
        return "no services";
    }

    public ArrayList<String> getServicesProvided(){
        return services;
    }

    public double getRating() {
        return rating;
    }

    public void updateRating(int rate){
        // Increases the number of ratings by 1
        noRated = noRated + 1;
        // Updates the total rating
        totalRating += rate;
        // Calculates the actual rating
        rating = totalRating/noRated;
        // Rounds the calculated result to 1 decimal place
        rating = Math.round(rating * 10.0) / 10.0;
    }

    public void setAvailable(boolean today, int day) {
        available[day] = today;
    }

    public boolean getAvailable(int index) {
        return available[index];
    }

    public void addServices(String service){
        services.add(service);
    }

    public boolean hasService(String service){
        if (services.contains(service)){
            return true;
        } else {
            return false;
        }
    }

    public void removeServices(String service){
        if (services.contains(service)){
            services.remove(service);
        } else{
            return;
        }
    }

    public int numberOfService(){
        return services.size();
    }

    public String serviceAt(int a){
        return services.get(a);
    }

    public String getDescription() {
        return description;
    }

    public boolean isLicensed(){
        return licensed;
    }


    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}