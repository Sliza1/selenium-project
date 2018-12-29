//To verify whether application allows  admin to add the post into trash
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
import com.training.pom.rec16addpostPOM;
import com.training.pom.retc34POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class logintest34 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM log;
	private static Properties properties;
	private ScreenShot screenShot;
	private retc34POM addPost;
	private String actual;
	private String expected="Thank you for your message. It has been sent.";
	private String tempResult;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		log = new LoginPOM(driver); 
		addPost=new retc34POM(driver);
		
		baseUrl = properties.getProperty("URL1");
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
		log.clicklogin();
		log.sendUserName("sunil");
		log.sendPassword("sunil@123");
		log.clickLoginBtn(); 
		
	}
	
	@Test(priority=2)
	public void Test() throws InterruptedException {
		
		addPost.clickcommercial();//Click on Posts link
		addPost.clicksearch();
		Thread.sleep(1000);
		addPost.clickdrop();
	
		addPost.enterdetails();
		addPost.clicksend();
		//tempResult=addPost.message().trim();
		//String actual=tempResult.substring(0, 27);
		String actual=addPost.message();
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("First");
	}
}

