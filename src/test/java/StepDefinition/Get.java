package StepDefinition;//declares package where class resides

import io.cucumber.java.en.Given;//cucmber annotations
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;//API testing
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static org.junit.Assert.*;//Junit assertions(validation)

public class Get {//handles all get request
    //request specification-->interface in restAssured-specify how request will look
    private RequestSpecification httpRequest;//store http request configuration
    private Response response;//stores api response

    // -------------------- GET Products Steps --------------------

    @Given("I hit the url of the get products api endpoint")
    public void i_hit_the_url_of_the_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/"; // Set base URI
    }

    @When("I pass the url of the products in the request")
    public void i_pass_the_url_of_the_products_in_the_request() {
        httpRequest = RestAssured.given(); // Initialize request
        response = httpRequest.get("products"); // Send GET request to fetch all products
    }

    @Then("I receive response code as {int}")
    public void i_receive_response_code_as(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode(); // Get actual status code
        assertEquals("Expected status code " + expectedStatusCode + " but got " + actualStatusCode,
                expectedStatusCode.intValue(), actualStatusCode);
    }

    @Then("I verify that the rate of the first product is {float}")
    public void i_verify_that_the_rate_of_the_first_product_is(float expectedRate) {
        JsonPath jsonPath = response.jsonPath(); // Parse the JSON response and extract data
        float actualRate = jsonPath.getFloat("[0].rating.rate"); // Extract the first product's rating
        System.out.println("Actual Rate: " + actualRate); // Log the rate
        assertEquals("The rate does not match!", expectedRate, actualRate, 0.01); // Verify with tolerance
    }



}

