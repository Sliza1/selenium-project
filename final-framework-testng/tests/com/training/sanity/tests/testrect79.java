//To verify whether application allows  admin to add the post into trash
package com.training.sanity.tests;




import static org.testng.Assert.assertTrue;

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
import com.training.pom.rec79multiplefeaturePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class testrect79 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private rec79multiplefeaturePOM addPost;
	
	private String actual;
	private String expected="New user created. Edit user";

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addPost=new rec79multiplefeaturePOM(driver);
		
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
	
	@Test(priority=2,dataProviderClass=TestUtil.class,dataProvider="dp")
	public void multiplefeatures(String nam,String slu,String feature,String desc ) throws InterruptedException  {
		
		addPost.mouseoverpost();//Click on Posts link
		
		addPost.clickaddnew();//Click all Posts link
		addPost.entercredential(nam,slu);
		Thread.sleep(1000);//mouse over to particular post
		addPost.entercredential1(feature,desc);//click on trash
		//Thread.sleep(4000);
		addPost.addnewfeature();
		Thread.sleep(3000);
		//addPost.refresh();
		addPost.enterSearchItem(nam.trim());
		addPost.clickOnSearchRegionBtn();
		Thread.sleep(1000);
		
		Assert.assertTrue(addPost.searchForAddedRegion(nam.trim()));//comparing expected and actual
		screenShot.captureScreenShot("First");
	}
}

