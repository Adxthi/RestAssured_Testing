Feature: Get Products API

  Scenario: Retrieve products from the API
    Given I hit the url of the get products api endpoint
    When I pass the url of the products in the request
    Then I receive response code as 200

  Scenario Outline: Verify the rate of the first product is correct
    Given I hit the url of the get products api endpoint
    When I pass the url of the products in the request
    Then I verify that the rate of the first product is <FirstProductRate>
    Examples:
      |FirstProductRate|
      |3.9             |

