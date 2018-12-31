//TO Verify whether application allows admin to add new post into list
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
import com.training.pom.rec17addnewpostPOM;
import com.training.pom.rec40addcategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests2rec40 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	private rec40addcategoryPOM addnewPost;
	private String actual;
	//private String expected="Post published.";
	private String expected="January";
	private String tempResult;
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		
		addnewPost=new rec40addcategoryPOM(driver);
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
		
		addnewPost.mouseoverpost();//Click on Posts link
		
		addnewPost.clickallpost();//Click on Addnew link,Enter Valid credentials in Enter title here textbox
		//Enter valid credentials in body textbox
		addnewPost.submit();  //Click on Publish button
		addnewPost.clickaddnew();
		//addnewPost.frame();
		addnewPost.clickcheckbox();
		Thread.sleep(3000);
		addnewPost.publish();
		Thread.sleep(6000);
		addnewPost.clickviewpost();
		String actual=addnewPost.confirm();
		//actual=tempResult.substring(0, 15);
		Assert.assertEquals(actual, expected);//compare between expected and actual results
		screenShot.captureScreenShot("First");
	}
}