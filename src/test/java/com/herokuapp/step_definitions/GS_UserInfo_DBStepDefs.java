package com.herokuapp.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.herokuapp.pages.MapPage;
import com.herokuapp.pages.MePage;
import com.herokuapp.pages.SignInPage;
import com.herokuapp.utilities.BrowserUtils;
import com.herokuapp.utilities.ConfigurationReader;
import com.herokuapp.utilities.DBUtils;
import com.herokuapp.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GS_UserInfo_DBStepDefs {
	
	
	MapPage mapPage = new MapPage();
	SignInPage signinPage = new SignInPage();
	MePage mePage= new MePage();
	
	
	@Given("the user on home page should be able to sign in with email {string} and password {string}")
	public void the_user_on_home_page_should_be_able_to_sign_in_with_email_and_password(String email, String password) {
	    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		signinPage.email.sendKeys(email);
		BrowserUtils.waitFor(1);
		signinPage.password.sendKeys(password);
		BrowserUtils.waitFor(2);
		signinPage.signIn.click();
	}

	@Then("the user should verify light-side text")
	public void the_user_should_verify_light_side_text() {
		assertEquals("light-side", mapPage.lightsideText.getText());
	}

	@Then("the user clicks on self link")
	public void the_user_clicks_on_self_link() {
		BrowserUtils.waitFor(1);
		BrowserUtils.hover(mapPage.myButton);
		BrowserUtils.waitFor(1);
		mapPage.selfButton.click();
		

	}

	@Then("user info should match the db records using {string}")
	public void user_info_should_match_the_db_records_using(String email) {
	 
		  String sql= "select U.firstname,U.lastname,U.role,T.batch_number,T.name,C.location From users U,campus C, team T\r\n" + 
		  		"Where  email='"+email+"' AND U.campus_id=C.id AND U.team_id=T.id;";
		    List<Map<String, Object>> queryResult= DBUtils.getQueryResultMap(sql);
		    
		    System.out.println(queryResult);
		     Map<String, Object> result= queryResult.get(0);
		     System.out.println(result);
		     String expectedFirstname = (String)result.get("firstname");
		     System.out.println(expectedFirstname);
		     String expectedLastname = (String)result.get("lastname");
		     String expectedRolename = (String)result.get("role");
		     String expectedBatchNumber = "#" + (String)result.get("batch_number").toString();
		     String expectedLocationname = (String)result.get("location");
		     
		     
		     String actualFirstname=mePage.userNameText2.getText().split(" ")[0];
		     BrowserUtils.waitFor(2);
			 String actualLastname=mePage.userNameText2.getText().split(" ")[1];
			  BrowserUtils.waitFor(2);
			 String actualRoleName= mePage.RoleText.getText();
			  BrowserUtils.waitFor(2);
			 String actualBatchNumber= mePage.batchNumberText.getText();
			  BrowserUtils.waitFor(2);
			 String actualCampusName= mePage.campusNameText.getText();
			  BrowserUtils.waitFor(2);
			
			 Assert.assertEquals(expectedFirstname, actualFirstname);
			 Assert.assertEquals(expectedLastname, actualLastname);
			 Assert.assertEquals(expectedRolename, actualRoleName);
			 Assert.assertEquals(expectedBatchNumber, actualBatchNumber);
			 Assert.assertEquals(expectedLocationname, actualCampusName);
			 
		}
		
	

}
