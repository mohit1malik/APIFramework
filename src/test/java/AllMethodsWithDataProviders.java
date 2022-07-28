import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class AllMethodsWithDataProviders extends DataForTests{



        @Test(dataProvider = "Data for Post")
        public void Test_Post(String firstname,String lastName){

        JSONObject request = new JSONObject();
        request.put("firstName", firstname);
        request.put("lastName",lastName);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json")
                .body(request.toJSONString()).
                when()
                .post("https://reqres.in/api/users").
                then().
                statusCode(201)
                .log().all();
    }


        @Test
        public void TC_Put(){

        JSONObject request  = new JSONObject();

        request.put("Ram","Chandra");
        request.put("Lakhan","Ji");

        given().
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();

    }

        @Test
        public void TC_Patch(){
        JSONObject request = new JSONObject();
        request.put("Ram","Chandra");
        request.put("Lakhan","Ji");

        given().
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

        @Test(dataProvider = "Data for Delete")
        public void TC_Delete(String id, int no){
        when().
                delete("https://reqres.in/api/users/"+no).
                then().
                statusCode(204).
                log().all();
    }

}
