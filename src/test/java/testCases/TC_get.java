package testCases;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class TC_get {


    @Test

    public void GetTestCase(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("---Whole Rsposne ---" + response.asString());

        System.out.println("---Whole Body ---" + response.getBody().asString());

        System.out.println("---Whole Response code ---" + response.getStatusCode());

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode,200);

    }

    @Test
    public void Testcase1(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("url",hasItems("https://reqres.in/#support-heading"));
    }

}
