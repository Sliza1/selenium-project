//To verify whether application allows admin to add new property with all details & added property details in home screen for user
package com.training.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class rec80multipleusers2 {
	
		private WebDriver driver; 
		
		public rec80multipleusers2(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
		private WebElement propertylink; 
		
		@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[3]/a")
		private WebElement addnew;
		
		@FindBy(id="title")
		private WebElement entertitle;
		
		@FindBy(id="content")
		private WebElement entercontent;
		
		@FindBy(id="_price")
		private WebElement enterprice;
		
		@FindBy(id="_price_per")
		private WebElement enterpriceper;
		
		
		
		@FindBy(id="ui-id-2")
		private WebElement maindetails;
		
		@FindBy(id="_status")
		private WebElement enterstatus;
		
		@FindBy(id="_location")
		private WebElement enterlocation;
		
		@FindBy(id="_possession")
		private WebElement enterposession;
		
		@FindBy(id="ui-id-3")
		private WebElement loctab;
		
		@FindBy(id="_friendly_address")
		private WebElement enteraddress;
		
		@FindBy(id="_address")
		private WebElement map;
		
		@FindBy(id="_geolocation_lat")
		private WebElement lat;
		
		@FindBy(id="_geolocation_long")
		private WebElement longitude;
		
		@FindBy(id="ui-id-4")
		private WebElement detailtab;
		
		@FindBy(id="_storage_room")
		private WebElement storageroom;
		
		@FindBy(id="in-property_feature-422")
		private WebElement feature;
		
		@FindBy(id="in-region-24")
		private WebElement region;
		
		@FindBy(name="publish")
		private WebElement clickpublish;
		
		@FindBy(xpath="//*[@id=\"wp-admin-bar-my-account\"]/a/span")
		private WebElement logout;
		
		@FindBy(xpath="//*[@id=\"wp-admin-bar-logout\"]/a")
		private WebElement clicklogout;
		
		@FindBy(xpath="//*[@id=\"logo\"]/h2/a")
		private WebElement estateicon; 
		
		@FindBy(name="phrase")
		private WebElement search; 
		
		@FindBy(xpath="//*[@id=\"mCSBap_1_container\"]/div/div[1]/div[1]/h3/a/span")
		private WebElement searchpro;
		
		
		
		//mouseover to post link
		
		
		
		
		
		//Click on Properties tab
		public void mouseoverparticularpost()
		{
         Actions action=new Actions(driver);
         action.moveToElement(this.propertylink).build().perform();
		}
		//Click on add new link
		public void addnewuser()
		{
         
         addnew.click();
		}
		
		//enter valid text in enter title here,textbox, price and price per sq metre
		public void entercrdentials(String a,String b,String c,String d)
		{
         
         entertitle.sendKeys(a);
         entercontent.sendKeys(b);
         enterprice.sendKeys(c);
         enterpriceper.sendKeys(d);
       
         
		}
		
		//Click main details tab and enter valid text in status, location and possession
		public void maindetailstab(String e,String f,String g  ) 
		{
         maindetails.click();
         enterstatus.sendKeys(e);
         enterlocation.sendKeys(f);
         enterposession.sendKeys(g);
         
         }
		
		//Click location tab and enter valid text in enter address, map,latitude and longitude
		public void locationtab(String h,String i,String j,String k  )
		{
			loctab.click();
			enteraddress.sendKeys(h);
	         map.sendKeys(i);
	         lat.sendKeys(j);
	         longitude.sendKeys(k);
			
	         
			}
		
		//Click detail tab and enter text in storage room textbox
		public void detailtab(String l  )
		{
			detailtab.click();
			storageroom.sendKeys(l);
	         
		}
		//Click on feature and region textboxes
		public void checkboxes()
		{
			//this.feature.click();
			this.region.click();
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500)", "");
			this.feature.click();
	         
		}
		//click publish icon
		public void publish()
		{
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500)", "");
			this.clickpublish.click();
			
		}
		//Admin logs out
		public void logoff()
		{
			Actions action=new Actions(driver);
	         action.moveToElement(this.logout).build().perform();	
	         clicklogout.click();
		}
		//Click realestate icon from home screen and search for the added property.
		public void estate(String m)
		{
			this.estateicon.click();
			search.sendKeys(m);
			searchpro.click();
			
		}
		//Control switches to next tab and checks whether the details of added property
		public String checkexpected()
		{
			//String handle = driver.getWindowHandle();
			 //driver.switchTo().window(handle);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			 String s=driver.findElement(By.cssSelector("#titlebar > div > div > div > div.property-title > h2")).getText();
			return s;
			 
				
		}
		
		
		
}



