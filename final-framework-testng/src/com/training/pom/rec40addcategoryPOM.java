//To verify whether application allows admin to add new category
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rec40addcategoryPOM {
	private WebDriver driver; 
	
	public rec40addcategoryPOM(WebDriver driver) {
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
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement addnew;
	@FindBy(xpath="//*[@id=\"title\"]")
	private WebElement title; 
	@FindBy(id="in-category-1")
	private WebElement checkbox; 
	@FindBy(id="publish")
	private WebElement publish;
	@FindBy(xpath="//*[@id=\"message\"]/p/a")
	private WebElement viewpost; 
	//Click on Posts link
	public void mouseoverpost()
	{
     Actions action=new Actions(driver);
     action.moveToElement(this.postlink).build().perform();
	}
	//Click on Categories link
	//Enter Valid Credentials in Name,slug and description textbox
	public void clickallpost() {
		this.category.click();
		name.sendKeys("townhall");
		slug.sendKeys("cityhall");
		describe.sendKeys("this is test");
	}
	//Click on Add New Category button
	public void submit() {
		this.submit.click();
		driver.navigate().refresh();
	}
	
	//click add new
	public void clickaddnew() {
		this.addnew.click();
		title.sendKeys("January");
		driver.findElement(By.id("content")).sendKeys("material is good");
	}
	
	//public void frame() {
		//driver.switchTo().frame(0);
		//driver.findElement(By.xpath("//*[@id=\"tinymce\"]")).sendKeys("defed");
		//driver.switchTo().defaultContent();
		
	//}
	
	//Click on Checkbox beside created category name of category section
	public void clickcheckbox() {
		this.checkbox.click();
		
	}
	//clcik publish
	public void publish() {
		
		this.publish.click();
	}
	//click view post
	public void clickviewpost() {
		this.viewpost.click();
		
	}
	
	//Checking expected
	public String confirm() {
		String s=driver.findElement(By.linkText("January")).getText();
		return s;
	}
}



