package com.autodesk.pomrepositorylib;
/**
 * 
 * @author Deepak
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {   //rule -1
	
	public Login(WebDriver driver) {             //Rule -4
		PageFactory.initElements(driver, this);
	}
	
	
    @FindBy(name="user_name")                   //Rule -2 
    private WebElement usernameEdt;
    
    @FindBy(name="user_password")
    private WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    private WebElement loginButon;

	public WebElement getUsernameEdt() {        //rule-3
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButon() {
		return loginButon;
	}
    
	public void loginToApp(String username , String password) {             //Rule -5
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButon.click();
	}
	public void loginToApp() {             //Rule -5
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginButon.click();
	}
    
    
}
