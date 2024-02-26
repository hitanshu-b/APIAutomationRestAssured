package org.example.tests.crud.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {
        //GET Request - https://api.zippopotam.us/IN/440015
        //URL
        //Header
        //GET Method
        // base url - https://api.zippopotam.us
        // base path - /IN/440015
        // Payload - No
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 > No

        // STatus code
        // Response Body
        // Time, Headers, cookies

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/440015")

                .when().get()

                .then().statusCode(200);
    }
}
