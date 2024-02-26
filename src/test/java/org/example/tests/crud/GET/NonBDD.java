package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDD {

    // GET Request
    // BDD Style and Non BDD Style

    //.given().then().when() --> Builder Pattern

    public static void main(String[] args) {
        // https://restful-booker.herokuapp.com/booking/1

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1776").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }
}
