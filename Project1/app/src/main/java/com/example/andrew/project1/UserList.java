package com.example.andrew.project1;

import com.example.andrew.project1.HomeOwnerUser;
import com.example.andrew.project1.ServiceProviderUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class UserList {
    public static ArrayList<HomeOwnerUser> users=new ArrayList<HomeOwnerUser>();
    public static ArrayList<ServiceProviderUser> providers=new ArrayList<ServiceProviderUser>();

    public void addHomeOwner(HomeOwnerUser newUser){
        users.add(newUser);
    }

    public void addProvider(ServiceProviderUser newProvider){
        providers.add(newProvider);
    }
}
