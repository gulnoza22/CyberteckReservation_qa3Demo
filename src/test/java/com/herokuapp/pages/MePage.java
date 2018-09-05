package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.utilities.Driver;

public class MePage {
	
	public MePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//locator for 'Teri Mapam' text
		@FindBy(xpath="//p[.='Teri Mapam']")
		public WebElement userNameText;
		
		@FindBy(xpath="//p[contains(text(),'student-team-leader')]")
		public WebElement RoleText;
		
		@FindBy(xpath="//p[contains(text(),'#8')]")
		public WebElement batchNumberText;

		@FindBy(xpath="//p[contains(text(),'VA')]")
		public WebElement campusNameText;
		
		@FindBy(xpath="//p[.='TheCrew']")
		public WebElement TheCrewText;
		
		//GS-DB locator for user Arluene Reolfo 
		@FindBy(xpath="//p[.='Arluene Reolfo']")
		public WebElement userNameText2;
		
}
