package com.weather.SmokeTestcases;

import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334147_Map extends Driver{

	public void verify_adpresent_onextendedMap_page() throws InterruptedException
	{
		//Thread.sleep(1000);
		Ad.findElement(By.name("Back")).click();
		IOSElement Map = (IOSElement) Ad.findElement(By.name("Maps"));
		System.out.println("Element Name is ::" + "Maps Page");
		for(int page =1 ; page<=2;page++)
		{
			
			if(Map.isDisplayed())
			{
				if(!Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[8]/UIAButton[1]").isDisplayed())
				{
				System.out.println("Map element is not present");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
				}
				//Ad.findElementByName("map play").click();
				System.out.println("Map page is displyaed and tapping on Map button");
				
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[8]/UIAButton[1]").click();
				if(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").isDisplayed())
				{
					System.out.println("Add present on Extended Map page");
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
