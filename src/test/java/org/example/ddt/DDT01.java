package org.example.ddt;

import org.testng.annotations.Test;

public class DDT01 {

    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void testLogin(String username, String password){
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
    }



}
