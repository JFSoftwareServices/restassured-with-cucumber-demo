package stepdefs;


import io.cucumber.java8.En;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class SharedStepDefinitions implements En {

    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

    public SharedStepDefinitions(TestContext testContext) {
        When("a user retrieves the book by isbn", () -> {
            Response response = testContext.getRequestSpecification().when().get(ENDPOINT_GET_BOOK_BY_ISBN);
            System.out.println("response: " + response.prettyPrint());
            testContext.setResponse(response);
        });

        Then("the status code is {int}", (Integer statusCode) -> {
            ValidatableResponse validatableResponse = testContext.getResponse().then().statusCode(statusCode);
            testContext.setValidatableResponse(validatableResponse);


//            testContext.getRequestSpecification().


//            final String schema = generateSchemaPath(baseCurrency, currencies);
//            testContext.getResponse().then().assertThat()
//                    .body(matchesJsonSchemaInClasspath(schema));

        });
    }
}