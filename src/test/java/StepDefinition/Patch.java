package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Patch {
    private Response response;
    private JSONObject requestParams;
    @Given("I hit the url of patch products api endpoint")
    public void i_hit_the_url_of_patch_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/"; // Set base URI
        requestParams = new JSONObject();
    }

    @When("I pass the url of the patch products in the request with {string}")
    public void iPassTheUrlOfThePatchProductsInTheRequestWith(String productnumber) {
        requestParams.put("title", "Partially Updated Test Product");

        response = given()
                .body(requestParams.toJSONString())
                .when()
                .patch("products/" + productnumber);

        // Log the response status and body
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());


    }
    @Then("I should receive a response")
    public void iShouldReceiveAResponse() {
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 200 but got " + statusCode, 200, statusCode);
    }
}
