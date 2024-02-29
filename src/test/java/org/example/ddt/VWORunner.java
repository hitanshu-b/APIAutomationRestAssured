package org.example.ddt;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VWORunner {

    // POST Request
    @Test(dataProvider = "getLoginData", dataProviderClass = VwoExcel.class)
    public void testLoginVWO(String username, String password){
        RequestSpecification r = RestAssured.given();
        String payload = "{\n" +
                "    \"username\": \""+username+"\",\n" +
                "    \"password\": \""+password+"\",\n" +
                "    \"remember\": false,\n" +
                "    \"recaptcha_response_field\": \"\"\n" +
                "}";

        r.baseUri("https://app.vwo.com/");
        r.basePath("/login");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response = r.when().post();
        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        validatableResponse.statusCode(200);

        String name = response.then().log().all().extract().path("name");
        String email = response.then().log().all().extract().path("email");

        assertThat(name).isEqualTo("Demo Account").isNotEmpty();
        assertThat(email).isEqualTo("hitanshu.developement@gmail.com").isNotEmpty();
    }



//    @Test(dataProvider = "getLoginData")
//    public void testData(String username, String password){
//        System.out.println(username);
//    }

}
