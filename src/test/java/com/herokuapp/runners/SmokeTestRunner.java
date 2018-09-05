package com.herokuapp.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports",
				"json:target/cucumber.json"
		 
		},
		
		tags="@smoke",
		features="src/test/resources/com/herokuapp/features",
//		features= {"src/test/resources/com/qa.herokuapp/features", 
//				"src/test/resources/com/qa3.herokuapp/backend"}, 
			
		glue="com/herokuapp/step_definitions"
				
	
		,dryRun = false
		)
public class SmokeTestRunner {}
  