package stepdefs;

import io.cucumber.java8.En;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class NonExistingBookStepDefinitions implements En {

    public NonExistingBookStepDefinitions(TestContext testContext) {

        Given("a book with an isbn of {long} does not exist", (Long isbn) -> {
            RequestSpecification request = given().param("q", "isbn:" + isbn);
            testContext.setRequestSpecification(request);
        });

    }
}