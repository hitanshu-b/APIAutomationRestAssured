package org.example.ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TC001 {

    @Test(groups = "sanity")
    public void testCase1(){
        System.out.println("Test1");
        Assert.assertTrue(false);
    }

    @Test(groups = "sanity")
    public void testCase2(){
        System.out.println("Test2");
        Assert.assertTrue(true);
    }

    @AfterSuite
    public void sendMail(){

    }
}
