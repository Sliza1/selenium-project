//To verify whether application allows admin to create property details based by adding feature & regions
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
		private WebElement regionsTable; 
		
		@FindBy(id="tag-search-input")
		private WebElement searchRegion;

		//Finding the search button
		@FindBy(id="search-submit")
		private WebElement searchBtn; 
		
		
		//Click on Properties tab
		public void mouseoverpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.propertylink).build().perform();
		}
		//Click on addnew
		public void clickaddnew() {
			this.features.click();
		}
		
		
		
		
		//enter valid credentials in enter title and textbox
		public void entercredential(String nam,String slu)
		{
         this.name.sendKeys(nam);
         this.slug.sendKeys(slu);
		}
		//Click on checkbox beside added Feature and region
		public void entercredential1(String feature,String desc)
		{
			//JavascriptExecutor je = (JavascriptExecutor) driver;
			Select dropdown=new Select(parentfeature);
			//JavascriptExecutor je = (JavascriptExecutor) driver;
			
			 dropdown.selectByVisibleText(feature);
			//je.executeScript("arguments[0].scrollIntoView(true);",feature);
			 this.description.sendKeys(desc);
		}
		
		public void addnewfeature()
		{
			this.publish.click();
         
         
		}
		
		//click publish
		public void refresh()
		{
			driver.navigate().refresh();
         
         
		}
		//Checking the expected result
		//Enter Search Item
		public void enterSearchItem(String regionName) {
			wt.presenceElementLocated1(this.searchRegion, 5).sendKeys(regionName);
			//this.searchRegion.sendKeys(regionName);
		}

		//Click on the Search Region Button
		public void clickOnSearchRegionBtn() {
			wt.elementToBeClickable1(this.searchBtn, 5).click();
		} 
		
			public boolean searchForAddedRegion(String regionName) {
				List<WebElement> regions = wt.presenceElementLocated1(this.regionsTable, 5).findElements(By.xpath("//tbody[@id='the-list']//tr"));
				int count = regions.size();
				boolean flag = false;
				for(int i=0; i<count; i++) {
					WebElement myRegion = regions.get(i).findElement(By.xpath("//tbody[@id='the-list']//tr[" + (i+1) + "]//td[1]"));
					String myRegionText = wt.presenceElementLocated1(myRegion, 5).getText().trim();
					System.out.println(myRegionText);
					if(regionName.equals(myRegionText)) {
						System.out.println("This is the region I was looking for..." + myRegionText);
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



