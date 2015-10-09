package com.weather.SmokeTestcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334143_CleanLaunch extends Driver{

	public void verify_adcals_onclean_launch() throws InterruptedException, IOException
	{

		//Scroll the app
		//pageScrolling.Scroll();
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");


		MobileElement Screen = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//is number of cells/rows inside table correct
		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");
		System.out.println("page Size is "+ pages.size());
		int x = pages.size();
		System.out.println("page size is ::"+ x);
		System.out.println("User on first page::");
		
		//Scroll JS
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		//Scrolling to feed_1
		Ad.findElementByName("_aCurTempLabel").click();

		for(int FeedValue=0;FeedValue<=pages.size();FeedValue++)
		{
			String[] str ={"/bin/bash", "-c", "idevicesyslog | grep Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue+ "with parameters >> /Users/aparna/Documents/sys1.log"};


			Process p = Runtime.getRuntime().exec(str);

			Thread.sleep(5000);
			System.out.println("Writing is completed  :" + p.exitValue());
			BufferedReader r = new BufferedReader(new FileReader("/Users/aparna/Documents/sys1.log"));

			String line = "";
			String allLine = "";

			while((line=r.readLine()) != null)
			{
				System.out.println("Sys data is ::"+line);
			}

			String FilePath = "/Users/aparna/Documents/sys1.log";

			Map<String, String> mapkeys = new HashMap<String, String>();

			try {
				FileInputStream fstream = new FileInputStream(FilePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						fstream));
				String strLine;
				// / read log line by line ------ strLine = br.readLines(6, 10); /
				StringBuffer sb = new StringBuffer("");
				while ((strLine = br.readLine()) != null) {
					// parse strLine to obtain what you want /
					//System.out.println (strLine);
					sb.append(strLine);

				}

				if(FeedValue==0)
				{if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/bb")){
					// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
					//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
					String req1 = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/bb with parameters: {"));
					String	req = req1.substring(req1.indexOf("{")+1,req1.indexOf("}"));
					System.out.println("Request is ::"+req1);
					if(req1.contains("/7646/app_iphone_us/display/bb"))
					{
						System.out.println("Verified Branded Background  Values are present");
					}
				}else

					//	Getting and taking feed cals from last				
					if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue)){
						// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
						//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
						String req1 = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue+" with parameters: {"));
						String	req = req1.substring(req1.indexOf("{")+1,req1.indexOf("}"));
						System.out.println("Request is ::"+req1);
						if(req1.contains("/7646/app_iphone_us/display/feed/feed_"+FeedValue))
						{
							System.out.println("Verified Feed_ "+FeedValue+" Values are present");
						}
					}
			
				
				js.executeScript("mobile: scroll", scrollObject);
				//			      
				//			      
				//			      String[] arrays = req.split(";");
				//			      System.out.println("Verifing the "+req);
				//			      for(String keys : arrays){
				//			    	  System.out.println(keys);
				//			    	  if(keys.contains("=")){
				//			    		  String[] key = keys.split("=");
				//				    	 // System.out.println(key[0] + "---"+key[1]);
				//				    	  mapkeys.put(key[0], key[1]);
				//			    	  }
				//			    	  
				//			    	  
				//			      }
				//			      for(Entry<String, String> entryKeys : mapkeys.entrySet()){
				//			    	  System.out.println("key : "+entryKeys.getKey() + "----"+"value:"+entryKeys.getValue());
				//			      }
				//			 
				//						 }
				//					 br.close();
				//
				//				} catch (Exception e) {
				//					e.printStackTrace();
				//				}

				System.out.println("Case Ended");
				}
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

