package com.autodest.organizationTest;


import org.testng.annotations.Test;

import com.autodesk.pomrepositorylib.CreateNewOrganization;
import com.autodesk.pomrepositorylib.Home;
import com.autodesk.pomrepositorylib.OrganizationInfo;
import com.autodesk.pomrepositorylib.Organizations;
import com.autodest.genericUtils.BaseClass;
/**
 * 
 * @author Deepak
 *
 */
public class CreateOrgTest extends BaseClass{


	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		/* read the test data */
		String orgName = eLib.getExcelData("Org", "tc_01", "OrgName")+javaUtil.getRanDomData();   //TestYAntra-989
		
   		/*step 3 : navigate to Org module*/
         Home hpage = new Home(driver);
             hpage.getOrgLnk().click();
	
	/*step 4 : navigate to  Organization*/
        Organizations orgPage = new Organizations(driver);
              orgPage.getCreateOrgImg().click();
                
   	/*step 5 : create Organization*/
        CreateNewOrganization cnPage = new CreateNewOrganization(driver);
              cnPage.creatOrganization(orgName);	
     /*verify */
              OrganizationInfo orgInfo = new OrganizationInfo(driver);
              wlib.waitforElement(orgInfo.getSuccessFullMsg());
	 
	}
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustryTest() throws Throwable {
		/* read the test data */
		String orgName = eLib.getExcelData("Org", "tc_02", "OrgName")+javaUtil.getRanDomData();   
		String industry = eLib.getExcelData("Org", "tc_02", "industry");
	
   		/*step 3 : navigate to Org module*/
         Home hpage = new Home(driver);
             hpage.getOrgLnk().click();
	
	/*step 4 : navigate to  Organization*/
        Organizations orgPage = new Organizations(driver);
              orgPage.getCreateOrgImg().click();
                
   	/*step 5 : create Organization*/
        CreateNewOrganization cnPage = new CreateNewOrganization(driver);
              cnPage.creatOrganization(orgName, industry); 
      /*verify */
      OrganizationInfo orgInfo = new OrganizationInfo(driver);
      wlib.waitforElement(orgInfo.getSuccessFullMsg());       

	}
	
}
