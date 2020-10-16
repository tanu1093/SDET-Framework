package com.autodesk.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.pomrepositorylib.ContactInfo;
import com.autodesk.pomrepositorylib.Contacts;
import com.autodesk.pomrepositorylib.CreateNewConatct;
import com.autodesk.pomrepositorylib.CreateNewOrganization;
import com.autodesk.pomrepositorylib.Home;
import com.autodesk.pomrepositorylib.Login;
import com.autodesk.pomrepositorylib.Organizations;
import com.autodest.genericUtils.BaseClass;
import com.autodest.genericUtils.ExcelUtility;
import com.autodest.genericUtils.FileUtility;
import com.autodest.genericUtils.JavaUtility;
import com.autodest.genericUtils.WebDriverUtility;
/**
 *  Test script for Contact Module
 * @author Deepak
 *
 */
public class CreateContactTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
		/* read the test data */
		String lastName = eLib.getExcelData("Contact", "tc_02", "lastName")+javaUtil.getRanDomData();   //TestYAntra-989
	
       		 
     	/*step 3 : navigate to Contact module*/
        Home hpage = new Home(driver);
             hpage.getContactLnk().click();
             
     	/*step 4 : click on create Contact Button*/
            Contacts contactPage = new Contacts(driver);
           		  contactPage.getCreateOrgImg().click();
           		  
   		 /*step 5 :create Contact with OrgName */
          CreateNewConatct cnp = new CreateNewConatct(driver);
             cnp.createContact(lastName);
             
         /* step 6 verify */
             ContactInfo conInfo = new ContactInfo(driver);
             wlib.waitforElement(conInfo.getSuccessFullMSG());
             String actLastNAme = conInfo.getLastNameInfo().getText();
           Assert.assertEquals(actLastNAme, lastName);    
           

	}
	

	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable {


		/* read the test data */
		String orgName = eLib.getExcelData("Contact", "tc_01", "OrgName")+javaUtil.getRanDomData();   //TestYAntra-989
		String industry = eLib.getExcelData("Contact", "tc_01", "Industry");
		String lastName = eLib.getExcelData("Contact", "tc_01", "LastName");
		String orgamizationSearchOptions = eLib.getExcelData("Contact", "tc_01", "OrgamizationSearchOptions");
		String leadSource = eLib.getExcelData("Contact", "tc_01", "LeadSource");
		

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
                 cnp.createConatct(lastName, orgName, orgamizationSearchOptions);

		  
		/*Step 8 : verify */
                 ContactInfo conInfo = new ContactInfo(driver);
                 wlib.waitforElement(conInfo.getSuccessFullMSG());
                 String actLastNAme = conInfo.getLastNameInfo().getText();
               Assert.assertEquals(actLastNAme, lastName);  
                
	}
	

}






