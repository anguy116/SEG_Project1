package com.example.andrew.project1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Local unit test, which will execute on the development machine (host).
 */
public class UnitTest {

    @Test
    public void testAddServices() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        Services weFixStuff = new Services("WeFixStuff", 100);
        Services weBreakStuff = new Services("WeBreakStuff", 0);
        provider01.addServices("WeFixStuff");
        provider01.addServices("WeBreakStuff");
        String expected = "WeFixStuff,WeBreakStuff";
        String actual = provider01.getServices();
        assertEquals("Test for addServices() in Class ServiceProviderUser failed", expected, actual);
    }

    @Test
    public void testRemoveServices() {
        ServiceProviderUser provider01 = new ServiceProviderUser("testCase@uottawa.ca", "123456", "testCompany01", "testAddress001", "123456789",true);
        Services weFixStuff = new Services("WeFixStuff", 100);
        Services weBreakStuff = new Services("WeBreakStuff", 0);
        Services weTestStuff = new Services("WeTestStuff", 50);
        provider01.addServices("WeFixStuff");
        provider01.addServices("WeBreakStuff");
        provider01.addServices("WeTestStuff");
        provider01.removeServices("WeFixStuff");
        provider01.removeServices("WeTestStuff");
        String expected = "WeBreakStuff";
        String actual = provider01.getServices();
        assertEquals("Test for removeServices() in Class ServiceProviderUser failed", expected, actual);
    }
}

