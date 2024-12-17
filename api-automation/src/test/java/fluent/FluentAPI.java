package fluent;

import io.restassured.response.Response;
import base.BaseTest;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class FluentAPI {

    private static final Logger logger = LoggerUtil.getLogger(FluentAPI.class);

    public Response post(String endpoint, Object body) {
        return given()
                .baseUri(BaseTest.getBaseUri())
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint);
    }

    public Response get(String endpoint) {
        return given()
                .baseUri(BaseTest.getBaseUri())
                .get(endpoint);
    }

    public Response put(String endpoint, Object body) {
        return given()
                .baseUri(BaseTest.getBaseUri())
                .header("Content-Type", "application/json")
                .body(body)
                .put(endpoint);
    }

    public Response delete(String endpoint) {
        return given()
                .baseUri(BaseTest.getBaseUri())
                .delete(endpoint);
    }
}
