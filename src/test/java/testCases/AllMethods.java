package testCases;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AllMethods {


    @Test
    public void TC_Get(){
            given().
                    header("Content-Type", "application/json").
                    get("https://cdn-api.co-vin.in/api/v2/admin/location/states")
                    .then()
                    .statusCode(200)
                    .body("states.state_id[0]", equalTo(1))
                    .body("states.state_name[0]", equalTo("Andaman and Nicobar Islands"))
                    .body("states.state_name",hasItems("Uttarakhand","Punjab","Haryana"));

    }

}
