package com.weather.SmokeTestcases;

import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334151_10Days extends Driver{


	public void verify_adpresent_onextendedTendays_page() throws InterruptedException
	{
		//Thread.sleep(1000);
		Ad.findElement(By.name("Back")).click();
		IOSElement Tendays = (IOSElement) Ad.findElement(By.name("10 Day"));
		System.out.println("Element Name is ::" + "10 Days Page");
		for(int page =1 ; page<=2;page++)
		{
			if(Tendays.isDisplayed())	
			{ 
				System.out.println("10Days page is displyaed and tapping on EXTENDED FORECAST button");
				Thread.sleep(1000);
				Ad.findElement(By.name("EXTENDED FORECAST")).click();
				if(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").isDisplayed())
				{
					System.out.println("Add present on Extended 10 Days page");
					//System.out.println("Add size is :: " + Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").getAttribute("size"));
				}break;

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
