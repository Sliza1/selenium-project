package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec17addnewpost {
	private WebDriver driver; 
	
	public rec17addnewpost(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
	private WebElement postlink; 
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement addnew; 
	
	@FindBy(xpath="//*[@id=\"title\"]")
	private WebElement title; 
	
	@FindBy(xpath="//HTML[@lang='en-US']")
	private WebElement bodytitle;
	
	@FindBy(id="publish")
	private WebElement publish;
	
	public void mouseoverpost()
	{
     Actions action=new Actions(driver);
     action.moveToElement(this.postlink).build().perform();
	}
	public void clickallpost() {
		this.addnew.click();
		title.sendKeys("New launches");
		bodytitle.sendKeys("New launch in home");
	}
	
	public void publish() {
		this.publish.click();
	}
	
	
	
	
	//public void clickhello() {
		//this.allpost.click();
	//}
}



