package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.utilities.Driver;

public class SchedulPage {

	public SchedulPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy(xpath="//div[.='conference in stanford has been successfully scheduled']")
	public WebElement successfullyScheduledText;
}
