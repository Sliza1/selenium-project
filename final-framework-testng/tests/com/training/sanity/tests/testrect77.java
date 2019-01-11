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
import com.training.pom.rec76multipleusers;
import com.training.utility.CompareDBData;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class testrect77 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private rec76multipleusers addPost;
	private  CompareDBData comparedbdata;
	private String actual;
	private String expected="New user created. Edit user";

	@BeforeClass
	public  void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addPost=new rec76multipleusers(driver);
		comparedbdata = new CompareDBData(); 
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
	public void dbTest(String uname,String mail,String fname,String lname,String urli,String spassword,String role ) throws InterruptedException  {
		
		addPost.mouseoverparticularpost();//Click on Posts link
		
		addPost.addnewuser();//Click all Posts link
		addPost.usernameval(uname,mail,fname,lname,urli);
		//Thread.sleep(1000);//mouse over to particular post
		addPost.usernameval1(spassword);//click on trash
		//Thread.sleep(4000);
		addPost.usernameval2(role);
		Thread.sleep(1000);
		String actual=addPost.confirm();
		//Assert.assertEquals(actual, expected);//comparing expected and actual
		Assert.assertTrue(comparedbdata.dbMatch(uname,fname,lname,mail));
		screenShot.captureScreenShot("First");
	}
}

