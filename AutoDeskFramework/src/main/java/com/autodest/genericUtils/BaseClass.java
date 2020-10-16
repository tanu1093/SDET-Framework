package com.autodest.genericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.autodesk.pomrepositorylib.Home;
import com.autodesk.pomrepositorylib.Login;
import com.beust.jcommander.Parameter;

public class BaseClass {
	/*Create an Object Lib*/
	public WebDriver driver;
	public JavaUtility javaUtil = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("connect to DB");
		System.out.println("configure Report");
	}
	
	//@Parameters("browser")
	//@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void configBT(String BROWSER) throws Throwable {
		/*read common Data*/
		String URL = fLib.getPropertyKeyValue("url");

		/*step 1 : launch the browser*/
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
	}
	
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
	
		/*read common Data*/
		String URL = fLib.getPropertyKeyValue("url");

		String BROWSER = fLib.getPropertyKeyValue("browser");
		/*step 1 : launch the browser*/

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
		

	}
	
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		/*step 2 : login to app*/
        Login lPage = new Login(driver);
       		 lPage.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		/*step 6: logout */
		 Home hpage = new Home(driver);
	      hpage.logout();

	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {

		/*step 7: close the browser */
			   driver.close();
			   
				// dissconnect to Data base 
	}

	//@AfterTest(groups = {"smokeTest","regressionTest"})
	public void configAT() {

		/*step 7: close the browser */
			   driver.close();
			   
			
	}


	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configBS1() {
		System.out.println("close  DB");
		System.out.println(" Report backUP");
	}
}














