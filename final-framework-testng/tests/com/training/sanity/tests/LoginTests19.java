//TO Verify whether application allows admin to delete category from the categories page
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.rec19delcategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests19 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	
	private rec19delcategoryPOM delCat;
	private String actual;
	private String expected="Categories deleted.";
	

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		
		
		delCat=new rec19delcategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
	}

	
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
	}
	
	@Test(priority=2)
	public void Test() throws InterruptedException {
		
		delCat.mouseoverpost();//click post link
		Thread.sleep(1000);
		delCat.clickallpost();////Click on Categories link
		//Click on the checkbox of the category to be deleted
		delCat.delete();//Click on Bulk Action list box
		//Select Delete in Bulk Action links
		String actual=delCat.confirm();
		Assert.assertEquals(actual, expected);//compare between actual and expected
		screenShot.captureScreenShot("First");
	}
}
