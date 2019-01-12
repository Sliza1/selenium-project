//To Verify whether application allows admin to add multiple users for different roles
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.TestUtil;

public class testrect76 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private rec76multipleusers addPost;
	
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
	public void multipleusers(String uname,String mail,String fname,String lname,String urli,String spassword,String role ) throws InterruptedException  {
		
		addPost.mouseoverparticularpost();//Click on Property link
		
		addPost.addnewuser();//Click addnew  link
		addPost.usernameval(uname,mail,fname,lname,urli);//enter text in username, mail, firstname ,lastname and website fields
		
		addPost.usernameval1(spassword);//enter password
		//Thread.sleep(4000);
		addPost.usernameval2(role);//select role and clickk add new user 
		Thread.sleep(1000);
		String actual=addPost.confirm();
		Assert.assertEquals(actual, expected);//comparing expected and actual
		screenShot.captureScreenShot("First");
	}
}

