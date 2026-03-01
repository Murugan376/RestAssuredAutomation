Feature: Validate Add Place API's

  @AddPlace
  Scenario: Verify place is added successfully using Post method
    Given Add place payload
    When User calls "AddPlaceAPI" with "post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

  @AddPlace
  Scenario Outline: Verify place is added successfully using Post method
    Given Add place payload with "<name>","<language>","<address>"
    When User calls "AddPlaceAPI" with "post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify "place_id" created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name | language | address        |
      | Arun | English  | karur District |
#      | Thamzil | Tamil    | Namkkal District  |
#      | Tinesh  | Tamil    | namakkal District |
#      | Praveen | Tamil    | namakkal District |

  @AddPlace
  Scenario: Verify place is added successfully using Post method
    Given Add place payload
    When User calls "AddPlaceAPI" with "post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

  @GetPlace
  Scenario: Verify using placeID from post response get the added place from server
    Given Get the user place payload using get method with "place_id" value from "AddPlaceAPI" response
    When User calls "getPlaceAPI" with "get" http request
    Then the API call got success with status code 200
    And "name" in response body is "Murugan"
    And "language" in response body is "Tamil"


  @DeletePlace
  Scenario: Verify place is deleted successfully using delete method
    Given Delete place payload using place_id value from AddPlaceAPI response from previous tescase
    When User calls "deletePlaceAPI" with "delete" http request
    Then the API call got success with status code 200

