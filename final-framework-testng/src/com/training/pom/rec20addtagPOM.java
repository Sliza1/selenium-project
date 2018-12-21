//TO Verify whether application allows admin to add new tag
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec20addtagPOM {
	
		private WebDriver driver; 
		
		public rec20addtagPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
		private WebElement postlink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[5]/a")
		private WebElement tag; 
		
		@FindBy(id="tag-name")
		private WebElement name; 
		
		@FindBy(id="tag-slug")
		private WebElement slug;
		
		@FindBy(id="tag-description")
		private WebElement describe;
		
		@FindBy(id="submit")
		private WebElement submit;
		//Click on Posts link
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.postlink).build().perform();
		}
		//Click on Tags link
		//Enter Valid Credentials in Name,slug and description textbox
		public void clickallpost() {
			this.tag.click();
			name.sendKeys("abc");
			slug.sendKeys("launch");
			describe.sendKeys("new launches of villas");
		}
		
		
		
		//Click on Add New Tag button
		public void submit() {
			this.submit.click();
			driver.navigate().refresh();
			
		}
		//checking expected results
		
		public String confirm() {
			String s=driver.findElement(By.linkText("abc")).getText();
			return s;
		}
	}


