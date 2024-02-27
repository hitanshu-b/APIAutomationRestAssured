package org.example.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG004 {

    String token;
    Integer bookingID;

    public String getToken(){
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenAndBookingID(){
        token = getToken();
        bookingID = 123;
    }

    @Test
    public void testPUTReq(){
        System.out.println(token);
        System.out.println(bookingID);
    }

}
