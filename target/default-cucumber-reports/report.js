$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/herokuapp/features/account/smoke.feature");
formatter.feature({
  "name": "Api testingg",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Testing team datas with API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "I logged reservation api using \"jalabaster7f@drupal.org\" and \"terimapam\"",
  "keyword": "Given "
});
formatter.step({
  "name": "the user should be able to verify status code is 200",
  "keyword": "Then "
});
formatter.step({
  "name": "the user should be able to get response content type in JSON",
  "keyword": "And "
});
formatter.step({
  "name": "the following team datas should be returned:",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "team_id",
        "first_name",
        "last_name",
        "role",
        "batch",
        "location",
        "team"
      ]
    },
    {
      "cells": [
        "38",
        "Teri",
        "Mapam",
        "student-team-leader",
        "#8",
        "VA",
        "TheCrew"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing team datas with API",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged reservation api using \"jalabaster7f@drupal.org\" and \"terimapam\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Smoke_API_StepDefs.i_logged_reservation_api_using_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should be able to verify status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "Smoke_API_StepDefs.the_user_should_be_able_to_verify_status_code_is(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should be able to get response content type in JSON",
  "keyword": "And "
});
formatter.match({
  "location": "Smoke_API_StepDefs.the_user_should_be_able_to_get_response_content_type_in_JSON()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the following team datas should be returned:",
  "keyword": "Then "
});
formatter.match({
  "location": "Smoke_API_StepDefs.the_following_team_datas_should_be_returned()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});