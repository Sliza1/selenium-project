package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class rec19delcategory {
	
		private WebDriver driver; 
		
		public rec19delcategory(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
		private WebElement postlink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
		private WebElement category; 
		
		@FindBy(id="cb-select-133")
		private WebElement checkbox; 
		
		@FindBy(id="bulk-action-selector-top")
		private WebElement action; 
		
		@FindBy(id="doaction")
		private WebElement apply;
		
		
		
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.postlink).build().perform();
		}
		public void clickallpost() {
			this.category.click();
			this.checkbox.click();
			
		}
		
		public void delete() {
			Select dropdown=new Select(action);
			dropdown.selectByVisibleText("Delete");	
			apply.click();
		
		}
		
		
		
		
			}


