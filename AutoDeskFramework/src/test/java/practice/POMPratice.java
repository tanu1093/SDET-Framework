package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.autodesk.pomrepositorylib.Login;

public class POMPratice {
	
	@Test
	public void sampleTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		
		Login loginpage = new Login(driver);
	         loginpage.loginToApp("admin", "admin");
	}

}






