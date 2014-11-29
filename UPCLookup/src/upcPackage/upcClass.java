package upcPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class upcClass {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		
		WebDriver ctDriver = new FirefoxDriver();
		
		
		ctDriver.get("https://www.cellartracker.com/password.asp?Referrer=%2FDefault%2Easp%3F");
		//ctDriver.manage().window().maximize();
		
		
		WebElement ctHandle = ctDriver.findElement(By.id("handle"));
		WebElement ctPassword = ctDriver.findElement(By.id("password"));
		WebElement ctSignIn = ctDriver.findElement(By.id("sign_in"));
		
		
		ctHandle.sendKeys("M S Ansari");
		ctPassword.sendKeys("quality1234");
		ctSignIn.click();
		
		
		//Reading the input file
		String InputFile = ".//InputFiles/input.txt";
		FileReader FR = new FileReader(InputFile);
		BufferedReader BR = new BufferedReader(FR);
		String upcCode = "";
		
		
		//Writing in output file
		String filePath = ".//OutputFiles/Test1.txt";
		File UO = new File(filePath);
		UO.createNewFile();
		FileWriter FW = new FileWriter(filePath);
		BufferedWriter BW = new BufferedWriter(FW);
		
		//int n = 0;
		
		
		while ((upcCode = BR.readLine())!= null)
		{	
			System.out.println("Before Fn: " + upcCode);
			if (upcCode.length() != 12){
				upcCode = upcChange(upcCode);				
			}

			System.out.println("After Fn: " + upcCode);

			
			ctDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			WebElement ctInbox = ctDriver.findElement(By.xpath(".//*[@id='search_text']"));
			WebElement ctSubmit = ctDriver.findElement(By.xpath(".//*[@id='search_submit']"));
			ctInbox.sendKeys(upcCode);
			ctSubmit.click();
			
			boolean present;
			try {
				ctDriver.findElement(By.xpath(".//*[@id='wine_copy_inner']/h1"));
				present = true;
			} catch (NoSuchElementException e){
				present = false;
			}
			
			if (present){
				String ctWineName = ctDriver.findElement(By.xpath(".//*[@id='wine_copy_inner']/h1")).getText();
				String ctWineType = ctDriver.findElement(By.xpath(".//*[@id='wine_copy_inner']/h2/a[1]")).getText();  // + ctDriver.findElement(By.xpath(".//*[@id='wine_copy_inner']/h2/a[2]")).getText();
				String ctWineRegion = ctDriver.findElement(By.xpath(".//*[@id='wine_copy_inner']/ul/li[1]/a")).getText(); // + ctDriver.findElement(By.xpath(".//*[@id='wine_copy_inner']/ul/li[2]/a")).getText();
			
				BW.write(upcCode + "@" + ctWineName + "@@" + ctWineType + "@" + ctWineRegion + "@@");
				BW.newLine();	
			}
			else if (){
				//this includes recursive logic
				
				
				
			}
			else
			{
				BW.write(upcCode + "@@@@@@");
				BW.newLine();
			}
			
			

			//System.out.println("Loop " + n +" ends.");
			//n=n+1;
			
		}
				
		BW.close();
		ctDriver.close();
		
	}

	private static String upcChange(String upcCode) {
		
		int upcCodeLength = upcCode.length();
		StringBuilder SB = new StringBuilder();
		
		if(upcCodeLength < 8 && upcCodeLength > 0)
		{
			for (int upcDiff = (8-upcCodeLength); upcDiff > 0; upcDiff--)
			{
				SB.append('0');
			}
			SB.append(upcCode);
			upcCode=SB.toString();
			return upcCode;
		}
		else if(upcCodeLength > 8 && upcCodeLength < 12)
		{
			for (int upcDiff = (12-upcCodeLength); upcDiff > 0; upcDiff--)
			{
				SB.append('0');
			}
			SB.append(upcCode);
			upcCode=SB.toString();
			return upcCode;
		}
		else if(upcCodeLength == 12)
		{
			for (int upcDiff = (13-upcCodeLength); upcDiff > 0; upcDiff--)
			{
				SB.append('0');
			}
			SB.append(upcCode);
			upcCode=SB.toString();
			return upcCode;
		}
		else{
			return upcCode;
		}
		
	}
	
	
	
}
