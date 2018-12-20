package com.training.sanity.tests;

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
		
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.postlink).build().perform();
		}
		public void clickallpost() {
			this.tag.click();
			name.sendKeys("new launches");
			slug.sendKeys("launch");
			describe.sendKeys("new launches of villas,appartments");
		}
		
		
		
		
		public void submit() {
			this.submit.click();
		}
	}


