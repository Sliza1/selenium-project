//To verify whether application allows admin to add new property with all details & added property details in home screen for user
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
import com.training.pom.rec76multipleusers;
import com.training.pom.rec80multipleusers2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class testrect80 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private rec80multipleusers2 addPost;
	
	private String actual;
	private String expected="dakshini2 For Sale Apartments";

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addPost=new rec80multipleusers2(driver);
		
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
	public void multipleusers() throws InterruptedException  {
		
		addPost.mouseoverparticularpost();//Click on Property link
		
		addPost.addnewuser();//Click add new link
		addPost.entercrdentials("dakshini2","launch","5000","200");//enter valid text in enter title here,textbox, price and price per sq metre
		Thread.sleep(2000);
		addPost.maindetailstab("new","electronic city","immediate");//Click main details tab and enter valid text in status, location and possession
		//Thread.sleep(4000);
		addPost.locationtab("yewanthpur","yeswanour","500","56");//Click location tab and enter valid text in enter address, map,latitude and longitude
		Thread.sleep(1000);
		addPost.detailtab("2");//Click detail tab and enter text in storage room textbox
		Thread.sleep(4000);
		addPost.checkboxes();//Click on feature and region textboxes
		Thread.sleep(3000);
		addPost.publish();//clcik publish
		Thread.sleep(5000);
		addPost.logoff();//user logs out
		Thread.sleep(1000);
		addPost.estate("dakshini2");//user clicks real estate and search for the added property.
		Thread.sleep(1000);
		String actual=addPost.checkexpected();
		Assert.assertEquals(actual, expected);//comparing expected and actual
		screenShot.captureScreenShot("First");
	}
}

