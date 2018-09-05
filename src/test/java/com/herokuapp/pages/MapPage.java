package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.utilities.Driver;

public class MapPage {
	
	public MapPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	
	//locator for light-side text
    @FindBy(xpath="//h2[.='light-side']")
    public WebElement lightsideText;
    
    //locator for hunt button
    @FindBy(xpath="//a[.='hunt']")
    public WebElement huntButton;
    
    //locator for my button
    @FindBy(xpath="//a[@class='navbar-link']")
    public WebElement myButton;

    
  //locator for team button
    @FindBy(xpath="//a[.='team']")
    public WebElement teamButton;
    
    //GS-DB testing for user names
    @FindBy(xpath="//p[.='Arluene Reolfo']")
    public WebElement firstUser;
    //GS-DB testing
    @FindBy(xpath="//p[.='Sharai Pencot']")
    public WebElement secondUser;
    //GS-DB testing
    @FindBy(xpath="//p[.='Humphrey Alsop']")
    public WebElement thirdUser;
    //GS-DB testing
    @FindBy(xpath="//p[.='Nefen Yong']")
    public WebElement fourthUser;
    //GS-DB testing for self button
    @FindBy(xpath="//a[.='self']")
    public WebElement selfButton;
}
