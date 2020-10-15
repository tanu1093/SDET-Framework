package com.autodesk.contacttest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.autodesk.pomrepositorylib.Contacts;
import com.autodesk.pomrepositorylib.CreateNewConatct;
import com.autodesk.pomrepositorylib.CreateNewOrganization;
import com.autodesk.pomrepositorylib.Home;
import com.autodesk.pomrepositorylib.Login;
import com.autodesk.pomrepositorylib.OrganizationInfo;
import com.autodesk.pomrepositorylib.Organizations;
import com.autodest.genericUtils.ExcelUtility;
import com.autodest.genericUtils.FileUtility;
import com.autodest.genericUtils.JavaUtility;
import com.autodest.genericUtils.WebDriverUtility;
import com.sun.corba.se.spi.oa.OADefault;
/**
 *  Test script for Contact Module
 * @author Deepak
 *
 */
public class CreateContactTest {
	/*Create an Object Lib*/
	JavaUtility javaUtil = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void createContactWithOrg() throws Throwable {


		/* read the test data */
		String orgName = eLib.getExcelData("Sheet1", "tc_01", "OrgName")+javaUtil.getRanDomData();   //TestYAntra-989
		String industry = eLib.getExcelData("Sheet1", "tc_01", "Industry");
		String lastName = eLib.getExcelData("Sheet1", "tc_01", "LastName");
		String orgamizationSearchOptions = eLib.getExcelData("Sheet1", "tc_01", "OrgamizationSearchOptions");
		String leadSource = eLib.getExcelData("Sheet1", "tc_01", "LeadSource");
		
		/*read common Data*/
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/*step 1 : launch the browser*/
		  
		WebDriver driver;
		
		if(BROWSER.equals("firefox")) {
		   driver = new FirefoxDriver();
		}else if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}else if(BROWSER.equals("ie")){
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		
		/*step 2 : login to app*/
             Login lPage = new Login(driver);
            		 lPage.loginToApp(USERNAME, PASSWORD);
		  
		/*step 3 : navigate to Org module*/
            Home hpage = new Home(driver);
            		 hpage.getOrgLnk().click();
		
		/*step 4 : navigate to  Organization*/
           Organizations orgPage = new Organizations(driver);
                   orgPage.getCreateOrgImg().click();
                   
      	/*step 5 : create Organization*/
           CreateNewOrganization cnPage = new CreateNewOrganization(driver);
                   cnPage.creatOrganization(orgName, industry);
                   
		/*step 6 : navigate to Contact Module*/
                   hpage.getContactLnk().click();

		/*step 7 : click on create Contact Button*/
          Contacts contactPage = new Contacts(driver);
        		  contactPage.getCreateOrgImg().click();
		  
       /*step 8 :create Contact with OrgName */
        CreateNewConatct cnp = new CreateNewConatct(driver);
                 cnp.createConatctWithOrgName(lastName, orgName, orgamizationSearchOptions);

		  
		/*Step 8 : verify */
		
		  
		/*step 9: logout */
	
		  
		/*step 10: close the browser */
		  
	}
	

}






