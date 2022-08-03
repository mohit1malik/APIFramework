package Interviews;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ArogyeSetuInerview {

    @Test
    public void getMaxDistrictName(){
        Response response = given().get("https://reqres.in/api/users?page=2");
        JsonPath jsonPath = response.jsonPath();
        String email = jsonPath.get("data.email[0]");
        Assert.assertEquals(email,"michael.lawson@reqres.in" );
        System.out.println(email);


        Map<String,Object> jsonResponseasMap = RestAssured.get("https://reqres.in/api/users?page=2").as(Map.class);


        System.out.println(jsonResponseasMap.get("data.id"));

    }
}
