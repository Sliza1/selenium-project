//To verify whether application allows  admin to add the post into trash
package com.training.pom;

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
		
		@FindBy(xpath="//*[@id=\"post-2631\"]/td[1]/strong/a")
		private WebElement particularpost; 
		
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement delmsg;
		
		@FindBy(xpath="//*[@id=\"post-2631\"]/td[1]/div[3]/span[3]/a")
		private WebElement trash;
		//mouseover to post link
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.postlink).build().perform();
		}
		//Click all post link
		public void clickallpost() {
			this.allpost.click();
		}
		
		
		
		
		//mouse over to particular post
		public void mouseoverparticularpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.particularpost).build().perform();
		}
		//Click on Trash link
		public void trash()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.trash).build().perform();
         trash.click();
		}
		//Checking the expected result
		public String confirmsg()
		{
		
		String s=delmsg.getText();
		return s;
	}
}


