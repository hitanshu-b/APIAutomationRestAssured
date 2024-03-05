package org.example.Misc;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PayloadUsingMap {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPostReq(){
//        String payload = "{\n" +
//                "    \"firstname\" : \"Ramesh\",\n" +
//                "    \"lastname\" : \"Dhomta\",\n" +
//                "    \"totalprice\" : 101,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-05-05\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        // Payload management by using Hashmap

        Map<String, Object> jsonBodyMap = new HashMap<>();
        Faker faker = new Faker();

        String name = faker.name().fullName();

        jsonBodyMap.put("firstname",faker.name().firstName());
        jsonBodyMap.put("lastname",faker.name().lastName());
        jsonBodyMap.put("totalprice",101);
        jsonBodyMap.put("bookingdates",true);
        jsonBodyMap.put("depositpaid", true);

        Map<String, Object> bookingDateMap = new HashMap<>();
        bookingDateMap.put("checkin","2024-01-01");
        bookingDateMap.put("checkout","2024-05-05");

        jsonBodyMap.put("bookingdates",bookingDateMap);
        jsonBodyMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyMap).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println(bookingId);

    }
}
