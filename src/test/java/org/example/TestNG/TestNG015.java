package org.example.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG015 {
    // Demo of Data driven testing

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"admin123", "paswword"},
                new Object[]{"admin", "password123"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
                new Object[]{"admin", "admin"},
        };
    }

    @Test(dataProvider = "getData")
    public void loginTest(String userName, String passWord){
        System.out.println(userName);
        System.out.println(passWord);
    }

}
