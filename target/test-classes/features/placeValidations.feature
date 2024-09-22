Feature: Validating place API's

#Scenario: Verify if place is being successfully added using AddPlaceAPI
 #   Given Add Place Payload
 #   When User calls "AddPlaceAPI" with POST http request
  #  Then the API call got success with status code 200
   # And "status" in response body is "OK"
  #  And "scope" in response body is "APP"


#Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
 #   Given Add Place Payload with "<name>" "<language>" "<address>"
  #  When User calls "AddPlaceAPI" with "POST" http request
   # Then the API call got success with status code 200
    #And "status" in response body is "OK"
    #And "scope" in response body is "APP"
    
#Examples:
 #   |name        |language        |        address        |
  #  |Kapil       |Hindi           |Saket-Pandav Nagar  |   
   # |Ravi        |Hinglish        |ASD Street          | 
       
    
    #Now above we will provide more params so that this test case will run for different data set two times
   
@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify placeId created maps to "<name>" using "getPlaceAPI"
 #Below name i.e kapil should be fetched in get api 
    
Examples:
    |name        |language        |        address        |
    |Kapil       |Hindi           |Saket-Pandav Nagar  |   
  #  |Ravi        |Hinglish        |ASD Street          | 
    
 @deletePlace
    Scenario: Verify if deletePlace API is working
       Given DeletePlace Payload
       When User calls "deletePlaceAPI" with "POST" http request
       Then the API call got success with status code 200
       And "status" in response body is "OK"
