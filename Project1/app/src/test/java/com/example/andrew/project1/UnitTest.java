package com.example.andrew.project1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Local unit test, which will execute on the development machine (host).
 */
public class UnitTest {

    @Test
    public void testRegisterUser() {
        ServiceProviderUser sp = new ServiceProviderUser("testCase@uottawa.ca", "123456", "Tester01", "001");
        String actual = sp.getEmail() + ", " + sp.getPassword() + ", " + sp.getName() + ", " + sp.getPhoneNumber();
        String expected = "testCase@uottawa.ca, 123456, Tester01, 001";
        assertEquals("Test for registerUser() in Class ServiceProviderUser failed", expected, actual);
    }

    @Test
    public void testServices() {
        Services serviceExample = new Services("Tester02", 120);
        String actual = serviceExample.getServiceName() + ", " + serviceExample.getRate();
        String expected = "Tester02, 120";
        assertEquals("Test for constructor in Class Services failed", expected, actual);
    }

    @Test
    public void testHomeOwnerUser() {
        HomeOwnerUser houExample = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "003 Test Street Testville ON", "003");
        String actual = houExample.getEmail() + ", " + houExample.getPassword() + ", " + houExample.getFirstName() + ", " + houExample.getLastName() + ", " + houExample.getAddress() + ", " + houExample.getPhoneNumber();
        String expected = "testCase@uottawa.ca, 123456, Tester, Tester, 003 Test Street Testville ON, 003";
        assertEquals("Test for constructor in Class HomeOwnerUser failed", expected, actual);
    }

    @Test
    public void testAddHomeOwner() {
        HomeOwnerUser houExample = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "003 Test Street Testville ON", "003");
        UserList testList = new UserList();
        testList.addHomeOwner(houExample);
        int actual = testList.users.size();
        int expected = 1;
        assertEquals("Test for addHomeOwner() in Class UserList failed", expected, actual);
    }

    @Test
    public void testAddProvider() {
        ServiceProviderUser sp = new ServiceProviderUser("testCase@uottawa.ca", "123456", "Tester01", "001");
        UserList testList = new UserList();
        testList.addProvider(sp);
        int actual = testList.providers.size();
        int expected = 1;
        assertEquals("Test for addProvider() in Class UserList failed", expected, actual);
    }
}

