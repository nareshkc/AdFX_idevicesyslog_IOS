package com.weather.SmokeTestcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334150_Verify_onpulltorefresh extends Driver{

	public void Verify_PulltoRefresh() throws IOException, InterruptedException
	{
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");

		MobileElement el = (MobileElement) Ad.findElementByName("_aCurTempLabel");
		MobileElement el1 = (MobileElement) Ad.findElementByName("_aHiLowLabel");
		//_aHiLowLabel_aWxCheckinButton");
		TouchAction action1 = new TouchAction(Ad);
		action1.longPress(el).moveTo(el1).release().perform();
		System.out.println("Scroll Done");

		//Get the BB ad and validate it
		String[] str ={"/bin/bash", "-c", "idevicesyslog | grep Requesting ad: /7646/app_iphone_us/display/bb with parameters >> /Users/aparna/Documents/sys1.log"};


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

			if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/bb")){
				// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
				//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
				String req1 = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/bb with parameters: {"));
				String	req = req1.substring(req1.indexOf("{")+1,req1.indexOf("}"));
				System.out.println("Request is ::"+req1);
				if(req1.contains("/7646/app_iphone_us/display/bb"))
				{
					System.out.println("Verified Branded Background  Values are present");
				}


				System.out.println("Case Ended");
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


