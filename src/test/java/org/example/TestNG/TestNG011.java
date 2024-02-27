package org.example.TestNG;

import org.testng.annotations.Test;

public class TestNG011 {

    @Test
    public void serverStarted(){
        System.out.println("Server Started");
    }

    @Test(dependsOnMethods = {"serverStarted"})
    public void requiredMethod(){
        System.out.println("Method Attached");
    }

}
