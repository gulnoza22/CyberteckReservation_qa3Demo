package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.utilities.Driver;

public class SignInPage {

	
	public SignInPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	//locator for email
	public WebElement email;;
	//locator for password
	public WebElement password;
	
	//locator for sign in button
    @FindBy(xpath="//button[.='sign in']")
    public WebElement signIn;
    
    
}
