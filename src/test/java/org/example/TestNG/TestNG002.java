package org.example.TestNG;

import org.testng.annotations.*;

public class TestNG002 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Test Before Method");
    }

    @Test
    public void demo1(){
        System.out.println("Test demo 1 ");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("Test After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
