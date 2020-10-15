package com.autodesk.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodest.genericUtils.WebDriverUtility;
/**
 * 
 * @author Deepak
 *
 */
public class CreateNewOrganization extends WebDriverUtility{
	WebDriver driver;
	public CreateNewOrganization(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industriesLst;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustriesLst() {
		return industriesLst;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void creatOrganization(String orgName , String industriesOption) throws Throwable {
		orgNameEdt.sendKeys(orgName);
		select(industriesLst, industriesOption);
		saveBtn.click();
		
		 OrganizationInfo orginfo = new OrganizationInfo(driver);
		 waitforElement(orginfo.getSuccessFullMsg());
	}
	
	public void creatOrganization(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
}
