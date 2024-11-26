Feature: Insert Products using POST API

  Scenario Outline: Validate post product API works correctly
    Given I hit the url of the post product API endpoint
    And I pass the request body of the product title "<productTitle>"
    When I send the POST request
    Then I receive a response code as 200

    Examples:
      | productTitle |
      | shoes        |
      | bag          |
      | watch        |
