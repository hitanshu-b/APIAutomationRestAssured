package org.example.tests.crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDELETE {

    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String token = "d0c3635c7a65a97";

    @Test
    public void testNonBDDDELETE(){
        // url
        // payload
        // token
        // headers
        // id - 2786
        // headers - json



        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/3767");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);


        Response response = r.when().delete();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(201);
//        validatableResponse.body("firstname", Matchers.equalTo("Jim"));
//        validatableResponse.body("lastname", Matchers.equalTo("Brown"));
    }
}
