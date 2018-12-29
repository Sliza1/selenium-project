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
import com.training.pom.rec46propertyPOM2;
import com.training.pom.rec52propertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class logintest52 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private rec52propertyPOM addPost;
	
	private String actual;
	private String expected="1 post permanently deleted.";

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addPost=new rec52propertyPOM(driver);
		
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
		
		addPost.mouseoverpost();//Click on Posts link
		Thread.sleep(1000);
		addPost.clickproperty();
		Thread.sleep(1000);
		addPost.mouse();//Click all Posts link
		
		addPost.trashlink();//mouse over to particular post
		Thread.sleep(1000);
		addPost.trashlink1();
		addPost.mouseoverprop();
		String actual=addPost.confirmsg();
		Assert.assertEquals(actual, expected);//comparing expected and actual
		screenShot.captureScreenShot("First");
	}
}

