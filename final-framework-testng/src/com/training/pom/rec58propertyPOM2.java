//To verify whether application allows  admin to add the post into trash
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class rec58propertyPOM2 {
	
		private WebDriver driver; 
		
		
		public rec58propertyPOM2(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-item-617\"]/a")
		private WebElement blog; 
		
		@FindBy(xpath="//*[@id=\"post-3425\"]/div/a")
		private WebElement readmore; 
		
		@FindBy(id="comment")
		private WebElement comments;
		
		
		
		@FindBy(xpath="//*[@id=\"comment-1801\"]/td[1]/strong/img")
		private WebElement mouseovercomment;
		
		@FindBy(xpath="//*[@id=\"post-3015\"]/td[1]/strong")
		private WebElement mouseover;
		@FindBy(xpath="//*[@id=\"comment-1801\"]/td[2]/div[3]/span[3]/a")
		private WebElement reply;
		@FindBy(id="replycontent")
		private WebElement content;
		@FindBy(id="replybtn")
		private WebElement buttonreply;
		//click blog tab//Click on Read More link of post added by admin//enter details/Click on Post Comment button
		public void clickblog()
		{
         this.blog.click();
         this.readmore.click();
         this.comments.sendKeys("today is Monday");
         driver.findElement(By.id("author")).sendKeys("Mun2");
         driver.findElement(By.id("email")).sendKeys("Mun2@gmail.com");
         driver.findElement(By.id("submit")).click();
		}
		//open admin site and login//click on Comments tab
		public void newwindow()
		{
			//String  handle= driver.getWindowHandle();
			//driver.switchTo().window(handle);
			//WebDriver driver=new ChromeDriver();
			driver.get("http://realestate.hommelle.com/admin");
			driver.findElement(By.id("user_login")).sendKeys("admin");
			driver.findElement(By.id("user_pass")).sendKeys("admin@123");
			driver.findElement(By.name("login")).click();
			
			driver.findElement(By.cssSelector("#menu-comments > a > div.wp-menu-name")).click();
		}
		
		//Mouse over comments//Click on Reply icon//enter details and again click reply
		public void entercredentials() 
		{
			 Actions action=new Actions(driver);
		     action.moveToElement(this.mouseovercomment).build().perform();
		     this.reply.click();
		     this.content.sendKeys("mat19");
		     this.buttonreply.click();
		}
		//expected result
		public int entercredentials1() 
		{
		     String a=driver.findElement(By.xpath("//*[@id=\"comment-1801\"]/td[3]/div/span/a[1]/span[1]")).getText();
		     int i = Integer.parseInt(a);
		     int exp= i+1;
		     return exp;
		}
		//page refresh done to get update results in response icon
		public void entercredentials2() 
		{
		     driver.navigate().refresh();
		}
		//checking actual results
		public int entercredentials3() 
		{  
		     
		     String j=driver.findElement(By.xpath("//*[@id=\"comment-1801\"]/td[3]/div/span/a[1]/span[1]")).getText();
		     int act=Integer.parseInt(j);
		     return act;
		}
		
		
			
		     
		//}
}


