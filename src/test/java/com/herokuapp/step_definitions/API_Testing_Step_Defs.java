package com.herokuapp.step_definitions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.herokuapp.utilities.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class API_Testing_Step_Defs  {
	
	Response responce;
	String token;
	String user;
	@Given("I logged reservation api using {string} and {string}")
	public void i_logged_reservation_api_using_and(String username, String password) {
	    
	     user = username;
	        RestAssured.baseURI = Environment.BASE_URI;
	        Response res = RestAssured.given().param("email", username).param("password", password).and().header("Accept", "application/json").when()
	                .get(RestAssured.baseURI + "/sign");
	        token = res.jsonPath().get("accessToken");
	        System.out.println(token);
		
	}

	@Then("the user should be able to verify status code is {int}")
	public void the_user_should_be_able_to_verify_status_code_is(Integer code) {
		
           RestAssured.basePath = "api/students/39";
		
		responce = RestAssured.given().and().header("Authorization", token).when().get();
		assertEquals(responce.statusCode(),200);
	    
	}

	@Then("the user should be able to get response content type in JSON")
	public void the_user_should_be_able_to_get_response_content_type_in_JSON() {
	    
		responce.then().header("Content-Type", "text/html;charset=utf-8");
	}

	@Then("the following team datas should be returned:")
	public void the_following_team_datas_should_be_returned() {
		  RestAssured.basePath = "api/students/39";
		  assertTrue(responce.asString().contains("Teri"));
		  assertTrue(responce.asString().contains("Mapam"));
		  assertTrue(responce.asString().contains("student-team-leader"));
		

	}


}
