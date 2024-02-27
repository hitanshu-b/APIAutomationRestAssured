package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG009 {
    // two types of assertions are provied by TestNG
    // Soft Assertions
    // Hard Assertions

    // Soft Assertions
    @Test
    public void testCase1(){
        SoftAssert s = new SoftAssert();
        s.assertEquals(true, false, "True should not be equal to false");
        System.out.println("Do Execute me");
        s.assertAll();
    }

    @Test
    public void testCase2(){
        Assert.assertEquals(true, false, "Failed");
        System.out.println("This will not print");
    }
}
