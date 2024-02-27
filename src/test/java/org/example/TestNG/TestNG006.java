package org.example.TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestNG006 {

    String token;
    Integer bookingID;

    RequestSpecification req;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void getToken(){
        req = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(payload);

        Response res = req.post();
        validatableResponse = res.then();
        validatableResponse.body("token", Matchers.notNullValue());

        token = res.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

        // AssertJ usage
        assertThat(token).isNotNull().isNotEmpty().isNotBlank();

        System.out.println(token);

    }

    @BeforeTest
    public void getBookingID(){
        req = RestAssured.given();
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
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(payload);

        Response response = req.when().post();
        ValidatableResponse validatableResponse =  response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingID = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingID);
    }

    @Test
    public void testPUTRequest(){
        String payload = "{\n" +
                "    \"firstname\" : \"Ramesh\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com/");
        req.basePath("booking/"+bookingID);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);

        req.body(payload).log().all();

        Response response = req.when().put();

        validatableResponse = response.then().log().all();


        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Ramesh"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));

    }

    @Test
    public void testPUTRequest2(){
        String payload = "{\n" +
                "    \"firstname\" : \"Ramesh\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com/");
        req.basePath("booking/"+bookingID);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);

        req.body(payload).log().all();

        Response response = req.when().put();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        String firstName = response.then().log().all().extract().path("firstname");

        assertThat(firstName).isNotNull().isNotBlank().isNotEmpty();


    }
}
