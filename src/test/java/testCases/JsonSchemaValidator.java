package testCases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JsonSchemaValidator {

    @Test
    public void Testcase1(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200)
                .and().body("//*:addrestult.text",equalTo(5));
    }
}
