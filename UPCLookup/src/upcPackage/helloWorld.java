package upcPackage;

import java.awt.List;

import org.apache.bcel.generic.Select;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import bsh.Console;


public class helloWorld {

	public static void  main (String[] args){
		
		String str[] = {"12345","123456789","123456789012"};
		String newString;
		
//for less than 8	

		for(int i=0; i<str.length;i++)
		{
			newString =str[i] ;		
			StringBuilder sb = new StringBuilder();
		
			for (int n=8-newString.length(); n>0; n--) 
			{
				sb.append('0');
			}
			sb.append(newString);
			str[i] = sb.toString();
			System.out.println(str[i]);
		}
	
//for less than 8,12,13
		/*
		for(int i=0; i<str.length;i++)
		{
		
			newString =str[i] ;	
			StringBuilder sb = new StringBuilder();
			int c = newString.length();
			if(c<13 && c>=12)
			{
				for (int n=13-newString.length(); n>0; n--) 
				{
				    sb.append('0');
				}

				sb.append(newString);
				str[i] = sb.toString();
				System.out.println(str[i]);
			}
			else if (c<12 && c>=8) 
			{	
				for (int n=12-newString.length(); n>0; n--) 
				{
					sb.append('0');
				}

				sb.append(newString);
				str[i] = sb.toString();
				System.out.println(str[i]);
			}
			else if (c<8)
			{
				for (int n=8-newString.length(); n>0; n--) 
				{
					sb.append('0');
				}

				sb.append(newString);
				str[i] = sb.toString();
				System.out.println(str[i]);
			}
		}
		*/
		
	WebDriver driver1 = new FirefoxDriver();
	driver1.get("http://qualitytestified.blogspot.com");
	String i= driver1.getCurrentUrl();
	System.out.println(i);
	driver1.close();

		
/*	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.cellartracker.com");
	
	//Select upcDD = new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("selected_search")));
	
	
	
	
	
	
	WebElement upcDropdown = driver.findElement(By.id("selected_search"));
	//System.out.println(upcDropdown.getText());
	//if(upcDropdown.getText() != "Wines")
	/*{
		List<WebElement> allOptions = upcDropdown.findElements(By.tagName("id"));
		for(WebElement id: allOptions){
			System.out.println(String.format("Value is :", id.getAttribute("value")));
	} */
		
	}
	
	
	
//	driver.close();
	

}
