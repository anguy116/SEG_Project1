package com.example.andrew.project1;

public class ServiceProviderUser extends User {
    private String email;
    private String password;
    private String companyName;
    private String phoneNumber;

    public ServiceProviderUser (String email, String password, String companyName, String phoneNumber){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
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