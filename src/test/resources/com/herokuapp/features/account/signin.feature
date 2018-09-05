Feature: End to end reservation testing

Scenario: reservation testing from sign in page 
Given the user is on the sign in page
When the user sign in using email "jalabaster7f@drupal.org" and password "terimapam"
Then verify light-side page is displayed
When the user clicks on hunt to make reservation
Then verify hunt for spot page is displayed 
Then user chooses desired date "19" and time from "1:00am" to "2:30pm" then clicks search button
Then user clicks on book to reserve for stanford room
Then verify booking confirmation page is displayed 
And user clicks on confirm button to reserve the room
Then verify "conference in stanford has been successfully scheduled" message is displayed
    
    
    
    

    