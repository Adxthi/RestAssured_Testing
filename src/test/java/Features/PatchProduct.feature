Feature: Partially Update Product API

  Scenario: Partially update a product by ID
    Given I hit the url of patch products api endpoint
    When I pass the url of the patch products in the request with "5"
    Then I should receive a response
