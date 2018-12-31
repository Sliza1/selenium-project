//To verify whether application allows to search details & fill enquiry details in Commercial tab
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class retc34POM {
	
		private WebDriver driver; 
		
		public retc34POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-item-513\"]/a")
		private WebElement commercial; 
		@FindBy(xpath="//*[@id=\"ajaxsearchlite2\"]/div/div[3]/form/input[1]")
		private WebElement search; 
		@FindBy(xpath="//*[@id=\"mCSBap_2_container\"]/div/div[1]/div[1]/h3/a/span")
		private WebElement searchapartment; 
		@FindBy(xpath="//*[@id=\"text-4\"]/div/div/p[2]/a")
		private WebElement drop; 
		@FindBy(name="name")
		private WebElement entername; 
		@FindBy(name="email")
		private WebElement enteremail; 
		@FindBy(name="subject")
		private WebElement entersubject;
		@FindBy(xpath="//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[3]/span/textarea")
		private WebElement entermessage; 
		@FindBy(xpath="//*[@id=\"wpcf7-f119-p134-o1\"]/form/p/input")
		private WebElement send;
		//@FindBy(cssSelector="//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[4]")
		//private WebElement thankumessage;
		
		//Click on Commercial tab
		public void clickcommercial()
		{
         this.commercial.click();
		}
		//click on search button.Enter details of apartment in search box.Click on Nullam hendrerit apartment link
		public void clicksearch()
		{
         this.search.click();
         this.search.sendKeys("Nullam hendrerit apartment");
         this.searchapartment.click();
         
		}
		//switch tabs and Click on Drop Us a Line Link
		public void clickdrop()
		{
			String handle = driver.getWindowHandle();
			 driver.switchTo().window(handle);
         this.drop.click();
		}
		//Enter valid details in Your Name,email address and subject textbox
		public void enterdetails()
		{
		 
         this.entername.sendKeys("selec");
         this.enteremail.sendKeys("selec@gmail.com");
         this.entersubject.sendKeys("housings");
         this.entermessage.sendKeys("looking for housings");
		}
		//Scroll bottom of the page and click send button
		public void clicksend()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView();", send);
         this.send.click();
		}
		
		//Check expected
		public String message()
		{
		 
         String s=driver.findElement(By.cssSelector("#wpcf7-f119-p134-o1 > form > div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ok")).getText();
         return s;
		}
}


