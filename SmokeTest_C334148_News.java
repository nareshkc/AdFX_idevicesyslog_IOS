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
public class SmokeTest_C334148_News extends Driver{
	public void verify_adpresent_onextendedMap_page() throws InterruptedException
	{
		
		Ad.findElement(By.name("Back")).click();
		IOSElement News = (IOSElement) Ad.findElement(By.name("News"));
		System.out.println("Element Name is ::" + "News page");
		for(int page =1 ; page<=3;page++)
		{
			if(News.isDisplayed())
			{   System.out.println("News page is displyaed and tapping on News Image");
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[13]/UIACollectionView[1]/UIACollectionCell[1]").click();
				//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[8]/UIAButton[1]
				if(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]").isDisplayed())
				{
					System.out.println("Add present on Extended News page");
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
