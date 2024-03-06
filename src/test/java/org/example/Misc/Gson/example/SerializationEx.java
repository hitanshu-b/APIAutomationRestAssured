package org.example.Misc.Gson.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

public class SerializationEx {

    @Test
    public void test1(){
        Employee emp = new Employee();
        emp.setFirstname("Jimmy");
        emp.setLastname("Anderson");
        emp.setGender("M");
        emp.setAge(40);
        emp.setSalary(50000.00);
        emp.setMarried(false);

        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(emp);
        System.out.println(jsonEmployee);

        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String empJSONUsingJSONBuilder = gsonBuilder.toJson(emp);
        System.out.println(empJSONUsingJSONBuilder);

    }
}
