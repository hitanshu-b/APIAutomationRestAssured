package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG010 {
    @Test
    void testCase01(){
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");
    }
    @Test
    void testCase02(){
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");
    }
}
