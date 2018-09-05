Feature: DataBase testing
@db 
Scenario: Testing user info with DB
Given the user should be able to sign in with email "gmcalister7n@google.nl" and password "arluenereolfo"
Then the user should verify light-side text  
Then the user clicks on self link
Then user info should match the db records using "gmcalister7n@google.nl"

@db @gulnoza
Scenario: Testing team info with DB
 Given the user logins using "gmcalister7n@google.nl" "arluenereolfo"
 When the user should be on team page
 Then system should display all member of the "Spark" and retrieve teams information with db

 