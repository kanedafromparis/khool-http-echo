package io.github.kandefromparis.khool;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EchoServletTest {

    @Test
    public void testEchoEndpoint() {
        given()
          .when().get("/echoServlet?toto=3232&titi=erere")
          .then()
             .statusCode(200)
             .body(containsString("toto : 3232"));
    }

    @Test
    public void testPostEndpoint() {
        given()
                .when().post("/echoServlet?toto=3232&titi=erere")
                .then()
                .statusCode(200)
                .body(containsString("toto : 3232"));
    }

    @Test
    public void testPutEndpoint() {
        given()
                .when().put("/echoServlet?toto=3232&titi=erere")
                .then()
                .statusCode(200)
                .body(containsString("Method:PUT"))
                .body(containsString("toto : 3232"));
    }
    @Test
    public void testHeadEndpoint() {
        given()
                .when().head("/echoServlet?toto=3232&titi=erere")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteEndpoint() {
        given()
                .when().delete("/echoServlet?toto=3232&titi=erere")
                .then()
                .statusCode(200)
                .body(containsString("Method:DELETE"))
                .body(containsString("toto : 3232"));
    }
}