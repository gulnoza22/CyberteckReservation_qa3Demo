package com.herokuapp.step_definitions;


import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.herokuapp.pages.MapPage;
import com.herokuapp.pages.SignInPage;
import com.herokuapp.utilities.BrowserUtils;
import com.herokuapp.utilities.ConfigurationReader;
import com.herokuapp.utilities.DBUtils;
import com.herokuapp.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GS_TeamInfo_DBStepDefs {

	MapPage mapPage = new MapPage();
	SignInPage signinPage = new SignInPage();


	@Given("the user logins using {string} {string}")
	public void the_user_logins_using(String email, String password) {
	    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		signinPage.email.sendKeys(email);
		BrowserUtils.waitFor(1);
		signinPage.password.sendKeys(password);
		BrowserUtils.waitFor(2);
		signinPage.signIn.click();
	}

	@When("the user is on the my team page")
	public void the_user_is_on_the_my_team_page() {
		BrowserUtils.waitFor(2);
		BrowserUtils.hover(mapPage.myButton);
		BrowserUtils.waitFor(1);
		mapPage.teamButton.click();

	}

	@Then("system should display all member of the {string} and retrieve teams information with db")
	public void system_should_display_all_member_of_the_and_retrieve_teams_information_with_db(String team) {

		BrowserUtils.waitFor(3);
		String sqlQuery = "select firstname, lastname from users where team_id = 48;";
		BrowserUtils.waitFor(3);
		List<Map<String, Object>> result = DBUtils.getQueryResultMap(sqlQuery);
		
		Map<String, Object> queryResult1 = result.get(0);
		Map<String, Object> queryResult2 = result.get(1);
		Map<String, Object> queryResult3 = result.get(2);
		Map<String, Object> queryResult4 = result.get(3);
		
		String expectedFirstname1 = (String) queryResult1.get("firstname");
		String expectedLastname1 = (String) queryResult1.get("lastname");
	
		String expectedFirstname2 = (String) queryResult2.get("firstname");
		String expectedLastname2 = (String) queryResult2.get("lastname");
		
		String expectedFirstname3 = (String) queryResult3.get("firstname");
		String expectedLastname3 = (String) queryResult3.get("lastname");
		
		String expectedFirstname4 = (String) queryResult4.get("firstname");
		String expectedLastname4 = (String) queryResult4.get("lastname");
		
        String actualFirstname1 = mapPage.firstUser.getText().split(" ")[0];
		String actualLastname1 = mapPage.firstUser.getText().split(" ")[1];
		
		String actualFirstname2 = mapPage.secondUser.getText().split(" ")[0];
		String actualLastname2 = mapPage.secondUser.getText().split(" ")[1];
		
		String actualFirstname3 = mapPage.thirdUser.getText().split(" ")[0];
		String actualLastname3 = mapPage.thirdUser.getText().split(" ")[1];
		
		String actualFirstname4 = mapPage.fourthUser.getText().split(" ")[0];
		String actualLastname4 = mapPage.fourthUser.getText().split(" ")[1];
		
		Assert.assertEquals(expectedFirstname1, actualFirstname1);
		BrowserUtils.waitFor(2);
		Assert.assertEquals(expectedLastname1, actualLastname1);
		
		Assert.assertEquals(expectedFirstname2, actualFirstname2);
		BrowserUtils.waitFor(2);
		Assert.assertEquals(expectedLastname2, actualLastname2);
		
		Assert.assertEquals(expectedFirstname3, actualFirstname3);
		BrowserUtils.waitFor(2);
		Assert.assertEquals(expectedLastname3, actualLastname3);
		
		Assert.assertEquals(expectedFirstname4, actualFirstname4);
		BrowserUtils.waitFor(2);
		Assert.assertEquals(expectedLastname4, actualLastname4);
		
	
	
		
		
		
		
	
	}

}
