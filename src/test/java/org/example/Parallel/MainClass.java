package org.example.Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {

    @BeforeMethod
    public void beforeMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("BeforeTest Method- Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodOne(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method One - Thread id is: " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodTwo(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method two - Thread id is: " + id + getClass().getSimpleName());
    }

    @AfterMethod
    public void afterMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("AfterTest Method- Thread id is: " + id + getClass().getSimpleName());
    }

}
