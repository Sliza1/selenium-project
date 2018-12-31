//To verify whether application allows  admin to add the post into trash
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec52propertyPOM {
	
		private WebDriver driver; 
		
		public rec52propertyPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
		private WebElement propertylink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[2]/a")
		private WebElement allproperty; 
		
		@FindBy(xpath="//*[@id=\"post-3424\"]/td[1]/strong/a")
		private WebElement mouseover1;
		
		@FindBy(xpath="//*[@id=\"post-3424\"]/td[1]/div[3]/span[3]/a")
		private WebElement trash; 
		
		@FindBy(xpath="//*[@id=\"wpbody-content\"]/div[3]/ul/li[4]/a")
		private WebElement trash1;
		
		@FindBy(xpath="//*[@id=\"post-3424\"]/td[1]/strong")
		private WebElement mouseover;
		@FindBy(xpath="//*[@id=\"post-3424\"]/td[1]/div[2]/span[2]/a")
		private WebElement delete;
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement conmsg;
		//Click on Properties tab
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.propertylink).build().perform();
		}
		//Click all properties link
		public void clickproperty() {
			this.allproperty.click();
		}
		//Mouse over the property
		public void mouse() {
			Actions action=new Actions(driver);
	         action.moveToElement(this.mouseover1).build().perform();
		}
		
		
		//Click on Trash link
		public void trashlink()
		{
         this.trash.click();
         
         
		}
		//Click on Trash link
		public void trashlink1()
		{
         this.trash1.click();
         
         
		}
		//Mouse over property details and click delete permanently link
		public void mouseoverprop()
		{
			Actions action=new Actions(driver);
	         action.moveToElement(this.mouseover).build().perform();
	         this.delete.click();
         
         
		}
		//Checking the expected result
		public String confirmsg()
		{
		
		String s=conmsg.getText();
		return s;
	}
}


