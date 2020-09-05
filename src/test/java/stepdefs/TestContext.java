package stepdefs;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

@Data
public class TestContext {
    private Response response;
    private ValidatableResponse validatableResponse;
    private RequestSpecification requestSpecification;
}