//To Verify whether application allows admin to Add multiple New Feature in the application
package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.trianing.waits.WaitTypes;

public class rec79multiplefeaturePOM {
	
		private WebDriver driver; 
		private WaitTypes wt;
		
		public rec79multiplefeaturePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			wt = new WaitTypes(driver);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
		private WebElement propertylink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[4]/a")
		private WebElement features; 
		
		@FindBy(id="tag-name")
		private WebElement name; 
		
		@FindBy(id="tag-slug")
		private WebElement slug;
		
		@FindBy(id="parent")
		private WebElement parentfeature;
		
		@FindBy(id="tag-description")
		private WebElement description;
		
		@FindBy(id="submit")
		private WebElement publish;
		
		@FindBy(id="the-list")
		private WebElement featureTable; 
		
		@FindBy(id="tag-search-input")
		private WebElement searchfeature;

		//Finding the search button
		@FindBy(id="search-submit")
		private WebElement searchBtn; 
		
		
		//Click on Properties tab
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.propertylink).build().perform();
		}
		//Click on features
		public void clickaddnew() {
			this.features.click();
		}
		
		
		
		
		//enter valid credentials in enter title and slug
		public void entercredential(String nam,String slu)
		{
         this.name.sendKeys(nam);
         this.slug.sendKeys(slu);
		}
		//select parent feature and enter description
		public void entercredential1(String feature,String desc)
		{
			//JavascriptExecutor je = (JavascriptExecutor) driver;
			Select dropdown=new Select(parentfeature);
			//JavascriptExecutor je = (JavascriptExecutor) driver;
			
			 dropdown.selectByVisibleText(feature);
			//je.executeScript("arguments[0].scrollIntoView(true);",feature);
			 this.description.sendKeys(desc);
		}
		//clcik publish
		public void addnewfeature()
		{
			this.publish.click();
         
         
		}
		
		//click refresh
		public void refresh()
		{
			driver.navigate().refresh();
         
         
		}
		
		//Enter Search Item
		public void enterSearchItem(String feaName) {
			wt.presenceElementLocated1(this.searchfeature, 5).sendKeys(feaName);
			//this.searchRegion.sendKeys(regionName);
		}

		//Click on the Search feature Button
		public void clickOnSearchRegionBtn() {
			wt.elementToBeClickable1(this.searchBtn, 5).click();
		} 
		
			public boolean searchForAddedfeature(String feaName) {
				List<WebElement> reg = wt.presenceElementLocated1(this.featureTable, 5).findElements(By.xpath("//tbody[@id='the-list']//tr"));
				int count = reg.size();
				boolean flag = false;
				for(int i=0; i<count; i++) {
					WebElement myfeature = reg.get(i).findElement(By.xpath("//tbody[@id='the-list']//tr[" + (i+1) + "]//td[1]"));
					String myfeaText = wt.presenceElementLocated1(myfeature, 5).getText().trim();
					System.out.println(myfeaText);
					if(feaName.equals(myfeaText)) {
						System.out.println("This is my feature..." + myfeaText);
						flag = true;
						break;
					}
				}
				if(flag) {
					return true;
				} else {
					return false;
				}
			} 
	}



