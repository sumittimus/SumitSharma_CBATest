package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RequestHelper {

    // Utility method for GET request
    public static Response sendGetRequest(String endpoint) {
        return given().get(endpoint);
    }

    // Utility method for POST request
    public static Response sendPostRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint);
    }
}
