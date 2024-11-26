Feature: Update Product API

  Scenario: Update a product by ID
    Given I hit the url of put products api endpoint
    When I pass the url of the products in the request with "5"
    Then I should receive a success response
