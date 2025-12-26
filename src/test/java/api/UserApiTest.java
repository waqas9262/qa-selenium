package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserApiTest {

    @BeforeClass
    public void setup() {
        // public test API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // 1) GET – read a resource
    @Test
    public void getPostTest() {
        given()
                .log().all()
                .when()
                .get("/posts/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", greaterThan(0))
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }

    // 2) POST – create a resource
    @Test
    public void createPostTest() {
        String requestBody = "{\n" +
                "  \"title\": \"waqas post\",\n" +
                "  \"body\": \"hello from rest-assured\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)              // fake API returns 201 Created
                .body("title", equalTo("waqas post"))
                .body("userId", equalTo(1));
    }

    // 3) PUT – update a resource
    @Test
    public void updatePostTest() {
        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"updated title\",\n" +
                "  \"body\": \"updated body\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("updated title"));
    }

    // 4) DELETE – delete a resource
    @Test
    public void deletePostTest() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);   // jsonplaceholder returns 200 for DELETE
    }
}