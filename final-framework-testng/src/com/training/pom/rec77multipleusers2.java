//To Verify whether application allows admin to add new user & details get displayed in database
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class rec77multipleusers2 {
	
		private WebDriver driver; 
		
		public rec77multipleusers2(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-users\"]/a/div[3]")
		private WebElement users; 
		
		@FindBy(xpath="//*[@id=\"menu-users\"]/ul/li[3]/a")
		private WebElement addnew; 
		
		@FindBy(id="user_login")
		private WebElement username; 
		
		@FindBy(id="email")
		private WebElement mailid;
		
		@FindBy(id="first_name")
		private WebElement firstname;
		
		@FindBy(id="last_name")
		private WebElement lastname;
		
		@FindBy(id="url")
		private WebElement url;
		
		@FindBy(xpath="//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
		private WebElement showpassword;
		
		@FindBy(id="pass1-text")
		private WebElement showpassword1;
		
		@FindBy(id="role")
		private WebElement role1;
		
		@FindBy(id="createusersub")
		private WebElement newuser;
		
		@FindBy(name="pw_weak")
		private WebElement weakPwrdChckBox;
		
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement conmsg; 
		//mouseover to post link
		
		
		
		
		
		//mouse over to property link
		public void mouseoverparticularpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.users).build().perform();
		}
		//Click on add new link
		public void addnewuser()
		{
         
         addnew.click();
		}
		//enter text in username, mail, firstname ,lastname and website fields
		public void usernameval(String uname,String mail,String fname,String lname,String urli)
		{
         
         username.sendKeys(uname);
         mailid.sendKeys(mail);
         firstname.sendKeys(fname);
         lastname.sendKeys(lname);
         url.sendKeys(urli);
         
		}
		//enter password
		public void usernameval1(String spassword ) throws InterruptedException
		{
         
         showpassword.click();
         showpassword1.clear();
         showpassword1.sendKeys(spassword);
         //Thread.sleep(4000);
         //boolean isWeak = driver.findElements(By.name("pw_weak")).size() > 0;
			///if(isWeak) {
				//this.weakPwrdChckBox.click();}
         
         
		}
		//select role and click add new user
		public void usernameval2(String role )
		{
			Select dropdown=new Select(role1);
			 dropdown.selectByVisibleText(role);	
			 newuser.click();	
	         
	         
			}
		
		//check expected
		public String confirm( )
		{
			String s=conmsg.getText();
			return s;
			
	         
	         
			}	
}



