package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Put {
    private Response response;
    private JSONObject requestParams;

    @Given("I hit the url of put products api endpoint")
    public void i_hit_the_url_of_put_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/"; // Set base URI
        requestParams = new JSONObject();

    }
    @When("I pass the url of the products in the request with {string}")
    public void iPassTheUrlOfTheProductsInTheRequestWith(String productnumber) {
        requestParams.put("title", "Updated Test Product");
        requestParams.put("price", 15.5);
        requestParams.put("description", "Updated Comfort");
        requestParams.put("category", "electronics");
        requestParams.put("image", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");

        response = given()
                .body(requestParams.toJSONString())
                .when()
                .put("products/" + productnumber);

        // Log the response status and body
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
    }

    @Then("I should receive a success response")
    public void iShouldReceiveASuccessResponse() {
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 200 but got " + statusCode, 200, statusCode);
    }


}
