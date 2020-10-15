package com.autodesk.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public Home(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	
	@FindBy(linkText = "Contacts")
    private WebElement contactLnk;
	
	@FindBy(linkText = "Organizations")
    private WebElement orgLnk;
	
	@FindBy(linkText = "Leads")
    private WebElement leadsLnk;
	
	@FindBy(linkText = "Products")
    private WebElement productlnk;

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	
	
	
	
	}
