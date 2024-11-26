package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Delete {
    private Response response;
    private JSONObject requestParams;
    @Given("I hit the url of delete products api endpoint")
    public void i_hit_the_url_of_delete_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/"; // Set base URI
        requestParams = new JSONObject();
    }
    @When("I pass the url of delete products in the request with {string}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWith(String productnumber) {
        response= given()
                .when()
                .delete("products/" + productnumber);

        // Log the response status and body
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());

    }

    @Then("receive a response")
    public void receiveAResponse() {
        assertEquals(200,response.getStatusCode());
    }
}
