package org.example.TestNG;

import org.testng.annotations.Test;

public class TestNG012 {

    @Test(groups = {"init"}, priority = 1)
    public void getToken(){
        System.out.println("Server Started");
    }

    @Test(groups = {"init"}, priority = 2, enabled = false)
    public void getBookingId(){
        System.out.println("init Environment");
    }

    @Test(dependsOnMethods = {"init.*"})
    public void testPUTReq(){
        System.out.println("Method Instantiated");
    }
}
