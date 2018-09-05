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
		
		tags="@temp",
		features="src/test/resources/com/herokuapp/features",
				
		
		glue="com/herokuapp/step_definitions"
			
//				,dryRun = true
		)
public class CukesTestRunner {}
