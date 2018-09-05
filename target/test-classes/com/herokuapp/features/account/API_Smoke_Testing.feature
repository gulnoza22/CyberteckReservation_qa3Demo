Feature: Api testingg
 @smoke
Scenario Outline: Testing team datas with API
 Given I logged reservation api using "jalabaster7f@drupal.org" and "terimapam" 
 Then the user should be able to verify status code is 200
 And the user should be able to get response content type in JSON 
 Then the following team datas should be returned: 
     Examples:
    |team_id |first_name |last_name |role                 |batch|location|team   |
    |38      |Teri       |Mapam     |student-team-leader  |#8   |      VA|TheCrew|
