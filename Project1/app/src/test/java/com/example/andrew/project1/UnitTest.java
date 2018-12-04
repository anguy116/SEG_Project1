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

    @Test
    public void testUpdateRating4() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        provider01.updateRating(5);
        provider01.updateRating(5);
        provider01.updateRating(1);
        provider01.updateRating(5);
        provider01.updateRating(2);
        provider01.updateRating(2);
        provider01.updateRating(3);
        String expected = "3.3";
        String actual = Double.toString(provider01.getRating());
        assertEquals("Test for updateRating(int) in Class ServiceProviderUser failed", expected, actual);
    }

    @Test
    public void testUpdateRating5() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        provider01.updateRating(1);
        provider01.updateRating(2);
        provider01.updateRating(1);
        String expected = "1.3";
        String actual = Double.toString(provider01.getRating());
        assertEquals("Test for updateRating(int) in Class ServiceProviderUser failed", expected, actual);
    }

    @Test
    public void testAddBooking() {
        HomeOwnerUser user01 = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "testAddress001","123");
        user01.addBooking("booking1");
        String expected = "1";
        String actual = Integer.toString(user01.bookingSize());
        assertEquals("Test for addBooking(String) in Class HomeOwnerUser failed", expected, actual);
    }

    @Test
    public void testAddBooking2() {
        HomeOwnerUser user01 = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "testAddress001","123");
        user01.addBooking("booking1");
        user01.addBooking("booking2");
        user01.addBooking("booking3");
        user01.addBooking("booking4");
        user01.addBooking("booking5");
        String expected = "5";
        String actual = Integer.toString(user01.bookingSize());
        assertEquals("Test for addBooking(String) in Class HomeOwnerUser failed", expected, actual);
    }

    @Test
    public void testEmptyBookings() {
        HomeOwnerUser user01 = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "testAddress001","123");
        user01.addBooking("booking1");
        String expected = "false";
        String actual = Boolean.toString(user01.emptyBookings());
        assertEquals("Test for emptyBookings() in Class HomeOwnerUser failed", expected, actual);
    }

    @Test
    public void testBookingNumber() {
        HomeOwnerUser user01 = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "testAddress001","123");
        user01.addBooking("booking1");
        String expected = "booking1";
        String actual = user01.bookingNumber(0);
        assertEquals("Test for BookingNumber(int) in Class HomeOwnerUser failed", expected, actual);
    }

    @Test
    public void testBookingNumber2() {
        HomeOwnerUser user01 = new HomeOwnerUser("testCase@uottawa.ca", "123456", "Tester", "Tester", "testAddress001","123");
        user01.addBooking("booking1");
        user01.addBooking("booking2");
        String expected = "booking2";
        String actual = user01.bookingNumber(1);
        assertEquals("Test for BookingNumber(int) in Class HomeOwnerUser failed", expected, actual);
    }

}

