package testCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.sl.usermodel.ObjectMetaData;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.JarURLConnection;
import java.net.http.HttpRequest;

import static io.restassured.RestAssured.*;

public class MytestAll_Method {

    @Test
    public void get_M(){

        Response response = RestAssured.get("https://cdn-api.co-vin.in/api/v2/admin/location/states");

        System.out.println(response.getBody().asString());

        System.out.println(response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void simpleRestAssuredWay(){

        given().
                contentType(ContentType.JSON).
        when().get("https://cdn-api.co-vin.in/api/v2/admin/location/states").
        then().
                log().all().
                statusCode(200);
    }



    @Test
    public void post_M(){

//        baseURI = "https://reqres.in/api";

        JSONObject request2 = new JSONObject();
        request2.put("name", "mohit");
        request2.put("job", "leader");

        RequestSpecification httprequest = RestAssured.given();

        httprequest.header("Content-Type","application/json");
        httprequest.body(request2.toJSONString());
//        httprequest.log().all();
        Response response = httprequest.request(Method.POST,"https://reqres.in/api/users" );

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

    }


    @Test
    public void post_SimpleMethod(){

        JSONObject request = new JSONObject();
        request.put("mohit", "malik");
        request.put("Rahul","Deva");

        given().
                contentType(ContentType.JSON).
                body(request.toJSONString()).
        when().post("https://reqres.in/api/users").
        then().
                statusCode(201).
                log().all();

    }


    @Test
    public void test_postM(){

        JSONObject requestM = new JSONObject();

        requestM.put("name", "morpheus");
        requestM.put("job", "Manager");

        RequestSpecification httpSpecification = RestAssured.given();

        httpSpecification.header("Content-Type","application/json");
        httpSpecification.body(requestM.toJSONString());

        Response response = httpSpecification.request(Method.POST,"https://reqres.in/api/users");

        System.out.println(response.getBody().asString());
        int statusCOde = response.getStatusCode();
//        Assert.assertEquals(statusCOde,201);


    }




}
