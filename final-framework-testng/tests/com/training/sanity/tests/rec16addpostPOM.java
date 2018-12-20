package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec16addpostPOM {
	
		private WebDriver driver; 
		
		public rec16addpostPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
		private WebElement postlink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[2]/a")
		private WebElement allpost; 
		
		@FindBy(xpath="//*[@id=\"post-2633\"]/td[1]/strong")
		private WebElement particularpost; 
		
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement delmsg;
		
		@FindBy(xpath="")
		private WebElement trash;
		
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.postlink).build().perform();
		}
		public void clickallpost() {
			this.allpost.click();
		}
		
		
		
		
		
		public void mouseoverparticularpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.particularpost).build().perform();
		}
		
		public void trash()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.trash).build().perform();
         trash.click();
		}
		public String confirmsg()
		{
		String expected="1 post moved to the Trash.Undo";
		String s=delmsg.getText();
		return s;
	}
}


