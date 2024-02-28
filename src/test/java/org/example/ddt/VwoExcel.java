package org.example.ddt;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VwoExcel {
    static Workbook book;
    static Sheet sheet;

    public static String FILE_NAME = "src/test/resources/TestData1.xlsx";

    public static Object[][] getInputData(String sheetName){
        FileInputStream file = null;
        try {
            file = new FileInputStream(FILE_NAME);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

    // POST Request
    @Test
    public void testLoginVWO(){
        RequestSpecification r = RestAssured.given();
        String payload = "{\n" +
                "    \"username\": \"hitanshu.developement@gmail.com\",\n" +
                "    \"password\": \"Qwerty@123\",\n" +
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


    @DataProvider
    public Object[][] getLoginData(){
        return getInputData("VWO Creds");
    }
}
