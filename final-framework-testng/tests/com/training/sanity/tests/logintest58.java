//To verify whether application allows admin to reply for the comment added by user
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
import com.training.pom.rec58propertyPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class logintest58 {

	private WebDriver driver;
	private WebDriver driver1;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private rec58propertyPOM2 addPost;
	private rec58propertyPOM2 addPost1;
	private String actual;
	private String expected="1 post permanently deleted.";

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver); 
		addPost=new rec58propertyPOM2(driver);
		//addPost1=new rec58propertyPOM2(driver1);
		
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
	//@Test(priority=1)
	//public void validLoginTest() throws InterruptedException {
		//loginPOM.sendUserName("admin");
		//loginPOM.sendPassword("admin@123");
		//loginPOM.clickLoginBtn(); 
		
	//}
	
	@Test
	public void Test() throws InterruptedException {
		
		
		
		addPost.clickblog("today is Thursday","tuli","tuli@gmail.com");//click blog tab//Click on Read More link of post added by admin//enter details/Click on Post Comment button
		//Thread.sleep(1000);
        addPost.newwindow("admin","admin@123");//open admin site and login//click on Comments tab
		Thread.sleep(2000);
		addPost.entercredentials("mat20");//Mouse over comments//Click on Reply icon//enter details and again click reply
		int expected=addPost.entercredentials1();//expected result
		Thread.sleep(2000);
		addPost.entercredentials2();//page refresh
		Thread.sleep(1000);
		int actual=addPost.entercredentials3();//actual results
		Assert.assertEquals(actual, expected);//checking expected and actual results
		screenShot.captureScreenShot("First");
	}
}

