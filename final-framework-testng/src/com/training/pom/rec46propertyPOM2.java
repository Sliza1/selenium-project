//To verify whether application allows  admin to add the post into trash
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec46propertyPOM2 {
	
		private WebDriver driver; 
		
		public rec46propertyPOM2(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
		private WebElement propertylink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[3]/a")
		private WebElement addnew; 
		
		@FindBy(xpath="//*[@id=\"title\"]")
		private WebElement title; 
		
		@FindBy(id="in-property_feature-166")
		private WebElement feature;
		
		@FindBy(id="in-region-39")
		private WebElement region;
		@FindBy(id="publish")
		private WebElement publish;
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement conmsg;
		//Click on Properties tab
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.propertylink).build().perform();
		}
		//Click on addnew
		public void clickaddnew() {
			this.addnew.click();
		}
		
		
		
		
		//enter valid credentials in enter title and textbox
		public void entertitle()
		{
         this.title.sendKeys("prestige");
         driver.findElement(By.id("content")).sendKeys("hometown");
		}
		//Click on checkbox beside added Feature and region
		public void checkboxes()
		{
         this.feature.click();
         this.region.click();
         
		}
		//click publish
		public void clickpublish()
		{
         this.publish.click();
         
         
		}
		//Checking the expected result
		public String confirmsg()
		{
		
		String s=conmsg.getText();
		return s;
	}
}


