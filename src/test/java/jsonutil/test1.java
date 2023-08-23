package jsonutil;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.Matchers.*;

public class test1 {
    @Test
    public void foo() throws FileNotFoundException {
        Reader reader = new FileReader("C:\\interview\\test1.json");
        JsonElement jsoneEle = JsonParser.parseReader(reader);
        JsonObject param = jsoneEle.getAsJsonObject();

        RequestSpecBuilder rspec = new RequestSpecBuilder();
        rspec.setContentType("").setBody("").setBaseUri("");

        ResponseSpecBuilder respSpec = new ResponseSpecBuilder();
        RestAssured.given().spec(rspec.build()).expect().spec(respSpec.build())
                .when().request(Method.GET, "")
                .then()
                .statusCode(200)
                .body("", is(3))
                .body("",hasItem(3))
                .body("", hasSize(20))
                .body("",greaterThan(30));

    }
}
