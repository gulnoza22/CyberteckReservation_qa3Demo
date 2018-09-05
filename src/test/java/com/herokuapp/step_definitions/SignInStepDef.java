package com.herokuapp.step_definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.Select;

import com.herokuapp.pages.HuntPage;
import com.herokuapp.pages.MapPage;
import com.herokuapp.pages.SignInPage;
import com.herokuapp.utilities.BrowserUtils;
import com.herokuapp.utilities.ConfigurationReader;
import com.herokuapp.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SignInStepDef {
	
	SignInPage signinPage= new SignInPage();
	MapPage mapPage= new MapPage();
	HuntPage huntPage= new HuntPage();
	
	@Given("the user is on the sign in page")
	public void the_user_is_on_the_sign_in_page() {
	    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	@When("the user sign in using email {string} and password {string}")
	public void the_user_sign_in_using_email_and_password(String email, String password) {
	    signinPage.email.sendKeys(email);
	    signinPage.password.sendKeys(password);
	    signinPage.signIn.click();
	}

	@Then("verify light-side page is displayed")
	public void verify_light_side_page_is_displayed() {
	   assertEquals("light-side", mapPage.lightsideText.getText());
	}

	@When("the user clicks on hunt to make reservation")
	public void the_user_clicks_on_hunt_to_make_reservation() {
	   mapPage.huntButton.click();
	}

	@Then("verify hunt for spot page is displayed")
	public void verify_hunt_for_spot_page_is_displayed() {
		assertEquals("hunt for spot", huntPage.huntforspotText.getText());
	}

	@Then("user chooses desired date {string} and time from {string} to {string} then clicks search button")
	public void user_chooses_desired_date_and_time_from_to_then_clicks_search_button(String date, String timeFrom, String timeTo) {
		BrowserUtils.waitFor(2);
		huntPage.date.sendKeys(date);

		BrowserUtils.waitFor(2);
		new Select(huntPage.timeFromButton).selectByIndex(10);
		
		BrowserUtils.waitFor(2);
		new Select(huntPage.timeToButton).selectByIndex(3);

		BrowserUtils.waitFor(2);
		huntPage.searchButton.click();
	}

	@Then("user clicks on book to reserve for stanford room")
	public void user_clicks_on_book_to_reserve_for_stanford_room() {
	    
	}

	@Then("verify booking confirmation page is displayed")
	public void verify_booking_confirmation_page_is_displayed() {
	   
	}

	@Then("user clicks on confirm button to reserve the room")
	public void user_clicks_on_confirm_button_to_reserve_the_room() {
	    
	}

	@Then("verify {string} message is displayed")
	public void verify_message_is_displayed(String string) {
	    
	}


}
