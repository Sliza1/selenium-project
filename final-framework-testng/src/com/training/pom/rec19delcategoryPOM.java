//TO Verify whether application allows admin to delete category from the categories page
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class rec19delcategoryPOM {
	
		private WebDriver driver; 
		
		public rec19delcategoryPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
		private WebElement postlink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
		private WebElement category; 
		
		@FindBy(id="cb-select-149")
		private WebElement checkbox; 
		
		@FindBy(id="bulk-action-selector-top")
		private WebElement action; 
		
		@FindBy(id="doaction")
		private WebElement apply;
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement delmsg;
		
		
		
		//Click on Posts link
		
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.postlink).build().perform();
		}
		//Click on Categories link
		//Click on the checkbox of the category to be deleted
		public void clickallpost() {
			this.category.click();
			this.checkbox.click();
			
		}
		//Click on Bulk Action list box
		//Select Delete in Bulk Action links
		
		public void delete() {
			Select dropdown=new Select(action);
			dropdown.selectByVisibleText("Delete");	
			apply.click();
		
		}
		//chekcing expected
		public String confirm() {
			String s=delmsg.getText();
			return s;
		}
		
		
		
		
			}


