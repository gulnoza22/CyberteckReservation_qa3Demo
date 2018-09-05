package com.herokuapp.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.herokuapp.utilities.ConfigurationReader;
import com.herokuapp.utilities.DBUtils;
import com.herokuapp.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//we can call hooks or anything else
//Hooks is very good to use for reporting and screen shots
public class Hooks {
	
	//@Before coming from cucumber not Junit
   // runs before every scenario
	@Before
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 Driver.getDriver().manage().window().maximize();
		 Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}
	//@Before("@smoke")--> will run before every scneario that has tag @smoke
// this tag @amazon_check is specifically running another website, so this setup for specificly test
	@Before("@amazon_check")
	public void setUpAmazon() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get("http://amazon.com");
	}
	
	@Before("@db")
	public void setUpDBConnection() {
		DBUtils.createConnection();
	}

	@After("@db")
	public void tearDownDBConnection() {
		DBUtils.destroy();
	}

	
	//in cucumber we need to use this screen shot not from BrowserUtils.
	//@After runs every after scenario
	//Driver.close  will close any website you use in aBegore tag
	@After
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
					.getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}

}
