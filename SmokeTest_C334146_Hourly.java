package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weather.driver.Driver;
//import com.weather.excel.WriteResultintoExcel;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334146_Hourly extends Driver{

	public void verify_adpresent_onextendedHourly_page() throws InterruptedException
	{
		
		IOSElement hrly = (IOSElement) Ad.findElement(By.name("Hourly"));
		System.out.println("Element Name is :: Hourly" );
		//WriteResultintoExcel wResult = new WriteResultintoExcel();
		for(int page =1 ; page<=3;page++)
		{
		if(hrly.isDisplayed())
		{ 
			System.out.println("Hourly page is displyaed and tapping on MORE button");
			Ad.findElementByName("MORE").click();
			Boolean loaded = true;
			WebDriverWait wait = new WebDriverWait(Ad, 4);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]")));
			
			if(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").isDisplayed())
			{
				//WebDriverWait wait = new WebDriverWait(Ad,7); 
				//wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("UIAImage"))));
				System.out.println("Add present on Extended Hourly page");
				
				
			}
			
		}else
		{
			System.out.println("element is not present");
			JavascriptExecutor js = (JavascriptExecutor) Ad ;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		}
		}
	}
	
}
