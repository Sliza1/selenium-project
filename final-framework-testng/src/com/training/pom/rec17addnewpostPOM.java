//TO Verify whether application allows admin to add new post into list
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec17addnewpostPOM {
	private WebDriver driver; 
	
	public rec17addnewpostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
	private WebElement postlink; 
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement addnew; 
	
	@FindBy(xpath="//*[@id=\"title\"]")
	private WebElement title; 
	
	
	@FindBy(xpath="//*[@id=\"message\"]/p")
	private WebElement delmsg;
	
	@FindBy(id="publish")
	private WebElement publish;
	//Click on Posts link
	public void mouseoverpost()
	{
     Actions action=new Actions(driver);
     action.moveToElement(this.postlink).build().perform();
	}
	//Click on addnew link
	//Enter Valid credentials in Enter title here textbox
	public void clickallpost() {
		this.addnew.click();
		title.sendKeys("sun");
		driver.findElement(By.id("content")).sendKeys("strat");
	}
	//Enter valid credentials in body textbox
	//public void frame() {
		//driver.switchTo().frame(0);
		//driver.findElement(By.xpath("//*[@id=\"tinymce\"]")).sendKeys("defed");
		//driver.switchTo().defaultContent();
		
	//}
	//Click on Publish button
	public void publish() {
		this.publish.click();
	}
	//checking expected results
	public String confirmsg()
	{
	
	String s=delmsg.getText();
	return s;
}
	
	
	
	//public void clickhello() {
		//this.allpost.click();
	//}
}



