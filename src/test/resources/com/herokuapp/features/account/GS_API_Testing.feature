Feature: API testinnngg

Scenario Outline: Testing teams data with APIiiii
 Given the user should accepts type in JSON
 When the user should send  GET request to REST url 
 Then the user verifies status code is 200
 And the user should be able to get response content in JSON 
 Then the following team data should be returned: 
	 Examples:
	|id |first_name |last_name|role               |
    |52 |Nefen      |Yong     |student-team-member|
   
    
    
  Scenario: Negative testing in API
  Given the user should send GET request url
  Then the user should verify status code is 404
  And Responce body error message is "Not Found"  