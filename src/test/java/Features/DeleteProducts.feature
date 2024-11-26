Feature: Delete Product API

  Scenario: Delete a product by ID
    Given I hit the url of delete products api endpoint
    When I pass the url of delete products in the request with "5"
    Then receive a response
