package org.example.tests.crud.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPATCH {

    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String token = "cf8c270c3adf12d";

    @Test
    public void testNonBDDPATCH(){
        // url
        // payload
        // token
        // headers
        // id - 2786
        // headers - json

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        String payloadPATCH = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/1539");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payloadPATCH).log().all();

        Response response = r.when().patch();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));
    }
}
