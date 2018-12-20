package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec18addnewcategory {
	private WebDriver driver; 
	
	public rec18addnewcategory(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
	private WebElement postlink; 
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement category; 
	
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
		this.category.click();
		name.sendKeys("New launches");
		slug.sendKeys("New launch in home");
		describe.sendKeys("New launches of villas,appartments");
	}
	
	public void submit() {
		this.submit.click();
	}
	
	
	
	
	//public void clickhello() {
		//this.allpost.click();
	//}
}



