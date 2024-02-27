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

import static org.assertj.core.api.Assertions.*;

public class TestNG003 {

    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String token;

    @BeforeTest
    public void getToken(){
        r = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response res = r.post();
        validatableResponse = res.then();
        validatableResponse.body("token", Matchers.notNullValue());

        token = res.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

        // AssertJ usage
        assertThat(token).isNotNull().isNotEmpty().isNotBlank();

        System.out.println(token);
    }

    @Test
    public void testPutRequest(){
        String jsonPayload = "{\n" +
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

        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1254");
        r.body(jsonPayload);

        Response response = r.put();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("lastname",Matchers.equalTo("Brown"));
    }

}
