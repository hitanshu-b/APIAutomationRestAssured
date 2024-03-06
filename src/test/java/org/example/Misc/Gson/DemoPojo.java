package org.example.Misc.Gson;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DemoPojo {
//    {
//        "firstname" : "Ramesh",
//            "lastname" : "Dhomta",
//            "totalprice" : 101,
//            "depositpaid" : true,
//            "bookingdates" : {
//        "checkin" : "2024-01-01",
//                "checkout" : "2024-05-05"
//    },
//        "additionalneeds" : "Breakfast"
//    }

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOST(){

        Booking b = new Booking();
        b.setFirstname("Andrew");
        b.setLastname("Flintoff");
        b.setTotalprice(113);
        b.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-02");
        bookingDates.setCheckout("2024-02-23");
        b.setBookingDates(bookingDates);
        b.setAdditionalneeds("Lunch");

        System.out.println(b);

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
//        requestSpecification.basePath("/booking");
//        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.body(payload).log().all();
//
//        Response response = requestSpecification.when().post();
//
//        Integer bookingId = response.then().extract().path("bookingid");
//
//        validatableResponse = response.then().log().all();
//        validatableResponse.statusCode(200);
//        System.out.println(bookingId);
    }
}
