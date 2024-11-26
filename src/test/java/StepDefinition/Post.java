package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;//cucumber annotations
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;//API testing
import static org.junit.Assert.assertEquals;//assertion validation
import java.util.List;//list for handling multiple products
import org.json.simple.JSONObject;//creating request body


public class Post{

    final RequestSpecification httpRequest;//request configuration
    final JSONObject requestParams;//json object to hold request body params
    private Response response;//store response

    public Post() {
        // Set base URI
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given().header("Content-Type", "application/json");//Request specification with JSON content type header

        // Initialize request parameters
        requestParams = new JSONObject();
        requestParams.put("price", 20.0);
        requestParams.put("description", "running shoes");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "fashion");
    }

    @Given("I hit the url of the post product API endpoint")
    public void iHitTheUrlOfThePostProductAPIEndpoint() {
        // This step can remain unchanged
    }

    @And("I pass the request body of the product title {string}")
    public void iPassTheRequestBodyOfTheProductTitleProductTitle(String productTitle) {
        requestParams.put("title", productTitle);
        httpRequest.body(requestParams.toJSONString());
    }

    @When("I send the POST request")
    public void iSendThePostRequest() {
        response = httpRequest.post("/products");
        System.out.println("Response Status: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Then("I receive a response code as {int}")
    public void iReceiveAResponseCodeAs(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals("Expected status code " + expectedStatusCode + " but got " + actualStatusCode,
                expectedStatusCode.intValue(), actualStatusCode);
    }

    // New method to post multiple products
    @And("I post the following products")
    public void iPostTheFollowingProducts(List<String> productTitles) {
        for (String productTitle : productTitles) {
            // Update product title for each request
            requestParams.put("title", productTitle);
            httpRequest.body(requestParams.toJSONString());

            // Send POST request for each product
            response = httpRequest.post("/products");
            System.out.println("Posted Product: " + productTitle);
            System.out.println("Response: " + response.getStatusLine());
        }
    }


}
