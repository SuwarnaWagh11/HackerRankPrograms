package apitest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class PracticeAPITest {
    //@Test
    public void test11() {
        ValidatableResponse resp;
        RequestSpecBuilder reqSpec = new RequestSpecBuilder();

        reqSpec.setAccept("").setContentType("").addQueryParam("", "").setBody("");//.setAuth(sometoken)
        ResponseSpecBuilder respDpec = new ResponseSpecBuilder();
        resp = RestAssured
                .given().
                    spec(reqSpec.build())
                .expect().
                    spec(respDpec.build())
                .when().
                    request(Method.GET, "\\dashboard\\id")
                .then();

        resp.statusCode(201);
        resp.log().all();
        resp.body("", is(3));
        resp.body("",hasItem("444")).body("",hasSize(4)).body("",endsWith(""));

    }
}
