package org.example.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG005 {

    @BeforeTest
    public void getToken(){
        System.out.println("token");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("id");
    }

    // it is not advisable to have two @BeforeTest methods in the code

    @Test
    public void testPutRequest(){
        System.out.println("PUT");
    }
}
