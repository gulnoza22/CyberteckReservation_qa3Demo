package com.herokuapp.step_definitions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import com.herokuapp.utilities.ConfigurationReader;

import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class GS_API_TeamInfoStepDefs {
	Response response;
	RequestSpecification httpRequest;
	
	@Given("the user should accepts type in JSON")
	public void the_user_should_accepts_type_in_JSON() {
		
		String authPath = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzNyIsImF1ZCI6InRlYWNoZXIifQ.9LVADmey2lWFns10Uh4WCehRzrz8L9OcpK5SHlDAouE";
//		RestAssured.baseURI = ConfigurationReader.getProperty("url2");
		when().get("https://cybertek-reservation-api-qa3.herokuapp.com/api/teams/48");
		
		httpRequest = RestAssured.given().accept(ContentType.JSON)
						.and().headers("Authorization", authPath)
							.and().contentType(ContentType.JSON);
	   
	}

	@When("the user should send  GET request to REST url")
	public void the_user_should_send_GET_request_to_REST_url() {
        response = httpRequest.request(Method.GET,"/"+48);
		
		System.out.println("response :" +response.asString());
	}

	@Then("the user verifies status code is {int}")
	public void the_user_verifies_status_code_is(Integer code) {

        Assert.assertEquals(response.statusCode(),200);
	}

//	@Then("the user should be able to get response content in JSON")
//	public void the_user_should_be_able_to_get_response_content_in_JSON() {
//		
//		response = then().assertThat().contentType(ContentType.JSON);
//	}
//
//	@Then("the following team data should be returned:")
//	public void the_following_team_data_should_be_returned() {
//		
//		res = then().assertThat().body("members.id", equalTo(52))
//		.and().assertThat().body("members.firstName", equalTo("Nefen"))
//		.and().assertThat().body("members.lastName", equalTo("Yong"))
//		.and().assertThat().body("role", equalTo("student-team-member"));
//	}



}
