package com.example.andrew.project1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Local unit test, which will execute on the development machine (host).
 */
public class UnitTest {

    @Test
    public void testUpdateRating() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        provider01.updateRating(5);
        String expected = "5.0";
        String actual = Double.toString(provider01.getRating());
        assertEquals("Test for updateRating(int) in Class ServiceProviderUser failed", expected, actual);
    }

    @Test
    public void testUpdateRating2() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        provider01.updateRating(5);
        provider01.updateRating(5);
        provider01.updateRating(5);
        provider01.updateRating(5);
        String expected = "5.0";
        String actual = Double.toString(provider01.getRating());
        assertEquals("Test for updateRating(int) in Class ServiceProviderUser failed", expected, actual);
    }

    @Test
    public void testUpdateRating3() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        provider01.updateRating(5);
        provider01.updateRating(5);
        provider01.updateRating(1);
        provider01.updateRating(5);
        String expected = "4.0";
        String actual = Double.toString(provider01.getRating());
        assertEquals("Test for updateRating(int) in Class ServiceProviderUser failed", expected, actual);
    }
}

