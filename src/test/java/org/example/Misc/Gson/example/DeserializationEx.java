package org.example.Misc.Gson.example;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationEx {

    @Test
    public void test2(){
        String jsonString = "{\r\n" + "  \"firstName\" : \"Jimmy\",\r\n" + "  \"lastName\" : \"Anderson\",\r\n"
                + "  \"gender\" : \"M\",\r\n" + "  \"age\" : 40,\r\n" + "  \"salary\" : 3422.33,\r\n"
                + "  \"married\" : false\r\n" + "}";

        Gson gson = new Gson();
        Employee employeeObject = gson.fromJson(jsonString,Employee.class);

        String firstName = employeeObject.getFirstname();
        String lastName = employeeObject.getLastname();

        Assert.assertEquals(firstName,"Jimmy");
        Assert.assertEquals(lastName, "Dutta");


    }
}
