package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class ExistingBookStepDefinitions implements En {

    public ExistingBookStepDefinitions(TestContext testContext) {

        Given("a book exists with an isbn of {long}", (Long isbn) -> {
            RequestSpecification request = given().param("q", "isbn:" + isbn);
            testContext.setRequestSpecification(request);
        });

        Then("response includes the following", (DataTable dataTable) -> {
            Map<String, String> responseFields = dataTable.asMap(String.class, String.class);
            for (Map.Entry<String, String> field : responseFields.entrySet()) {
                if (StringUtils.isNumeric(field.getValue())) {
                    testContext.getValidatableResponse().body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
                } else {
                    testContext.getValidatableResponse().body(field.getKey(), equalTo(field.getValue()));
                }
            }
        });

        And("response includes the following in any order", (DataTable dataTable) -> {
            Map<String, String> responseFields = dataTable.asMap(String.class, String.class);
            for (Map.Entry<String, String> field : responseFields.entrySet()) {
                if (StringUtils.isNumeric(field.getValue())) {
                    testContext.getValidatableResponse().body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
                } else {
                    testContext.getValidatableResponse().body(field.getKey(), containsInAnyOrder(field.getValue()));
                }
            }
        });
    }
}