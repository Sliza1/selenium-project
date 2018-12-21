//To verify whether application allows admin to add new category
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
import com.training.pom.rec18addnewcategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests2rec18 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	private rec18addnewcategoryPOM addnewcategory;
	private String actual;
	private String expected="New launches";

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addnewcategory=new rec18addnewcategoryPOM(driver);
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
		
		addnewcategory.mouseoverpost();//Click on Posts link
		Thread.sleep(1000);
		addnewcategory.clickallpost();//Click on Categories link
		//Enter Valid Credentials in Name,slug and description textbox
		addnewcategory.submit();//Click on Add New Category button
		
		String actual=addnewcategory.confirm();
		Assert.assertEquals(actual, expected);//compare between actual and expected results
		screenShot.captureScreenShot("First");
	}
	
}
