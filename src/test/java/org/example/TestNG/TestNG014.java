package org.example.TestNG;

import org.testng.annotations.Test;

public class TestNG014 {

    @Test(priority = 1,groups = {"reg"})
    void demo1(){
        System.out.println("A");
    }

    @Test(priority = 2)
    void demo2(){
        System.out.println("B");
    }

    @Test(priority = 3)
    void demo3(){
        System.out.println("C");
    }
}
