package com.example.andrew.project1;

import java.util.ArrayList;

public class HomeOwnerUser extends User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private ArrayList<String> bookings;
    public HomeOwnerUser (String email, String password, String firstName,String lastName,String address,String phoneNumber){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        bookings = new ArrayList<>();
    }

    public int bookingSize() {
        return bookings.size();
    }

    public void addBooking(String booking) {
        bookings.add(booking);
    }

    public boolean emptyBookings(){
        return bookings.isEmpty();
    }

    public String bookingNumber(int number){
        return bookings.get(number);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
