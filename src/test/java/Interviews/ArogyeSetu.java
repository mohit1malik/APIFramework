package Interviews;


import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import java.lang.reflect.Array;

import static io.restassured.RestAssured.*;

public class ArogyeSetu {

    String stateid,stateidnonTrimed = null;
    String var = null;
    @Test
    public void getStatesList(){

        Response response = given().
                when().get("https://cdn-api.co-vin.in/api/v2/admin/location/states");

        JsonPath extractor = response.jsonPath();

        stateidnonTrimed = extractor.getString("states.state_id");
        stateid = stateidnonTrimed.trim();
//        System.out.println(stateid);
//        System.out.println(stateid.length());

        for(int i =0; i <= stateid.length(); i++){
//            System.out.println(i);

            Response response1 = given().when().get("https://cdn-api.co-vin.in/api/v2/admin/location/districts/"+i);

            JsonPath extractor1 = response1.jsonPath();
            System.out.println(response1.body().asString());

            String district_name = extractor.getString("districts.district_id");
            System.out.println(district_name);


        }
    }


}
