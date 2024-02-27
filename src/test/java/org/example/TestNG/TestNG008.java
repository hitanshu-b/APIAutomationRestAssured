package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG008 {

    @Test(groups = {"sanity","QA"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"reg","sanity","e2e","Preprod"})
    public void regRun(){
        System.out.println("Reg");
    }

    @Test(groups = {"smoke","sanity","dev"})
    public void smokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
